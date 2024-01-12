package org.gdsc.teamf.influence.compose.components.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.components.input.ClickScaleEffect
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.data.entity.LivingState
import org.gdsc.teamf.influence.data.entity.RegionVaccineAchieve
import org.gdsc.teamf.influence.data.entity.stateReadable
import kotlin.math.roundToInt

@Composable
fun RegionVaccineListItem(
    index : Int,
    regionVaccineAchieve: RegionVaccineAchieve,
    isMine: Boolean,
) {
    InfluenceSurface(
        modifier = Modifier.fillMaxWidth(),
        color = if (isMine) Color.White else LocalInfluenceColorPalette.current.adaptiveGray100,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = if (isMine) 10.dp else 0.dp,
        border = if (isMine) androidx.compose.foundation.BorderStroke(2.dp, LocalInfluenceColorPalette.current.green) else null,
    ) {
        Column(modifier = Modifier.padding(20.dp)) {

            Text(
                text = "${index + 1}위",
                style = if (isMine) InfluenceTypography.title1 else InfluenceTypography.body3,
                color = if (isMine) LocalInfluenceColorPalette.current.green else LocalInfluenceColorPalette.current.adaptiveGray600
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = regionVaccineAchieve.region.stateReadable,
                style = InfluenceTypography.title3
            )

            Spacer(Modifier.height(10.dp))

            LinearProgressIndicator(
                progress = regionVaccineAchieve.progress,
                modifier = Modifier.fillMaxWidth().height(8.dp),
                color = LocalInfluenceColorPalette.current.green,
                trackColor = LocalInfluenceColorPalette.current.adaptiveGray200,
                strokeCap = StrokeCap.Round
            )

            Spacer(Modifier.height(4.dp))

            Text(
                "${(regionVaccineAchieve.progress * 100f).roundToInt()}%",
                style = InfluenceTypography.body3,
                color = LocalInfluenceColorPalette.current.green
            )
        }
    }

}