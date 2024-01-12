package org.gdsc.teamf.influence.compose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette

@Composable
fun InfluenceRoundIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String? = null,
    tint: Color = LocalInfluenceColorPalette.current.adaptiveGray0,
    backgroundColor: Color = tint.copy(alpha = 0.2f),
    border: BorderStroke? = null,
    onClick: () -> Unit = {}
) {
    InfluenceSurface(
        modifier = modifier,
        color = backgroundColor,
        border = border,
        onClick = onClick,
        shape = CircleShape
    ) {
        Icon(
            modifier = Modifier.padding(10.dp),
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint
        )
    }

}