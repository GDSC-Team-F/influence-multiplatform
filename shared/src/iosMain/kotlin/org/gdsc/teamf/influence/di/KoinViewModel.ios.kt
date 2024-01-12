package org.gdsc.teamf.influence.di

import androidx.compose.runtime.Composable
import org.gdsc.teamf.influence.viewmodel.PlatformViewModel
import org.koin.compose.koinInject
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.module.dsl.DefinitionOptions
import org.koin.core.module.dsl.new
import org.koin.core.module.dsl.onOptions
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope

actual inline fun <reified T : PlatformViewModel<*, *>> Module.viewModel(
    qualifier: Qualifier?,
    createdAtStart: Boolean,
    noinline definition: Definition<T>,
) = factory(qualifier, definition)

@Composable
actual inline fun <reified T : PlatformViewModel<*, *>> koinViewModel(
    qualifier: Qualifier?,
    key: String?,
    scope: Scope,
    noinline parameters: ParametersDefinition?,
): T = koinInject(qualifier, scope = scope, parameters = parameters)