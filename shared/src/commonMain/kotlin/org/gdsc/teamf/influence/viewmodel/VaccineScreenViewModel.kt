package org.gdsc.teamf.influence.viewmodel

import org.gdsc.teamf.influence.data.Friend
import org.gdsc.teamf.influence.data.LoadState
import org.gdsc.teamf.influence.data.api.PointApi
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce


class VaccineScreenViewModel(
    private val pointApi: PointApi
) : PlatformViewModel<VaccineScreenViewModel.State, VaccineScreenViewModel.SideEffect>() {

    data class State(
        val vaccinatedFriendsState : LoadState<List<Friend>> = LoadState.Idle(),
        val notVaccinatedFriendsState : LoadState<List<Friend>> = LoadState.Idle(),
    )

    sealed interface SideEffect {

    }

    override val container: Container<State, SideEffect> = container(State())

    fun load() {
        intent {
            reduce {
                state.copy(
                    vaccinatedFriendsState = LoadState.Loading(),
                    notVaccinatedFriendsState = LoadState.Loading(),
                )
            }

            val vaccinatedFriends = listOf(
                Friend.mock[0],
                Friend.mock[1],
            )

            val notVaccinatedFriends = listOf(
                Friend.mock[2],
                Friend.mock[3],
            )

            reduce {
                state.copy(
                    vaccinatedFriendsState = LoadState.Success(vaccinatedFriends).also {
                        it.refresh = ::load
                    },
                    notVaccinatedFriendsState = LoadState.Success(notVaccinatedFriends).also {
                        it.refresh = ::load
                    },
                )
            }

        }
    }

    fun point(vaccineId : Long, friendsId : Long) {
        intent {
            pointApi.point(vaccineId, friendsId)
        }
    }
    
}