package org.gdsc.teamf.influence.compose.components.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import org.gdsc.teamf.influence.compose.components.InfluenceCtaButton
import org.gdsc.teamf.influence.compose.components.InfluenceSecondaryButton
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.components.input.ClickScaleEffect
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.data.Friend
import org.gdsc.teamf.influence.utils.imageResource

@Composable
fun FriendGridItem(
    friend: Friend,
    onClick: (Friend) -> Unit = {},
    pointEnabled: Boolean = false,
    onPointClick: (Friend) -> Unit = {},
) {
    ClickScaleEffect(
        onClick = { onClick(friend) }) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageResource(friend.characterImageRes),
                contentDescription = friend.name,
                modifier = Modifier
                    .size(80.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = friend.name,
                style = InfluenceTypography.body3,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            if (pointEnabled) {
                Spacer(Modifier.height(12.dp))
                ClickScaleEffect(
                    {
                        onPointClick(friend)
                    },
                ) {
                    InfluenceSurface(
                        shape = RoundedCornerShape(20.dp),
                        color = LocalInfluenceColorPalette.current.green.copy(0.1f),
                        contentColor = LocalInfluenceColorPalette.current.green,
                    ) {
                        Text(modifier = Modifier.padding(8.dp, 4.dp), text = "찌르기", style = InfluenceTypography.body4)
                    }
                }
            }
        }
    }

}

@Composable
fun FriendListItem(
    friend: Friend,
    onClick: (Friend) -> Unit = {},
) {
    ClickScaleEffect(
        onClick = { onClick(friend) }) {
        Row(
            modifier = Modifier.padding(vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageResource(friend.characterImageRes),
                contentDescription = friend.name,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(20.dp))
            Text(
                text = friend.name,
                style = InfluenceTypography.title3,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }

}