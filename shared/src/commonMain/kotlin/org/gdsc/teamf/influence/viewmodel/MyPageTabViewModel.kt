package org.gdsc.teamf.influence.viewmodel

import org.orbitmvi.orbit.Container


class MyPageTabViewModel : PlatformViewModel<MyPageTabViewModel.State, MyPageTabViewModel.SideEffect>() {

    class State(

    )

    sealed interface SideEffect {

    }

    override val container: Container<State, SideEffect> = container(State())

    
}