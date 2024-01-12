package org.gdsc.teamf.influence.compose.style

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalInfluenceColorPalette = compositionLocalOf<InfluenceColorPalette> {
    error("No InfluenceColorScheme provided")
}

@Immutable
object InfluenceColors {

    val white = Color(0xFFFFFFFF)
    val black = Color(0xFF000000)

    val gray50 = Color(0xFFFCFCFC)
    val gray100 = Color(0xFFF8F8F8)
    val gray200 = Color(0xFFEFEFEF)
    val gray300 = Color(0xFFDFDFDF)
    val gray400 = Color(0xFFB7B7B7)
    val gray500 = Color(0xFF949494)
    val gray600 = Color(0xFF777777)
    val gray700 = Color(0xFF555555)
    val gray800 = Color(0xFF2A2A2A)
    val gray900 = Color(0xFF111111)

    val green100 = Color(0xFFE6FFF7)
    val green500 = Color(0xFF00D58B)
    val green700 = Color(0xFF005336)
    val pink100 = Color(0xFFFFE8F2)
    val pink500 = Color(0xFF9D1B56)
    val blue500 = Color(0xFF4B89FF)
    val purple100 = Color(0xFFF5EFFF)
    val purple500 = Color(0xFF904BFF)
    val yellow500 = Color(0xFFFFC14B)

    val error = Color(0xFFFC5555)

}


@Immutable
interface InfluenceColorPalette {

    val isLight: Boolean

    companion object {
        val current
            @Composable
            @ReadOnlyComposable
            get() = LocalInfluenceColorPalette.current

    }

    val adaptiveGray0: Color
    val adaptiveGray50: Color
    val adaptiveGray100: Color
    val adaptiveGray200: Color
    val adaptiveGray300: Color
    val adaptiveGray400: Color
    val adaptiveGray500: Color
    val adaptiveGray600: Color
    val adaptiveGray700: Color
    val adaptiveGray800: Color
    val adaptiveGray900: Color
    val green: Color
    val lightGreen: Color
    val darkGreen: Color
    val pink: Color
    val darkPink: Color
    val blue : Color
    val lightPurple: Color
    val purple: Color
    val yellow: Color
}

@Immutable
object InfluenceLightColorPalette : InfluenceColorPalette {

    override val adaptiveGray0: Color = InfluenceColors.white
    override val adaptiveGray50: Color = InfluenceColors.gray50
    override val adaptiveGray100: Color = InfluenceColors.gray100
    override val adaptiveGray200: Color = InfluenceColors.gray200
    override val adaptiveGray300: Color = InfluenceColors.gray300
    override val adaptiveGray400: Color = InfluenceColors.gray400
    override val adaptiveGray500: Color = InfluenceColors.gray500
    override val adaptiveGray600: Color = InfluenceColors.gray600
    override val adaptiveGray700: Color = InfluenceColors.gray700
    override val adaptiveGray800: Color = InfluenceColors.gray800
    override val adaptiveGray900: Color = InfluenceColors.gray900
    override val green: Color = InfluenceColors.green500
    override val lightGreen: Color = InfluenceColors.green100
    override val darkGreen: Color = InfluenceColors.green700
    override val pink: Color = InfluenceColors.pink100
    override val darkPink: Color = InfluenceColors.pink500
    override val blue: Color = InfluenceColors.blue500
    override val lightPurple: Color = InfluenceColors.purple100
    override val purple: Color = InfluenceColors.purple500
    override val yellow: Color = InfluenceColors.yellow500

    override val isLight: Boolean = true
}

val influenceLightSchemeColor = lightColorScheme(
    primary = InfluenceColors.green500,
    primaryContainer = InfluenceColors.gray50,

    secondary = InfluenceColors.white,
    secondaryContainer = InfluenceColors.gray50,

    background = InfluenceColors.white,
    surface = InfluenceColors.white,

    onPrimary = InfluenceColors.gray900,
    onPrimaryContainer = InfluenceColors.gray900,
    onSecondary = InfluenceColors.gray900,
    onSecondaryContainer = InfluenceColors.gray900,
    onBackground = InfluenceColors.gray900,
    onSurface = InfluenceColors.gray900,
    error = InfluenceColors.error
)
