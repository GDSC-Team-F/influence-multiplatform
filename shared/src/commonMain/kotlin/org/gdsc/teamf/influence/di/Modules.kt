package org.gdsc.teamf.influence.di

import io.ktor.client.HttpClient
import org.gdsc.teamf.influence.data.ApiHelper
import org.gdsc.teamf.influence.data.ApiHttpClient
import org.gdsc.teamf.influence.viewmodel.*
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

expect fun platformModule(): org.koin.core.module.Module

fun commonModule() = org.koin.dsl.module {

    single {
        ApiHelper(get())
    }

    viewModelOf(::RootScreenViewModel)
    viewModelOf(::LoginScreenViewModel)
    viewModelOf(::RegisterScreenViewModel)

    viewModelOf(::HomeTabViewModel)
    viewModelOf(::MyPageTabViewModel)
    viewModelOf(::RegionTabViewModel)

    viewModelOf(::VaccineScreenViewModel)
    viewModelOf(::FriendsScreenViewModel)

}

@Module
@ComponentScan("org.gdsc.teamf.influence")
class SharedModule