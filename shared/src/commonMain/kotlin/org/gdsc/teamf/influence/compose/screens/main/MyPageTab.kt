package org.gdsc.teamf.influence.compose.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.components.list.InfluenceListItem
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.data.entity.Me
import org.gdsc.teamf.influence.data.entity.stateReadable

object MyPageTab : Tab {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(
            contentWindowInsets = WindowInsets.systemBars,
            modifier = Modifier,
            topBar = {
                TopAppBar(
                    title = { Text("내 정보") },
                )
            }
        ) {
            val me = remember {
                Me.mock
            }
            Column(modifier = Modifier.padding(it).verticalScroll(rememberScrollState())) {
                InfluenceSurface(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    color = Color.Transparent,
                    border = BorderStroke(1.dp, LocalInfluenceColorPalette.current.adaptiveGray200),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {

                        Spacer(Modifier.height(20.dp))

                        Text(
                            me.name,
                            style = InfluenceTypography.heading3,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )

                        Spacer(Modifier.height(10.dp))

                        InfluenceListItem(
                            headlineContent = { Text("성별", style = InfluenceTypography.body2) },
                            supportingContent = { Text(if (me.gender == 0) "남성" else "여성", style = InfluenceTypography.body3) },
                        )

                        InfluenceListItem(
                            headlineContent = { Text("지역", style = InfluenceTypography.body2) },
                            supportingContent = { Text(me.stateModel.stateReadable, style = InfluenceTypography.body3) },
                        )

                        InfluenceListItem(
                            headlineContent = { Text("나이", style = InfluenceTypography.body2) },
                            supportingContent = { Text("${me.age}세", style = InfluenceTypography.body3) },
                        )

                        InfluenceListItem(
                            headlineContent = { Text("특이사항", style = InfluenceTypography.body2) },
                            supportingContent = { Text(me.conditionsAsStrings.joinToString(), style = InfluenceTypography.body3) },
                        )

                    }
                }
            }
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Rounded.Person)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "내 정보",
                    icon = icon
                )
            }
        }
}