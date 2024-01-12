package org.gdsc.teamf.influence.viewmodel

import org.orbitmvi.orbit.Container


class FriendsScreenViewModel : PlatformViewModel<FriendsScreenViewModel.State, FriendsScreenViewModel.SideEffect>() {

    class State(

    )

    sealed interface SideEffect {

    }

    override val container: Container<State, SideEffect> = container(State())

    
}