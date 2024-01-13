package org.gdsc.teamf.influence.compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Coronavirus
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Today
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.gdsc.teamf.influence.compose.components.Grid
import org.gdsc.teamf.influence.compose.components.InfluenceCtaButton
import org.gdsc.teamf.influence.compose.components.InfluenceRoundIcon
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.components.NavigationBackButton
import org.gdsc.teamf.influence.compose.components.list.FriendGridItem
import org.gdsc.teamf.influence.compose.components.list.Header
import org.gdsc.teamf.influence.compose.components.list.InfluenceListItem
import org.gdsc.teamf.influence.compose.components.list.MediumHeader
import org.gdsc.teamf.influence.compose.components.list.SmallHeader
import org.gdsc.teamf.influence.compose.components.list.VaccineListItem
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.data.Friend
import org.gdsc.teamf.influence.data.entity.Vaccine
import org.gdsc.teamf.influence.di.koinViewModel
import org.gdsc.teamf.influence.utils.collectAsState
import org.gdsc.teamf.influence.utils.collectSideEffect
import org.gdsc.teamf.influence.utils.imageResource
import org.gdsc.teamf.influence.viewmodel.VaccineScreenViewModel

class VaccineScreen(
    val vaccine: Vaccine,
    val friends : List<Friend>
) : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<VaccineScreenViewModel>()
        val state by viewModel.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        var showWarning by remember { mutableStateOf(false) }

        val me = LocalMe.current

        viewModel.collectSideEffect {
            when (it) {
                is VaccineScreenViewModel.SideEffect.Pop -> {
                    navigator.pop()
                }
            }
        }

        LaunchedEffect(Unit) {
            viewModel.load(vaccine, friends)

            if (me.conditions.isNotEmpty()) {
                showWarning = true
            }
        }

        val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

        Scaffold(
            modifier = Modifier.fillMaxSize().nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
            topBar = {
                Column {
                    LargeTopAppBar(
                        title = { Text(vaccine.name) },
                        navigationIcon = { NavigationBackButton { navigator.pop() } },
                        colors = TopAppBarDefaults.largeTopAppBarColors(scrolledContainerColor = LocalInfluenceColorPalette.current.adaptiveGray0),
                        scrollBehavior = topAppBarScrollBehavior
                    )
                    Divider(
                        thickness = 1.dp,
                        color = LocalInfluenceColorPalette.current.adaptiveGray100.copy(topAppBarScrollBehavior.state.collapsedFraction)
                    )
                }
            },
            bottomBar = {
                if (!vaccine.vaccinated) {
                    InfluenceSurface {
                        Box(Modifier.navigationBarsPadding()) {
                            InfluenceCtaButton(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 10.dp),
                                text = "접종했어요!",
                                onClick = {
                                    viewModel.vaccinated(vaccine.id)
                                }
                            )
                        }
                    }
                }
            }
        ) {

            LazyColumn(
                modifier = Modifier.padding(it),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(20.dp)
            ) {

                item {
                    InfluenceSurface(
                        modifier = Modifier.fillMaxWidth(),
                        color = LocalInfluenceColorPalette.current.adaptiveGray100,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
                    ) {

                        Column(modifier = Modifier) {
                            MediumHeader(
                                modifier = Modifier.padding(20.dp),
                                title = "접종 정보"
                            )

                            InfluenceListItem(
                                leadingContent = {
                                    InfluenceRoundIcon(
                                        icon = Icons.Rounded.Person,
                                        tint = LocalInfluenceColorPalette.current.blue,
                                    )
                                },
                                headlineContent = { Text("접종 대상", style = InfluenceTypography.title3) },
                                supportingContent = { Text(vaccine.vaccinationTarget, style = InfluenceTypography.body3) },
                                overlineContent = { }
                            )

                            InfluenceListItem(
                                leadingContent = {
                                    InfluenceRoundIcon(
                                        icon = Icons.Rounded.Today,
                                        tint = LocalInfluenceColorPalette.current.yellow,
                                    )
                                },
                                headlineContent = { Text("접종 시기", style = InfluenceTypography.title3) },
                                supportingContent = { Text(vaccine.vaccinationPeriod, style = InfluenceTypography.body3) },
                                overlineContent = { }
                            )
                        }

                    }
                    Spacer(Modifier.height(20.dp))
                }

                vaccine.disease?.let {

                    item {
                        InfluenceSurface(
                            modifier = Modifier.fillMaxWidth(),
                            color = LocalInfluenceColorPalette.current.lightPurple,
                            shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
                        ) {

                            Column(modifier = Modifier.padding(10.dp)) {
                                // 설명,예방접종명,접종대상,접종시기
                                Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                                    Spacer(Modifier.height(20.dp))
                                    Icon(
                                        imageVector = Icons.Rounded.Coronavirus,
                                        contentDescription = null,
                                        tint = LocalInfluenceColorPalette.current.purple,
                                    )
                                    Spacer(Modifier.height(10.dp))
                                    Text(
                                        text = "왜 접종 해야해요?",
                                        style = InfluenceTypography.title2,
                                        color = LocalInfluenceColorPalette.current.purple
                                    )
                                }
                                InfluenceListItem(
                                    headlineContent = { Text("${vaccine.disease.name}에 걸릴 수 있어요.", style = InfluenceTypography.title3) },
                                    supportingContent = { Text(vaccine.disease.description, style = InfluenceTypography.body3) },
                                )
                            }

                        }
                        Spacer(Modifier.height(20.dp))
                    }
                }

                item {
                    InfluenceSurface(
                        modifier = Modifier.fillMaxWidth(),
                        color = LocalInfluenceColorPalette.current.adaptiveGray100,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
                    ) {

                        Column {
                            SmallHeader(
                                modifier = Modifier.padding(20.dp),
                                title = "안 맞은 친구들"
                            )

                            state.notVaccinatedFriendsState.getOrNull()?.let { friends ->
                                Grid(3, friends.size) { idx ->
                                    FriendGridItem(friend = friends[idx], pointEnabled = true, onPointClick = {
                                        viewModel.point(vaccine.id, it.id)
                                    }
                                    )
                                }
                            }

                            Spacer(
                                Modifier.height(
                                    20.dp
                                )
                            )
                            SmallHeader(
                                modifier = Modifier.padding(20.dp),
                                title = "맞은 친구들"
                            )

                            state.vaccinatedFriendsState.getOrNull()?.let { friends ->
                                Grid(3, friends.size) {
                                    FriendGridItem(friend = friends[it])
                                }
                            }

                        }

                    }
                    Spacer(Modifier.height(20.dp))
                }

            }

        }

        if (showWarning) {

            Dialog({ showWarning = false }) {
                InfluenceSurface(
                    modifier = Modifier.width(440.dp),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Header(
                            title = "접종 주의!",
                            subtitle = "기저질환 환자, 임산부 등 특이사항이 있는 분들은 접종을 조심해야해요!",
                        )
                        Spacer(Modifier.height(20.dp))
                        Image(
                            painter = imageResource("warning"),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

    }

}