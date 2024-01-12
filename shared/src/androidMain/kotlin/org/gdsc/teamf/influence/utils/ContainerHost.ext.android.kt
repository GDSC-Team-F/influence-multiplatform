package org.gdsc.teamf.influence.utils

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.arkivanov.essenty.lifecycle.LifecycleOwner

actual val LocalEssentyLifecycleOwner: ProvidableCompositionLocal<LifecycleOwner> = staticCompositionLocalOf {
    error("No LocalLifecycleOwner provided")
}