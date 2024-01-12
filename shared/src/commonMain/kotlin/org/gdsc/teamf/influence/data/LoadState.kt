package org.gdsc.teamf.influence.data

import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retry
import kotlinx.datetime.Clock

sealed class LoadState<T >  {
    class Idle<T > : LoadState<T>()

    data class Loading<T >(
        val data: T? = null,
    ) : LoadState<T>()

    data class Success<T >(
        val data: T,
    ) : LoadState<T>() {
        var refresh: () -> Unit = {}
    }

    data class Error<T >(
        val data: T? = null,
        val error: Throwable,
    ) : LoadState<T>() {
        var retry: () -> Unit = {}

        init {
            error.printStackTrace()
            println("🚧 Error: ${error.message}")
        }
    }

    fun getOrNull(): T? = when (this) {
        is Loading -> data
        is Success -> data
        is Error -> data
        else -> null
    }

    fun exceptionOrNull(): Throwable? = when (this) {
        is Error -> error
        else -> null
    }

    fun getOrElse(defaultValue: T): T = when (this) {
        is Success -> data
        else -> defaultValue
    }

    fun <R > map(transform: (T) -> R?): LoadState<R> = when (this) {
        is Idle -> Idle()
        is Loading -> Loading(data?.let(transform))
        is Success -> {
            val mappedData = data.let(transform)
            if (mappedData == null) {
                Error(null, NullPointerException("Data is null"))
            } else {
                Success(mappedData)
            }

        }

        is Error -> Error(data?.let(transform), error)
    }

    val isLoading get() = this is Loading
    val isSuccess get() = this is Success
    val isError get() = this is Error

}

fun <T > Flow<T>.applyLoadState(defaultValue: T? = null): Flow<LoadState<T>> {

    val trigger = MutableStateFlow(0)

    val refreshOrRetry: () -> Unit = {
        trigger.tryEmit(Clock.System.now().nanosecondsOfSecond)
    }

    return trigger.flatMapConcat {
        map {
            LoadState.Success(it).apply {
                refresh = refreshOrRetry
            } as LoadState<T>
        }
            .onStart { emit(LoadState.Loading(defaultValue)) }
            .catch {
                emit(
                    LoadState.Error(
                        data = defaultValue,
                        error = it,

                        ).apply {
                        retry = refreshOrRetry
                    }
                )
            }
            .retry(3) { cause ->
                when (cause) {
                    is IOException -> {
                        delay(2000)
                        return@retry true
                    }

                    is ConnectTimeoutException, is HttpRequestTimeoutException, is SocketTimeoutException -> {
                        delay(500)
                        return@retry true
                    }

                    else -> {
                        return@retry false
                    }
                }
            }
    }
}

// like runCatching but for LoadState
suspend fun <T > runLoadState(defaultValue: T? = null, block: suspend () -> T): LoadState<T> {
    return try {
        LoadState.Success(block())
    } catch (e: Throwable) {
        LoadState.Error(defaultValue, error = e)
    }
}