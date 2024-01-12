package org.gdsc.teamf.influence.utils
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.coroutines.repeatOnLifecycle
import com.arkivanov.essenty.lifecycle.coroutines.withLifecycle
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost

expect val LocalEssentyLifecycleOwner : ProvidableCompositionLocal<LifecycleOwner>

@Composable
fun ProvideEssentyLifecycleOwner(lifecycleOwner: LifecycleOwner, content : @Composable () -> Unit) {
    CompositionLocalProvider(LocalEssentyLifecycleOwner provides lifecycleOwner) {
        content()
    }
}

@Composable
public fun <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.collectSideEffect(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    sideEffect: (suspend (sideEffect: SIDE_EFFECT) -> Unit)
) {

    val sideEffectFlow = container.sideEffectFlow
    val lifecycleOwner = LocalEssentyLifecycleOwner.current

    LaunchedEffect(sideEffectFlow, lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(lifecycleState) {
            sideEffectFlow.collect { sideEffect(it) }
        }
    }
}

/**
 * Observe [Container.stateFlow] in a Compose [LaunchedEffect].
 * @param lifecycleState [Lifecycle.State] in which [state] block runs.
 */
@Composable
public fun <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.collectState(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    state: (suspend (state: STATE) -> Unit)
) {
    val stateFlow = container.stateFlow
    val lifecycleOwner = LocalEssentyLifecycleOwner.current

    LaunchedEffect(stateFlow, lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(lifecycleState) {
            stateFlow.collect { state(it) }
        }
    }
}
/**
 * Observe [Container.stateFlow] as [State].
 * @param lifecycleState The Lifecycle where the restarting collecting from this flow work will be kept alive.
 */
@Composable
public fun <STATE : Any, SIDE_EFFECT : Any> ContainerHost<STATE, SIDE_EFFECT>.collectAsState(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED
): State<STATE> {
    val stateFlow = container.stateFlow
    val lifecycleOwner = LocalEssentyLifecycleOwner.current

    val stateFlowLifecycleAware = remember(stateFlow, lifecycleOwner) {
        stateFlow.withLifecycle(lifecycleOwner.lifecycle, lifecycleState)
    }

    val initialValue = stateFlow.value
    return stateFlowLifecycleAware.collectAsState(initialValue)
}
