package org.gdsc.teamf.influence.viewmodel

import org.gdsc.teamf.influence.data.Friend
import org.gdsc.teamf.influence.data.LoadState
import org.gdsc.teamf.influence.data.api.PointApi
import org.gdsc.teamf.influence.data.api.VaccineApi
import org.gdsc.teamf.influence.data.entity.Vaccine
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce


class VaccineScreenViewModel(
    private val pointApi: PointApi,
    private val vaccineApi: VaccineApi,
) : PlatformViewModel<VaccineScreenViewModel.State, VaccineScreenViewModel.SideEffect>() {

    data class State(
        val vaccinatedFriendsState: LoadState<List<Friend>> = LoadState.Idle(),
        val notVaccinatedFriendsState: LoadState<List<Friend>> = LoadState.Idle(),
    )

    sealed interface SideEffect {
        object Pop : SideEffect
    }

    override val container: Container<State, SideEffect> = container(State())

    fun load(
        vaccine: Vaccine,
        friends: List<Friend>,
    ) {
        intent {
            reduce {
                state.copy(
                    vaccinatedFriendsState = LoadState.Loading(),
                    notVaccinatedFriendsState = LoadState.Loading(),
                )
            }

            val vaccinatedFriends = friends.filter { friend -> friend.id !in vaccine.notVaccinatedFriends }

            val notVaccinatedFriends = friends.filter { friend -> friend.id !in vaccine.vaccinatedFriends }

            reduce {
                state.copy(
                    vaccinatedFriendsState = LoadState.Success(vaccinatedFriends),
                    notVaccinatedFriendsState = LoadState.Success(notVaccinatedFriends),
                )
            }

        }
    }

    fun vaccinated(vaccineId: Long) {
        intent {
            vaccineApi.vaccinated(vaccineId)
            postSideEffect(SideEffect.Pop)
        }
    }

    fun point(vaccineId: Long, friendsId: Long) {
        intent {
            pointApi.point(vaccineId, friendsId)
        }
    }

}