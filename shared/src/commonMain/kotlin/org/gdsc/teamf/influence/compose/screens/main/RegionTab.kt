package org.gdsc.teamf.influence.compose.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDownCircle
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.components.input.ClickScaleEffect
import org.gdsc.teamf.influence.compose.components.list.RegionVaccineListItem
import org.gdsc.teamf.influence.compose.components.list.SmallHeader
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.data.entity.RegionVaccineAchieve
import org.gdsc.teamf.influence.data.entity.Me
import org.gdsc.teamf.influence.data.entity.Vaccine

object RegionTab : Tab {
    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val vaccines = remember {
            Vaccine.mockList
        }

        var isVaccineDialogShown by remember { mutableStateOf(false) }

        var selectedVaccine by remember { mutableStateOf(vaccines.first()) }

        Scaffold(
            contentWindowInsets = WindowInsets.systemBars,
            modifier = Modifier,
            topBar = {
                TopAppBar(title = {
                    Text("지역별 백신 접종률")
                })
            }
        ) {

            val regionList = remember {
                RegionVaccineAchieve.mock
            }

            LazyColumn(
                modifier = Modifier.padding(it),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        InfluenceSurface(
                            onClick = { isVaccineDialogShown = true },
                            color = LocalInfluenceColorPalette.current.adaptiveGray100,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                            ) {
                                Text(text = selectedVaccine.name, style = InfluenceTypography.body3)
                                Spacer(Modifier.width(10.dp))
                                Icon(
                                    imageVector = Icons.Rounded.ArrowDropDownCircle,
                                    contentDescription = null,
                                    tint = LocalInfluenceColorPalette.current.adaptiveGray300
                                )
                            }

                        }
                    }
                    Spacer(Modifier.height(20.dp))
                }

                itemsIndexed(regionList) { index, it ->
                    RegionVaccineListItem(
                        index,
                        regionVaccineAchieve = it,
                        isMine = remember { Me.mock.state } == it.region.value
                    )
                    Spacer(Modifier.height(20.dp))
                }

                item {
                    Spacer(Modifier.height(56.dp))
                    Spacer(Modifier.navigationBarsPadding())
                }
            }

        }


        if (isVaccineDialogShown) {
            Dialog({ isVaccineDialogShown = isVaccineDialogShown.not() }) {
                InfluenceSurface(
                    modifier = Modifier.size(300.dp, 500.dp),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        SmallHeader(title = "백신 선택")
                        Spacer(Modifier.height(10.dp))
                        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                            vaccines.forEach { vaccine ->
                                ClickScaleEffect({
                                    selectedVaccine = vaccine
                                    isVaccineDialogShown = false

                                }) {
                                    Text(
                                        modifier = Modifier.padding(10.dp),
                                        text = vaccine.name,
                                        style = InfluenceTypography.body3
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Rounded.Place)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "지역별",
                    icon = icon
                )
            }
        }
}