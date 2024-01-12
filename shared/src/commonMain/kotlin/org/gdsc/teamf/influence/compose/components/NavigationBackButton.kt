package org.gdsc.teamf.influence.compose.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun NavigationBackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            Icons.Rounded.ArrowBack,
            contentDescription = "Back"
        )
    }
}