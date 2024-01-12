package org.gdsc.teamf.influence.compose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.gdsc.teamf.influence.compose.style.InfluenceColorPalette
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette

@Composable
fun InfluenceCtaButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    style: TextStyle = InfluenceTypography.body2,
    shape: Shape = RoundedCornerShape(12.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        contentColor = InfluenceColorPalette.current.adaptiveGray0,
        containerColor = InfluenceColorPalette.current.green,
        disabledContentColor = InfluenceColorPalette.current.adaptiveGray600,
        disabledContainerColor = InfluenceColorPalette.current.adaptiveGray300,
    ),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {

    Button(
        modifier = modifier.height(48.dp),
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource
    ) {
        Text(
            text = text,
            style = style
        )
    }

}

@Composable
fun InfluenceSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    style: TextStyle = InfluenceTypography.body2,
    shape: Shape = RoundedCornerShape(12.dp),
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        contentColor = InfluenceColorPalette.current.adaptiveGray700,
        disabledContentColor = InfluenceColorPalette.current.adaptiveGray600,
        disabledContainerColor = InfluenceColorPalette.current.adaptiveGray300,
    ),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = BorderStroke(
        width = 1.dp,
        color = LocalInfluenceColorPalette.current.adaptiveGray400,
    ),
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon : @Composable (RowScope.() -> Unit)? = null,
) {

    OutlinedButton(
        modifier = modifier.height(48.dp),
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource
    ) {
        icon?.invoke(this)
        Text(
            text = text,
            style = style
        )
    }

}