package org.gdsc.teamf.influence.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.SettingsBuilder
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax
import org.orbitmvi.orbit.viewmodel.container

actual abstract class PlatformViewModel<State : Any, SideEffect: Any> actual constructor() : ViewModel(), PlatformContainerHost<State, SideEffect> {

    actual open val platformViewModelScope: CoroutineScope = viewModelScope

    actual open fun onViewModelCleared() {

    }

    override fun onCleared() {
        onViewModelCleared()
        super.onCleared()
    }

}

actual fun <STATE : Any, SIDE_EFFECT : Any> PlatformViewModel<STATE, SIDE_EFFECT>.container(
    initialState: STATE,
    buildSettings: SettingsBuilder.() -> Unit,
    onCreate: (suspend SimpleSyntax<STATE, SIDE_EFFECT>.() -> Unit)?
): Container<STATE, SIDE_EFFECT> = container(initialState, buildSettings,  onCreate)