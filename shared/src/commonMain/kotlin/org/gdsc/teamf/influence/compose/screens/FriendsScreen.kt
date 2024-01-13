package org.gdsc.teamf.influence.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PersonAdd
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.gdsc.teamf.influence.compose.components.InfluenceCtaButton
import org.gdsc.teamf.influence.compose.components.InfluenceRoundIcon
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.components.NavigationBackButton
import org.gdsc.teamf.influence.compose.components.input.InfluenceBoarderTextField
import org.gdsc.teamf.influence.compose.components.input.InfluenceOutlinedTextField
import org.gdsc.teamf.influence.compose.components.list.FriendListItem
import org.gdsc.teamf.influence.compose.components.list.SmallHeader
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.data.Friend
import org.gdsc.teamf.influence.di.koinViewModel
import org.gdsc.teamf.influence.utils.collectAsState
import org.gdsc.teamf.influence.utils.collectSideEffect
import org.gdsc.teamf.influence.viewmodel.FriendsScreenViewModel

object FriendsScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val viewModel = koinViewModel<FriendsScreenViewModel>()

        LaunchedEffect(Unit) {
            viewModel.fetch()
        }

        viewModel.collectSideEffect {
            if (it == FriendsScreenViewModel.SideEffect.InviteSucceed) {
                viewModel.fetch()
            }
        }

        val state by viewModel.collectAsState()

        Scaffold(
            contentWindowInsets = WindowInsets.systemBars,
            modifier = Modifier,
            topBar = {
                TopAppBar(
                    title = { Text("친구") },
                    navigationIcon = {
                        NavigationBackButton { navigator.pop() }
                    }
                )
            }
        ) {

            var email by remember { mutableStateOf("") }

            LazyColumn(
                modifier = Modifier.padding(it),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    InfluenceSurface(
                        modifier = Modifier.fillMaxWidth(),
                        color = LocalInfluenceColorPalette.current.adaptiveGray100,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(20.dp),
                            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.PersonAdd,
                                contentDescription = null,
                                tint = LocalInfluenceColorPalette.current.adaptiveGray900
                            )

                            Spacer(Modifier.height(10.dp))
                            Text(
                                text = "내 이메일을 공유해서\n친구를 추가해보세요!",
                                style = org.gdsc.teamf.influence.compose.style.InfluenceTypography.title2,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                text = "친구를 추가하면 친구의 백신 접종 상황을 볼 수 있어요.",
                                style = org.gdsc.teamf.influence.compose.style.InfluenceTypography.body3,
                                color = LocalInfluenceColorPalette.current.adaptiveGray500,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )

                            Spacer(Modifier.height(20.dp))

                            Text(
                                text = LocalMe.current.email,
                                style = org.gdsc.teamf.influence.compose.style.InfluenceTypography.title3,
                                color = LocalInfluenceColorPalette.current.darkGreen,
                            )

                            Spacer(Modifier.height(20.dp))

                            InfluenceOutlinedTextField(
                                email, { email = it },
                                modifier = Modifier.fillMaxWidth(),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = LocalInfluenceColorPalette.current.adaptiveGray0,
                                    unfocusedContainerColor = LocalInfluenceColorPalette.current.adaptiveGray0,
                                    focusedLabelColor = LocalInfluenceColorPalette.current.adaptiveGray900,
                                    unfocusedLabelColor = LocalInfluenceColorPalette.current.adaptiveGray300,

                                    focusedTextColor = LocalInfluenceColorPalette.current.adaptiveGray900,
                                    unfocusedTextColor = LocalInfluenceColorPalette.current.adaptiveGray900,

                                    unfocusedBorderColor = LocalInfluenceColorPalette.current.adaptiveGray200,
                                    focusedBorderColor = LocalInfluenceColorPalette.current.adaptiveGray700,

                                    focusedPlaceholderColor = LocalInfluenceColorPalette.current.adaptiveGray300,
                                    unfocusedPlaceholderColor = LocalInfluenceColorPalette.current.adaptiveGray300,

                                    cursorColor = LocalInfluenceColorPalette.current.adaptiveGray900,

                                    )
                                ,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                                placeholder = { Text("또는 이메일로 친구 추가") }
                            )

                            Spacer(Modifier.height(20.dp))

                            InfluenceCtaButton({
                                viewModel.invite(email)
                            }, text = "친구 추가하기")
                        }
                    }
                    Spacer(Modifier.height(40.dp))
                }

                item {
                    SmallHeader(title = "내 친구들")
                    Spacer(Modifier.height(20.dp))
                }

                items(state.friends.getOrNull().orEmpty()) {
                    FriendListItem(it) {

                    }
                }

            }

        }
    }

}