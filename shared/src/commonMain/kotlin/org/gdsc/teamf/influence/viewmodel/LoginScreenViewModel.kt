package org.gdsc.teamf.influence.viewmodel

import org.gdsc.teamf.influence.data.ApiHelper
import org.gdsc.teamf.influence.data.api.AuthApi
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

class LoginScreenViewModel(
    private val authApi: AuthApi,
    private val apiHelper: ApiHelper
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
            apiHelper.clear()
            authApi.runCatching {
                login(email, password)
            }.onSuccess {
                if (it != null) {
                    println("token: $it")
                    apiHelper.setToken(it)
                }
                postSideEffect(SideEffect.UpdateMe)
            }
        }
    }
    
}