package org.gdsc.teamf.influence.compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.gdsc.teamf.influence.compose.components.Grid
import org.gdsc.teamf.influence.compose.components.InfluenceCtaButton
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.components.NavigationBackButton
import org.gdsc.teamf.influence.compose.components.input.ClickScaleEffect
import org.gdsc.teamf.influence.compose.components.input.InfluenceBoarderTextField
import org.gdsc.teamf.influence.compose.components.list.SmallHeader
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.data.entity.Condition
import org.gdsc.teamf.influence.data.entity.LivingState
import org.gdsc.teamf.influence.di.koinViewModel
import org.gdsc.teamf.influence.utils.collectSideEffect
import org.gdsc.teamf.influence.utils.imageResource
import org.gdsc.teamf.influence.viewmodel.RegisterScreenViewModel

object RegisterScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val viewModel = koinViewModel<RegisterScreenViewModel>()

        viewModel.collectSideEffect {
            if (it == RegisterScreenViewModel.SideEffect.RegisterSucceed) {
                navigator.pop()
            }
        }


        var name by remember { mutableStateOf("") }

        var email by remember { mutableStateOf("") }

        var password by remember { mutableStateOf("") }

        var selectedConditions = remember { mutableStateListOf<Condition>() }

        var livingState by remember { mutableStateOf(LivingState.서울특별시) }

        var age by remember { mutableStateOf(20) }

        var gender by remember { mutableStateOf(0) }

        var characterId by remember { mutableStateOf(0) }

        val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

        Scaffold(
            modifier = Modifier.fillMaxSize().nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
            contentWindowInsets = WindowInsets.systemBars,
            bottomBar = {

                InfluenceSurface {
                    Box(Modifier.navigationBarsPadding()) {
                        InfluenceCtaButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp, vertical = 10.dp),
                            text = "회원가입",
                            onClick = {
                                viewModel.register(
                                    email,
                                    password,
                                    name,
                                    selectedConditions,
                                    livingState!!,
                                    0,
                                    0,
                                    0,
                                )
                            }
                        )
                    }
                }
            },
            topBar = {
                Column {
                    LargeTopAppBar(
                        modifier = Modifier,
                        title = {
                            Text("가입하기")
                        },
                        navigationIcon = { NavigationBackButton { navigator.pop() } },
                        scrollBehavior = topAppBarScrollBehavior,
                        colors = TopAppBarDefaults.largeTopAppBarColors(scrolledContainerColor = LocalInfluenceColorPalette.current.adaptiveGray0),
                    )

                    Divider(
                        thickness = 1.dp,
                        color = LocalInfluenceColorPalette.current.adaptiveGray100.copy(topAppBarScrollBehavior.state.collapsedFraction)
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier.padding(it).verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    SmallHeader(title = "이름")
                    Spacer(Modifier.height(20.dp))
                    InfluenceBoarderTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = name,
                        onValueChange = { name = it },
                        placeholder = { Text("이름을 알려주세요.") },
                    )

                    Spacer(Modifier.height(20.dp))
                    SmallHeader(title = "나이")
                    Spacer(Modifier.height(20.dp))
                    InfluenceBoarderTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = age.toString(),
                        onValueChange = {
                            if (it.isEmpty()) {
                                age = 14
                            } else {
                                age = it.toInt()
                            }
                        },
                        placeholder = { Text("나이를 알려주세요.") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                    Spacer(Modifier.height(20.dp))

                    SmallHeader(title = "거주지역")

                    Spacer(Modifier.height(20.dp))

                    val livingStates = remember { LivingState.entries }

                    Box(Modifier.fillMaxWidth()) {

                        var expanded by remember { mutableStateOf(false) }

                        ClickScaleEffect(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                expanded = expanded.not()
                            }
                        ) {
                            InfluenceSurface(
                                modifier = Modifier.fillMaxWidth(),
                                color = LocalInfluenceColorPalette.current.adaptiveGray100,
                                shape = RoundedCornerShape(20.dp),
                            ) {
                                Text(
                                    livingState.name,
                                    modifier = Modifier.padding(20.dp),
                                    style = InfluenceTypography.body3,
                                )
                            }
                        }

                        DropdownMenu(
                            modifier = Modifier,
                            expanded = expanded,
                            onDismissRequest = { expanded = expanded.not() },
                        ) {
                            Grid(3, livingStates.size) {
                                val state = livingStates[it]
                                DropdownMenuItem(
                                    text = { Text(state.name) },
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    onClick = {
                                        livingState = state
                                        expanded = expanded.not()
                                    }
                                )
                            }
                        }

                    }

                    Spacer(Modifier.height(20.dp))
                    SmallHeader(title = "특이사항 (선택)")
                    Spacer(Modifier.height(20.dp))
                    val conditions = remember { Condition.entries }
                    Grid(2, conditions.size) {
                        val condition = conditions[it]
                        Row(modifier = Modifier.weight(1f), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                            androidx.compose.material3.Checkbox(
                                checked = condition in selectedConditions,
                                onCheckedChange = {
                                    if (condition in selectedConditions) {
                                        selectedConditions.remove(condition)
                                    } else {
                                        selectedConditions.add(condition)
                                    }
                                },
                            )
                            Text(
                                condition.name,
                                style = InfluenceTypography.body3,
                            )
                        }
                    }

                    Spacer(Modifier.height(20.dp))

                    // 성별
                    SmallHeader(title = "성별")
                    Spacer(Modifier.height(20.dp))
                    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                        Row(modifier = Modifier.weight(1f), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                            RadioButton(
                                selected = gender == 0,
                                onClick = { gender = 0 },
                            )
                            Text(
                                "남자",
                            )
                        }
                        Spacer(Modifier.width(10.dp))
                        Row(modifier = Modifier.weight(1f), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                            RadioButton(
                                selected = gender == 1,
                                onClick = { gender = 1 },
                            )
                            Text(
                                "여자",
                            )
                        }
                    }

                    Spacer(Modifier.height(40.dp))

                    SmallHeader(title = "계정 정보")
                    Spacer(Modifier.height(20.dp))
                    InfluenceBoarderTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text("***@email.com") },
                    )
                    Spacer(Modifier.height(20.dp))
                    InfluenceBoarderTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("비밀번호") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    )

                    Spacer(Modifier.height(40.dp))

                    SmallHeader(title = "내 접종 도우미 식물 선택")
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "접종을 받을때마다 식물이 자라요!",
                        color = LocalInfluenceColorPalette.current.adaptiveGray500,
                        style = InfluenceTypography.body3
                    )
                    Spacer(Modifier.height(20.dp))
                    Row {
                        (0..3).forEach { index ->
                            CharacterItem(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(5.dp),
                                characterId = index,
                                selected = characterId == index,
                                onClick = { characterId = index }
                            )
                        }
                    }

                    Spacer(Modifier.height(20.dp))
                    Spacer(Modifier.navigationBarsPadding())
                }
            }
        }
    }

}

@Composable
private fun CharacterItem(
    modifier: Modifier,
    characterId: Int,
    selected: Boolean,
    onClick: () -> Unit,
) {

    InfluenceSurface(
        modifier = modifier,
        color = if (selected) Color.White else LocalInfluenceColorPalette.current.adaptiveGray100,
        shape = RoundedCornerShape(20.dp),
        shadowElevation = if (selected) 10.dp else 0.dp,
        border = if (selected) androidx.compose.foundation.BorderStroke(2.dp, LocalInfluenceColorPalette.current.green) else null,
        onClick = onClick
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            contentDescription = null,
            painter = imageResource("plant_${characterId + 1}_7"),
        )

    }
}