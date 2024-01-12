package org.gdsc.teamf.influence.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.SettingsBuilder
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax

actual abstract class PlatformViewModel<State : Any, SideEffect : Any> actual constructor() : PlatformContainerHost<State, SideEffect> {
    actual open val platformViewModelScope: CoroutineScope =
        CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    actual open fun onViewModelCleared() {
        platformViewModelScope.coroutineContext.cancel()
    }

    fun state(onStateChange: (State) -> Unit) {
        container.stateFlow.onEach(onStateChange).launchIn(platformViewModelScope)
    }

    fun sideEffect(onSideEffect: (SideEffect) -> Unit) {
        container.sideEffectFlow.onEach(onSideEffect).launchIn(platformViewModelScope)
    }

}

actual fun <STATE : Any, SIDE_EFFECT : Any> PlatformViewModel<STATE, SIDE_EFFECT>.container(
    initialState: STATE,
    buildSettings: SettingsBuilder.() -> Unit,
    onCreate: (suspend SimpleSyntax<STATE, SIDE_EFFECT>.() -> Unit)?
): Container<STATE, SIDE_EFFECT> = platformViewModelScope.container(initialState, buildSettings, onCreate)