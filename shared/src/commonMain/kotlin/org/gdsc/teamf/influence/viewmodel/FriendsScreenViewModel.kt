package org.gdsc.teamf.influence.viewmodel

import org.gdsc.teamf.influence.data.Friend
import org.gdsc.teamf.influence.data.LoadState
import org.gdsc.teamf.influence.data.api.FriendApi
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce


class FriendsScreenViewModel(
    private val friendApi: FriendApi,
) : PlatformViewModel<FriendsScreenViewModel.State, FriendsScreenViewModel.SideEffect>() {

    data class State(
        val friends: LoadState<List<Friend>> = LoadState.Idle(),
    )

    sealed interface SideEffect {
        object InviteSucceed : SideEffect
    }

    override val container: Container<State, SideEffect> = container(State())

    fun fetch() {
        intent {
            friendApi.runCatching { friends() }.onSuccess {
                reduce {
                    state.copy(friends = LoadState.Success(it))
                }
            }.onFailure {
                reduce {
                    state.copy(friends = LoadState.Error(error = it))
                }
            }
        }

    }

    fun invite(email: String) {
        intent {
            friendApi.runCatching { invite(email) }
                .onSuccess {
                    postSideEffect(SideEffect.InviteSucceed)
                }
                .onFailure {
                it.printStackTrace()
            }
        }
    }
}