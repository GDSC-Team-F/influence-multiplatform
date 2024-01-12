package org.gdsc.teamf.influence.compose.components.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.components.input.ClickScaleEffect
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.data.entity.Vaccine
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun VaccineGridItem(
    modifier: Modifier = Modifier,
    vaccine: Vaccine,
    onClick: (Vaccine) -> Unit,
) {

    ClickScaleEffect({ onClick(vaccine) }) {

        InfluenceSurface(
            modifier = modifier.fillMaxWidth().height(150.dp),
            color = if (vaccine.vaccinated) LocalInfluenceColorPalette.current.lightGreen else Color.Transparent,
            border = if (vaccine.vaccinated) null else BorderStroke(1.dp, LocalInfluenceColorPalette.current.adaptiveGray200),
            shape = RoundedCornerShape(20.dp),
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    vaccine.name, style = InfluenceTypography.title3,
                    color = if (vaccine.vaccinated) LocalInfluenceColorPalette.current.darkGreen
                    else LocalContentColor.current
                )
                Spacer(Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = vaccine.progress,
                    modifier = Modifier.fillMaxWidth().height(8.dp),
                    color = LocalInfluenceColorPalette.current.green,
                    trackColor = if (vaccine.vaccinated) LocalInfluenceColorPalette.current.green.copy(alpha = 0.2f)
                    else LocalInfluenceColorPalette.current.adaptiveGray200,
                    strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    vaccine.progressString,
                    style = InfluenceTypography.body3,
                    color = LocalInfluenceColorPalette.current.green
                )
                Spacer(Modifier.height(10.dp))

                Text(
                    "내 친구 ${vaccine.vaccinatedFriends.size}명이 맞았어요",
                    style = InfluenceTypography.body4,
                    color = LocalInfluenceColorPalette.current.adaptiveGray500
                )
            }

        }
    }
}

@Composable
fun VaccineListItem(
    modifier: Modifier = Modifier,
    vaccine: Vaccine,
    onClick: (Vaccine) -> Unit,
) {

    ClickScaleEffect({ onClick(vaccine) }) {

        InfluenceSurface(
            modifier = modifier.fillMaxWidth(),
            color = LocalInfluenceColorPalette.current.adaptiveGray100,
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(modifier = Modifier.padding(20.dp)) {
                Text(vaccine.name, style = InfluenceTypography.title3)
                Spacer(Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = vaccine.progress,
                    modifier = Modifier.fillMaxWidth(),
                    color = LocalInfluenceColorPalette.current.green,
                    trackColor = LocalInfluenceColorPalette.current.adaptiveGray200,
                    strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    vaccine.progressString,
                    style = InfluenceTypography.body3,
                    color = LocalInfluenceColorPalette.current.green
                )
            }

        }

    }


}