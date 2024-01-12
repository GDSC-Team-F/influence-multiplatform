package org.gdsc.teamf.influence.viewmodel

import org.gdsc.teamf.influence.data.api.AuthApi
import org.gdsc.teamf.influence.data.entity.Condition
import org.gdsc.teamf.influence.data.entity.LivingState
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect


class RegisterScreenViewModel(
    private val authApi: AuthApi,
) : PlatformViewModel<RegisterScreenViewModel.State, RegisterScreenViewModel.SideEffect>() {

    class State(

    )

    sealed interface SideEffect {
        object RegisterSucceed : SideEffect
    }

    override val container: Container<State, SideEffect> = container(State())

    fun register(
        email: String,
        password: String,
        name: String,
        conditions: List<Condition>,
        livingState: LivingState,
        gender: Int,
        age: Int,
        characterId: Int,
    ) {
        intent {
            authApi.runCatching {
                register(
                    email,
                    password,
                    name,
                    conditions,
                    livingState,
                    gender,
                    age,
                    characterId,
                )
            }.onSuccess {
                postSideEffect(SideEffect.RegisterSucceed)
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

}