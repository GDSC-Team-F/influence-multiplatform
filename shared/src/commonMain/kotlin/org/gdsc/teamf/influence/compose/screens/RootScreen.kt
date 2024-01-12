package org.gdsc.teamf.influence.compose.screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.fetch.NetworkFetcher
import org.gdsc.teamf.influence.compose.components.VoyagerSwipeBackContent
import org.gdsc.teamf.influence.compose.screens.main.MainScreen
import org.gdsc.teamf.influence.compose.style.AppTheme
import org.gdsc.teamf.influence.data.entity.Me
import org.gdsc.teamf.influence.di.SharedModule
import org.gdsc.teamf.influence.di.commonModule
import org.gdsc.teamf.influence.di.koinViewModel
import org.gdsc.teamf.influence.di.platformModule
import org.gdsc.teamf.influence.utils.collectAsState
import org.gdsc.teamf.influence.viewmodel.RootScreenViewModel
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun RootScreen(
    application: KoinAppDeclaration = { },
) {
    BottomSheetNavigator {
        AppTheme {
            KoinApplication(application = {
                application()
                modules(
                    SharedModule().module + platformModule() + commonModule()
                )
            }) {

                setSingletonImageLoaderFactory { context ->
                    ImageLoader(context).newBuilder()
                        .components { add(NetworkFetcher.Factory()) }
                        .build()
                }

                val viewModel = koinViewModel<RootScreenViewModel>()

                val state by viewModel.collectAsState()

                LaunchedEffect(Unit) {
                    viewModel.refreshApp()
                }

                CompositionLocalProvider(LocalRootViewModel provides viewModel) {
                    if (state.meState.isSuccess) {
                        Navigator(MainScreen) {
                            CompositionLocalProvider(LocalMe provides state.meState.getOrNull()!!) {
                                VoyagerSwipeBackContent(it)
                            }
                        }
                    } else if (state.meState.isError) {
                        Navigator(LoginScreen)
                    }
                }

            }
        }
    }
}

val LocalRootViewModel = staticCompositionLocalOf<RootScreenViewModel> {
    throw IllegalStateException("RootScreenViewModel not initialized")
}

val LocalMe = staticCompositionLocalOf<Me> {
    throw IllegalStateException("Me not initialized")
}