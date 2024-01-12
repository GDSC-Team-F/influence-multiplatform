package org.gdsc.teamf.influence.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

@Composable
actual fun imageResource(name: String): Painter {
    val context = LocalContext.current
    val id = context.resources.getIdentifier(name, "drawable", context.packageName)
    return painterResource(id)
}