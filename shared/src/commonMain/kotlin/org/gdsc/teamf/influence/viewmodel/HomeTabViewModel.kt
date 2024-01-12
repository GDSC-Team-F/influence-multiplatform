package org.gdsc.teamf.influence.viewmodel

import org.gdsc.teamf.influence.data.Friend
import org.gdsc.teamf.influence.data.LoadState
import org.gdsc.teamf.influence.data.api.FriendApi
import org.gdsc.teamf.influence.data.api.PointApi
import org.gdsc.teamf.influence.data.api.VaccineApi
import org.gdsc.teamf.influence.data.entity.Point
import org.gdsc.teamf.influence.data.entity.Vaccine
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce


class HomeTabViewModel(
    private val pointApi: PointApi,
    private val vaccineApi: VaccineApi,
    private val friendApi: FriendApi,
) : PlatformViewModel<HomeTabViewModel.State, HomeTabViewModel.SideEffect>() {

    data class State(
        val myVaccineListState: LoadState<List<Vaccine>> = LoadState.Idle(),
        val friendListState: LoadState<List<Friend>> = LoadState.Idle(),
    ) {

        val vaccinated: List<Vaccine>
            get() = (myVaccineListState as? LoadState.Success)?.data?.filter { it.vaccinated }.orEmpty()

        val notVaccinated: List<Vaccine>
            get() = (myVaccineListState as? LoadState.Success)?.data?.filter { !it.vaccinated }.orEmpty()

    }

    data class PointedFriendData(
        val friend: Friend?,
        val vaccine: Vaccine?,
    )

    sealed interface SideEffect {
        data class ShowPointedFriend(val pointedFriendData: PointedFriendData) : SideEffect
    }

    override val container: Container<State, SideEffect> = container(State())

    fun load() {
        intent {
            val vaccines = vaccineApi.runCatching { vaccine() }
                .onSuccess { reduce { state.copy(myVaccineListState = LoadState.Success(it)) } }
                .onFailure {
                    reduce { state.copy(myVaccineListState = LoadState.Success(Vaccine.mockList)) }
//                    reduce { state.copy(myVaccineListState = LoadState.Error(error = it)) }
                }
                .getOrNull() ?: Vaccine.mockList

            val friends = friendApi.runCatching { friends() }
                .onSuccess { reduce { state.copy(friendListState = LoadState.Success(it)) } }
                .onFailure {
                    reduce { state.copy(friendListState = LoadState.Success(Friend.mock)) }
//                    reduce { state.copy(friendListState = LoadState.Error(error = it)) }
                }.getOrNull() ?: Friend.mock

            pointApi.runCatching { point() }
                .map {
                    PointedFriendData(
                        friend = friends.firstOrNull { friend -> friend.id == it.friendsId },
                        vaccine = vaccines.firstOrNull { vaccine -> vaccine.id == it.vaccineId },
                    )
                }
                .onSuccess { postSideEffect(SideEffect.ShowPointedFriend(it)) }
                .onFailure {
                    val pointMock = Point.mock
                    postSideEffect(
                        SideEffect.ShowPointedFriend(
                            PointedFriendData(
                                friend = friends.firstOrNull { friend -> friend.id == pointMock.friendsId },
                                vaccine = vaccines.firstOrNull { vaccine -> vaccine.id == pointMock.vaccineId },
                            )
                        )
                    )
//                reduce { state.copy(pointState = LoadState.Error(error = it)) }
                }
        }
    }

    fun revokePoint(id: Long) {
        intent {
            pointApi.runCatching { point(id) }
                .onSuccess { load() }
        }
    }


}