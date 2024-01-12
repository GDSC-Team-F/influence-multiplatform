package org.gdsc.teamf.influence.compose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun InfluenceToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = IconButtonDefaults.outlinedShape,
    contentColor: Color,
    color: Color,
    border: BorderStroke? = IconButtonDefaults.outlinedIconToggleButtonBorder(enabled, checked),
    icon: @Composable RowScope.() -> Unit,
    text: @Composable RowScope.() -> Unit,
) {
    InfluenceOutlinedIconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        contentColor = contentColor,
        color = color,
        border = border,
        content = {
            Row(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                icon()
                Spacer(modifier = Modifier.width(4.dp))
                text()
            }
        }

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InfluenceOutlinedIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = IconButtonDefaults.outlinedShape,
    contentColor: Color,
    color: Color,
    border: BorderStroke? = IconButtonDefaults.outlinedIconToggleButtonBorder(enabled, checked),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit,
) = Surface(
    checked = checked,
    onCheckedChange = onCheckedChange,
    modifier = modifier.semantics { role = Role.Checkbox },
    enabled = enabled,
    shape = shape,
    color = color,
    contentColor = contentColor,
    border = border,
    interactionSource = interactionSource
) {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}
