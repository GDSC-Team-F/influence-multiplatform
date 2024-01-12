package org.gdsc.teamf.influence.compose.style

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle

@Composable
expect fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font

internal object TypefaceTokens {
    val FamilyExtraBold @Composable get() = FontFamily(font("Pretendard", "pretendard_extrabold", FontWeight.Normal, FontStyle.Normal))
    val FamilySemiBold @Composable get() = FontFamily(font("Pretendard", "pretendard_semibold", FontWeight.Normal, FontStyle.Normal))
    val FamilyMedium @Composable get() = FontFamily(font("Pretendard", "pretendard_medium", FontWeight.Normal, FontStyle.Normal))
    val FamilyRegular @Composable get() = FontFamily(font("Pretendard", "pretendard_regular", FontWeight.Normal, FontStyle.Normal))

    val WeightExtraBold = FontWeight.ExtraBold
    val WeightSemiBold = FontWeight.SemiBold
    val WeightMedium = FontWeight.Medium
    val WeightRegular = FontWeight.Normal
}

val influenceTypography @Composable get() = Typography(
    headlineLarge = TextStyle(
        fontFamily = TypefaceTokens.FamilyExtraBold,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 48.sp
    ), // Heading 1
    headlineMedium = TextStyle(
        fontFamily = TypefaceTokens.FamilyExtraBold,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 42.sp
    ), // Heading 2
    headlineSmall = TextStyle(
        fontFamily = TypefaceTokens.FamilySemiBold,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 36.sp
    ), // Heading 3
    titleLarge = TextStyle(
        fontFamily = TypefaceTokens.FamilySemiBold,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 30.sp
    ), // Title 1
    titleMedium = TextStyle(
        fontFamily = TypefaceTokens.FamilySemiBold,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 27.sp
    ), // Title 2
    titleSmall = TextStyle(
        fontFamily = TypefaceTokens.FamilySemiBold,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ), // Title 3
    bodyLarge = TextStyle(
        fontFamily = TypefaceTokens.FamilyMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 27.sp
    ), // Body 1
    bodyMedium = TextStyle(
        fontFamily = TypefaceTokens.FamilyMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ), // Body 2
    bodySmall = TextStyle(
        fontFamily = TypefaceTokens.FamilyMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ), // Body 3
    labelLarge = TextStyle(
        fontFamily = TypefaceTokens.FamilyMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 18.sp
    ), // Body 4
    labelMedium = TextStyle(
        fontFamily = TypefaceTokens.FamilyRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp
    ), // Caption 1
)

@Immutable
object InfluenceTypography {

    val heading1 @Composable get() = MaterialTheme.typography.headlineLarge
    val heading2 @Composable get() = MaterialTheme.typography.headlineMedium
    val heading3 @Composable get() = MaterialTheme.typography.headlineSmall
    val title1 @Composable get() = MaterialTheme.typography.titleLarge
    val title2 @Composable get() = MaterialTheme.typography.titleMedium
    val title3 @Composable get() = MaterialTheme.typography.titleSmall
    val body1 @Composable get() = MaterialTheme.typography.bodyLarge
    val body2 @Composable get() = MaterialTheme.typography.bodyMedium
    val body3 @Composable get() = MaterialTheme.typography.bodySmall
    val body4 @Composable get() = MaterialTheme.typography.labelLarge
    val caption1 @Composable get() = MaterialTheme.typography.labelMedium

}