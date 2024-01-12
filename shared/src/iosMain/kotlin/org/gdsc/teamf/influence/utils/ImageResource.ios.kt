package org.gdsc.teamf.influence.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
actual fun imageResource(name: String): Painter {
    return painterResource("drawable/$name.png")
}