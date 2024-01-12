package org.gdsc.teamf.influence.compose.components.input

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role

@Composable
fun ClickScaleEffect(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    rippleEnabled : Boolean = true,
    rippleColor: Color = MaterialTheme.colorScheme.primary.copy(0.005f),
    shape: Shape = MaterialTheme.shapes.medium,
    content: @Composable BoxScope.() -> Unit,
) {

    val interactionSource = remember { MutableInteractionSource() }

    val isPressed by interactionSource.collectIsPressedAsState()

    val transition = updateTransition(isPressed, label = "pressed")

    val applyScale by transition.animateFloat(
        label = "animationDuration",
        transitionSpec = {
            spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = 100f
            )
        }
    ) {
        if (it && enabled) 0.95f else 1f
    }

    CompositionLocalProvider(
        LocalIndication provides rememberRipple(color = rippleColor),
        LocalRippleTheme provides object : RippleTheme {
            @Composable
            override fun defaultColor() = rippleColor

            @Composable
            override fun rippleAlpha() = RippleAlpha(
                0.02f,
                0.02f,
                0.02f,
                0.02f,
            )
        }
    ) {
        Box(modifier = modifier
            .clip(shape)
            .clickable(
                interactionSource = interactionSource,
                indication = if (rippleEnabled) LocalIndication.current else null,
                enabled = true,
                onClickLabel = null,
                role = Role.Button,
                onClick = onClick,
            )
            .graphicsLayer {
                this.clip = isPressed
                scaleX = applyScale
                scaleY = applyScale
            }
        ) {
            content()
        }
    }

}
