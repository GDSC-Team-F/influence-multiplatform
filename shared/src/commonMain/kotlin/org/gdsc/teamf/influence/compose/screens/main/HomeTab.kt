package org.gdsc.teamf.influence.compose.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.components.list.Header
import org.gdsc.teamf.influence.compose.components.list.SmallHeader
import org.gdsc.teamf.influence.compose.components.list.VaccineGridItem
import org.gdsc.teamf.influence.compose.components.list.VaccineListItem
import org.gdsc.teamf.influence.compose.icons.InfluenceIcons
import org.gdsc.teamf.influence.compose.icons.Logo
import org.gdsc.teamf.influence.compose.screens.FriendsScreen
import org.gdsc.teamf.influence.compose.screens.LocalMe
import org.gdsc.teamf.influence.compose.screens.VaccineScreen
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.data.entity.Me
import org.gdsc.teamf.influence.di.koinViewModel
import org.gdsc.teamf.influence.utils.collectAsState
import org.gdsc.teamf.influence.utils.collectSideEffect
import org.gdsc.teamf.influence.utils.imageResource
import org.gdsc.teamf.influence.viewmodel.HomeTabViewModel
import kotlin.math.roundToInt

object HomeTab : Tab {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val homeTabViewModel = koinViewModel<HomeTabViewModel>()
        val state by homeTabViewModel.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            homeTabViewModel.load()
        }

        var showPointedFriends by remember { mutableStateOf(null as HomeTabViewModel.PointedFriendData?) }

        homeTabViewModel.collectSideEffect {
            when (it) {
                is HomeTabViewModel.SideEffect.ShowPointedFriend -> {
                    showPointedFriends = it.pointedFriendData
                }
            }
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Icon(
                            modifier = Modifier.width(100.dp),
                            imageVector = InfluenceIcons.Logo,
                            contentDescription = "로고",
                            tint = Color.Unspecified
                        )
                    },
                    actions = {
                        IconButton({
                            navigator.parent?.push(FriendsScreen)
                        }) {
                            Icon(Icons.Rounded.PersonAdd, contentDescription = "친구 추가")
                        }
                    }
                )
            }
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(it),
                contentPadding = PaddingValues(10.dp)
            ) {
                item(span = { GridItemSpan(2) }) {
                    InfluenceSurface(
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        color = LocalInfluenceColorPalette.current.darkGreen,
                        contentColor = Color.White,
                        shape = RoundedCornerShape(20.dp),
                    ) {

                        Column(modifier = Modifier.padding(20.dp)) {

                            Text(text = "내 백신 달성률", style = InfluenceTypography.title3)

                            val leftDays = remember {
                                val now = Clock.System.now()
                                val timezone = TimeZone.currentSystemDefault()
                                now.daysUntil(
                                    LocalDateTime(now.toLocalDateTime(timezone).year, 12, 31, 0, 0, 0).toInstant(timezone),
                                    timezone
                                )
                            }

                            val me = LocalMe.current

                            Spacer(Modifier.height(20.dp))

                            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {

                                Surface(
                                    modifier = Modifier,
                                    shape = CircleShape,
                                    color = LocalInfluenceColorPalette.current.adaptiveGray0,
                                ) {
                                    Box(Modifier.padding(10.dp)) {
                                        Image(
                                            imageResource(me.characterImageRes),
                                            contentDescription = me.name,
                                            modifier = Modifier
                                                .size(36.dp)
                                        )
                                    }
                                }

                                Spacer(Modifier.width(20.dp))
                                Column {
                                    Text(
                                        text = "${(me.progress * 100).roundToInt() / 100.0}%",
                                        style = InfluenceTypography.heading1,
                                        color = LocalInfluenceColorPalette.current.green
                                    )
                                    Text(
                                        text = "${leftDays}일 남았어요. ${if (leftDays < 100) "얼른 접종해주세요!" else ""}",
                                        style = InfluenceTypography.body4,
                                        color = LocalContentColor.current.copy(alpha = 0.5f)
                                    )
                                }

                            }

                            Spacer(Modifier.height(20.dp))

                            LinearProgressIndicator(
                                progress = me.progress / 100f,
                                modifier = Modifier.fillMaxWidth().height(20.dp),
                                color = LocalInfluenceColorPalette.current.green,
                                trackColor = Color.White.copy(alpha = 0.2f),
                                strokeCap = StrokeCap.Round
                            )
                        }
                    }
                }

                item(span = { GridItemSpan(2) }) {
                    Spacer(Modifier.height(20.dp))
                }

                item(span = { GridItemSpan(2) }) {
                    SmallHeader(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                        title = "내가 맞아야 하는 백신"
                    )
                }
                items(state.notVaccinated) {
                    VaccineGridItem(
                        modifier = Modifier.padding(10.dp),
                        vaccine = it,
                        onClick = {
                            navigator.parent?.push(VaccineScreen(it, state.friendListState.getOrNull().orEmpty()))
                        })
                }

                item(
                    span = { GridItemSpan(2) }
                ) {
                    Divider(
                        modifier = Modifier.padding(10.dp, vertical = 20.dp),
                        thickness = 1.dp,
                        color = LocalInfluenceColorPalette.current.adaptiveGray100
                    )
                }

                item(span = { GridItemSpan(2) }) {
                    SmallHeader(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                        title = "이미 맞은 백신"
                    )
                }

                items(state.vaccinated) {
                    VaccineGridItem(
                        modifier = Modifier.padding(10.dp),
                        vaccine = it, onClick = {
                            navigator.parent?.push(VaccineScreen(it, state.friendListState.getOrNull().orEmpty()))
                        })
                }

                item(span = { GridItemSpan(2) }) {
                    Spacer(Modifier.height(100.dp))
                    Spacer(Modifier.navigationBarsPadding())
                }
            }

        }

        if (showPointedFriends != null) {
            Dialog({ showPointedFriends = null }) {
                InfluenceSurface(
                    modifier = Modifier.width(300.dp),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        showPointedFriends?.let {
                            Header(
                                title = "${it.friend?.name}님이 건강을 위해\n백신을 맞으라고 찔렀어요!",
                                subtitle = "얼른 맞고 건강을 지키세요!",
                            )
                            Spacer(Modifier.height(20.dp))
                            it.vaccine?.let { it1 ->
                                VaccineListItem(
                                    modifier = Modifier,
                                    vaccine = it1,
                                    onClick = {
                                        navigator.parent?.push(VaccineScreen(it, state.friendListState.getOrNull().orEmpty()))
                                    }
                                )
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
            val icon = rememberVectorPainter(Icons.Rounded.Home)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "홈",
                    icon = icon
                )
            }
        }
}