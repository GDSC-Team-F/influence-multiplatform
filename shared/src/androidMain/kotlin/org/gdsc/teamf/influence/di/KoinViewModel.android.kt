package org.gdsc.teamf.influence.di

import androidx.compose.runtime.Composable
import org.gdsc.teamf.influence.viewmodel.PlatformViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.compose.currentKoinScope
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope

actual inline fun <reified T : PlatformViewModel<*, *>> Module.viewModel(
    qualifier: Qualifier?,
    createdAtStart: Boolean,
    noinline definition: Definition<T>,
) : KoinDefinition<T> {
    return viewModel(qualifier, definition)
}


@Composable
actual inline fun <reified T : PlatformViewModel<*, *>> koinViewModel(
    qualifier: Qualifier?,
    key: String?,
    scope: Scope,
    noinline parameters: ParametersDefinition?,
): T = org.koin.androidx.compose.koinViewModel(qualifier, key = key, scope = scope, parameters = parameters)