package org.gdsc.teamf.influence.viewmodel

import org.gdsc.teamf.influence.data.api.AuthApi
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

class LoginScreenViewModel(
    private val authApi: AuthApi
): PlatformViewModel<LoginScreenViewModel.State, LoginScreenViewModel.SideEffect>() {

    class State(

    )

    sealed interface SideEffect {
        object UpdateMe : SideEffect
    }

    override val container: Container<State, SideEffect> = container(State())

    fun login(
        email: String,
        password: String
    ) {
        intent {
            authApi.runCatching {
                login(email, password)
            }.onSuccess {
                postSideEffect(SideEffect.UpdateMe)
            }
        }
    }
    
}