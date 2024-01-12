package org.gdsc.teamf.influence.viewmodel

import org.orbitmvi.orbit.Container


class RegionTabViewModel : PlatformViewModel<RegionTabViewModel.State, RegionTabViewModel.SideEffect>() {

    class State(

    )

    sealed interface SideEffect {

    }

    override val container: Container<State, SideEffect> = container(State())

    
}