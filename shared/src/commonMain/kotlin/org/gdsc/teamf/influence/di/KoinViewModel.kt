package org.gdsc.teamf.influence.di

import androidx.compose.runtime.Composable
import org.gdsc.teamf.influence.viewmodel.PlatformViewModel
import org.koin.compose.currentKoinScope
import org.koin.core.definition.Definition
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.module.dsl.DefinitionOptions
import org.koin.core.module.dsl.new
import org.koin.core.module.dsl.onOptions
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope

expect inline fun <reified T : PlatformViewModel<*, *>> Module.viewModel(
    qualifier: Qualifier? = null,
    createdAtStart: Boolean = false,
    noinline definition: Definition<T>,
) : KoinDefinition<T>

inline fun <reified R : PlatformViewModel<*, *>> Module.viewModelOf(
    crossinline constructor: () -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1> Module.viewModelOf(
    crossinline constructor: (T1) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2> Module.viewModelOf(
    crossinline constructor: (T1, T2) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)

/**
 * @see viewModelOf
 */
inline fun <reified R : PlatformViewModel<*, *>, reified T1, reified T2, reified T3, reified T4, reified T5, reified T6, reified T7, reified T8, reified T9, reified T10, reified T11, reified T12, reified T13, reified T14, reified T15, reified T16, reified T17, reified T18, reified T19, reified T20, reified T21, reified T22> Module.viewModelOf(
    crossinline constructor: (T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) -> R,
    noinline options: DefinitionOptions<R>? = null,
): KoinDefinition<R> = viewModel { new(constructor) }.onOptions(options)


@Composable
expect inline fun <reified T : PlatformViewModel<*, *>> koinViewModel(
    qualifier: Qualifier? = null,
    key: String? = null,
    scope: Scope = currentKoinScope(),
    noinline parameters: ParametersDefinition? = null,
): T