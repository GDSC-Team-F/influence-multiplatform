package org.gdsc.teamf.influence.viewmodel

import org.gdsc.teamf.influence.data.LoadState
import org.gdsc.teamf.influence.data.api.MeApi
import org.gdsc.teamf.influence.data.entity.Me
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce


class RootScreenViewModel(
    private val meApi: MeApi,
) : PlatformViewModel<RootScreenViewModel.State, RootScreenViewModel.SideEffect>() {

    data class State(
        val meState: LoadState<Me> = LoadState.Idle(),
    )

    sealed interface SideEffect {

    }

    override val container: Container<State, SideEffect> = container(State())

    fun refreshApp() {
        intent {
            meApi.runCatching { me() }.onSuccess {
                reduce { state.copy(meState = LoadState.Success(it)) }
            }.onFailure {
                reduce { state.copy(meState = LoadState.Error(error = it)) }
            }
        }

    }

}