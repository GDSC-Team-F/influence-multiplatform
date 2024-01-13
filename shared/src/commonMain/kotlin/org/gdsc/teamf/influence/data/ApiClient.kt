package org.gdsc.teamf.influence.data

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json


@OptIn(ExperimentalSerializationApi::class)
val defaultJson = Json {
    ignoreUnknownKeys = true
    isLenient = true
    encodeDefaults = true
    explicitNulls = false
}

@Suppress("FunctionName")
internal fun <T : HttpClientEngineConfig> ApiHttpClient(
    apiHelper: ApiHelper,
    engineFactory: HttpClientEngineFactory<T>,
    block: HttpClientConfig<T>.() -> Unit = {},
) = HttpClient(engineFactory) {
    val apiUrl = "35.216.112.80:8080"

    expectSuccess = true

    install(HttpTimeout) {
        requestTimeoutMillis = 10000L
        connectTimeoutMillis = 10000L
    }

    install(ContentNegotiation) {
        json(defaultJson)
    }

    install(Auth) {
        bearer {
//            sendWithoutRequest { authTokenManager.isExpired }
            loadTokens {
                val accessToken = apiHelper.accessToken()
                val refreshToken = apiHelper.refreshToken()

                println("⚡️ accessToken: $accessToken")
                println("⚡️ refreshToken: $refreshToken")
                if (accessToken != null && refreshToken != null) BearerTokens(accessToken, refreshToken)
                else null
            }
//            refreshTokens {
//                val refreshToken = apiHelper.refreshToken()
//
//                kotlin.runCatching {
//                    val responseAsText = client.post("https://$apiUrl/auth/refreshToken") {
//                        markAsRefreshTokenRequest()
//                        setBody(RefreshTokenRequest(refreshToken!!))
//                        contentType(ContentType.Application.Json)
//                    }.bodyAsText()
//
//                    val response = defaultJson.decodeFromString<JwtTokenResponse>(responseAsText)
//
//                    apiHelper.setToken(response)
//
//                    BearerTokens(
//                        accessToken = response.accessToken,
//                        refreshToken = response.refreshToken
//                    )
//                }
//                    .onFailure {
//
//                        apiHelper.clear()
//                    }
//                    .getOrNull()
//
//            }
        }
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                print("⚡️ $message")
            }
        }
        level = LogLevel.ALL
    }

    defaultRequest {

        headers {
            accept(ContentType.Application.Json)
            accept(ContentType.MultiPart.FormData)
        }

        url {
            protocol = URLProtocol.HTTP
            host = apiUrl
        }
    }

    block()
}