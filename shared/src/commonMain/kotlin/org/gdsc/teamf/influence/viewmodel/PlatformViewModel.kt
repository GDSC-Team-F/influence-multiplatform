package org.gdsc.teamf.influence.viewmodel

import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.SettingsBuilder
import org.orbitmvi.orbit.syntax.simple.SimpleSyntax

expect abstract class PlatformViewModel<State : Any, SideEffect: Any>() : PlatformContainerHost<State, SideEffect> {

    open val platformViewModelScope : CoroutineScope

    open fun onViewModelCleared()

}

interface PlatformContainerHost<State : Any, SideEffect: Any> : ContainerHost<State, SideEffect> {

}

expect fun <STATE : Any, SIDE_EFFECT : Any> PlatformViewModel<STATE, SIDE_EFFECT>.container(
    initialState: STATE,
    buildSettings: SettingsBuilder.() -> Unit = {},
    onCreate: (suspend SimpleSyntax<STATE, SIDE_EFFECT>.() -> Unit)? = null
): Container<STATE, SIDE_EFFECT>