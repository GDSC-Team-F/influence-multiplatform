package org.gdsc.teamf.influence.compose.components.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.blended.android.ui.components.buttons.InfluenceTextButton
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette

@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    onMoreButtonClicked: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = InfluenceTypography.title1.copy(color = LocalInfluenceColorPalette.current.adaptiveGray900)
            )
            Spacer(Modifier.height(4.dp))
            Text(text = subtitle, style = InfluenceTypography.body3.copy(color = LocalInfluenceColorPalette.current.adaptiveGray600))
        }
        if (onMoreButtonClicked != null) {
            InfluenceTextButton(
                text = "더보기",
                onClick = onMoreButtonClicked
            )
        }
    }

}
@Composable
fun MediumHeader(
    modifier: Modifier = Modifier,
    title: String,
    right : @Composable () -> Unit = {},
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = InfluenceTypography.title2.copy(color = LocalInfluenceColorPalette.current.adaptiveGray800)
            )
        }
        right()
    }

}
@Composable
fun SmallHeader(
    modifier: Modifier = Modifier,
    title: String,
    right : @Composable () -> Unit = {},
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = InfluenceTypography.title3.copy(color = LocalInfluenceColorPalette.current.adaptiveGray800)
            )
        }
        right()
    }

}