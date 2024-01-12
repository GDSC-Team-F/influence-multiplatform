package org.gdsc.teamf.influence.compose.components.input

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette

@Composable
fun InfluenceOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = InfluenceTypography.body3,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(6.dp),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedLabelColor = LocalInfluenceColorPalette.current.adaptiveGray900,
        unfocusedLabelColor = LocalInfluenceColorPalette.current.adaptiveGray300,

        focusedTextColor = LocalInfluenceColorPalette.current.adaptiveGray900,
        unfocusedTextColor = LocalInfluenceColorPalette.current.adaptiveGray900,

        unfocusedBorderColor = LocalInfluenceColorPalette.current.adaptiveGray200,
        focusedBorderColor = LocalInfluenceColorPalette.current.adaptiveGray700,

        focusedPlaceholderColor = LocalInfluenceColorPalette.current.adaptiveGray300,
        unfocusedPlaceholderColor = LocalInfluenceColorPalette.current.adaptiveGray300,

        cursorColor = LocalInfluenceColorPalette.current.adaptiveGray900,

        ),
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        if (label != null) {
            ProvideTextStyle(value = InfluenceTypography.body3, label)
            Spacer(modifier = Modifier.height(8.dp))
        }
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = textStyle,
            label = null,
            placeholder = if (placeholder != null) {
                { ProvideTextStyle(value = InfluenceTypography.body3, placeholder) }
            } else null,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            prefix = prefix,
            suffix = suffix,
            supportingText = supportingText,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            interactionSource = interactionSource,
            shape = shape,
            colors = colors
        )
    }
}

@Composable
fun InfluenceUnderStrokeTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = InfluenceTypography.body3,
    placeholder: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedLabelColor = LocalInfluenceColorPalette.current.adaptiveGray900,
        unfocusedLabelColor = LocalInfluenceColorPalette.current.adaptiveGray300,

        focusedTextColor = LocalInfluenceColorPalette.current.adaptiveGray900,
        unfocusedTextColor = LocalInfluenceColorPalette.current.adaptiveGray900,

        unfocusedBorderColor = LocalInfluenceColorPalette.current.adaptiveGray200,
        focusedBorderColor = LocalInfluenceColorPalette.current.adaptiveGray700,

        focusedPlaceholderColor = LocalInfluenceColorPalette.current.adaptiveGray300,
        unfocusedPlaceholderColor = LocalInfluenceColorPalette.current.adaptiveGray300,

        cursorColor = LocalInfluenceColorPalette.current.green,

        ),
) {

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        textStyle = textStyle,
        visualTransformation = visualTransformation,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        enabled = enabled,
        readOnly = readOnly,
        cursorBrush = SolidColor(LocalInfluenceColorPalette.current.green),
    ) { innerTextField ->
        val focused by interactionSource.collectIsFocusedAsState()

        val animatedValue by animateFloatAsState(
            targetValue = if (focused) 1f else 0f, label = "bottomLine",
            animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxWidth().height(30.dp), contentAlignment = Alignment.CenterStart) {
                innerTextField()
                placeholder?.let {
                    androidx.compose.animation.AnimatedVisibility(
                        visible = value.isEmpty(), label = "",
                        enter = fadeIn(animationSpec = tween(durationMillis = 80, easing = FastOutSlowInEasing)),
                        exit = fadeOut(animationSpec = tween(durationMillis = 80, easing = FastOutSlowInEasing))
                    ) {
                        ProvideTextStyle(value = textStyle.copy(LocalInfluenceColorPalette.current.adaptiveGray300), placeholder)
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            LinearProgressIndicator(
                progress = animatedValue,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp),
                color = LocalInfluenceColorPalette.current.green,
                trackColor = LocalInfluenceColorPalette.current.adaptiveGray300,
            )
        }
    }
}

@Composable
fun InfluenceBoarderTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = InfluenceTypography.body3,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(6.dp),
    colors: TextFieldColors = TextFieldDefaults.colors(
        disabledContainerColor = LocalInfluenceColorPalette.current.adaptiveGray100,
        focusedContainerColor = LocalInfluenceColorPalette.current.adaptiveGray100,
        unfocusedContainerColor = LocalInfluenceColorPalette.current.adaptiveGray100,

        disabledIndicatorColor = Color.Unspecified,
        focusedIndicatorColor = Color.Unspecified,
        unfocusedIndicatorColor = Color.Unspecified,

        disabledTextColor = LocalInfluenceColorPalette.current.adaptiveGray300,
        focusedTextColor = LocalInfluenceColorPalette.current.adaptiveGray900,
        unfocusedTextColor = LocalInfluenceColorPalette.current.adaptiveGray900,

        disabledPlaceholderColor = LocalInfluenceColorPalette.current.adaptiveGray300,
        focusedPlaceholderColor = LocalInfluenceColorPalette.current.adaptiveGray400,
        unfocusedPlaceholderColor = LocalInfluenceColorPalette.current.adaptiveGray400,

        cursorColor = LocalInfluenceColorPalette.current.adaptiveGray900,
    ),
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = null,
        placeholder = if (placeholder != null) {
            { ProvideTextStyle(value = InfluenceTypography.body3, placeholder) }
        } else null,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        prefix = prefix,
        suffix = suffix,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )

}