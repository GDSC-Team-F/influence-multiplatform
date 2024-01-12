package org.gdsc.teamf.influence.compose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.gdsc.teamf.influence.compose.components.InfluenceCtaButton
import org.gdsc.teamf.influence.compose.components.input.InfluenceBoarderTextField
import org.gdsc.teamf.influence.compose.icons.InfluenceIcons
import org.gdsc.teamf.influence.compose.icons.Logo
import org.gdsc.teamf.influence.compose.style.InfluenceTypography
import org.gdsc.teamf.influence.compose.style.LocalInfluenceColorPalette
import org.gdsc.teamf.influence.di.koinViewModel
import org.gdsc.teamf.influence.utils.collectSideEffect
import org.gdsc.teamf.influence.viewmodel.LoginScreenViewModel

object LoginScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = koinViewModel<LoginScreenViewModel>()

        val navigator = LocalNavigator.currentOrThrow

        val rootViewModel = LocalRootViewModel.current

        viewModel.collectSideEffect {
            if (it == LoginScreenViewModel.SideEffect.UpdateMe) {
                rootViewModel.refreshApp()
            }
        }

        Scaffold(
            contentWindowInsets = WindowInsets.systemBars,
            modifier = Modifier,
        ) {

            Box(
                modifier = Modifier.padding(it).fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {


                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
                ) {

                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(200.dp),
                        contentDescription = null,
                        imageVector = InfluenceIcons.Logo,
                    )
                    Spacer(Modifier.height(20.dp))
                    Text(
                        "소중한 사람을 위한 선한 영향력",
                        style = InfluenceTypography.body3,
                        color = LocalInfluenceColorPalette.current.adaptiveGray500
                    )

                    Spacer(Modifier.height(100.dp))

                    var email by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }

                    InfluenceBoarderTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = email,
                        onValueChange = { email = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        placeholder = { Text("이메일") }
                    )

                    Spacer(Modifier.height(10.dp))

                    InfluenceBoarderTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("비밀번호") },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    )

                    Spacer(Modifier.height(10.dp))

                    InfluenceCtaButton(
                        {
                            if (email.isNotEmpty() && password.isNotEmpty()) {
                                viewModel.login(email, password)
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        text = "로그인",
                    )

                    Spacer(Modifier.height(20.dp))

                    Text(
                        buildAnnotatedString {
                            append("아직 계정이 없으신가요? ")
                            pushStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                            pushStyle(SpanStyle(color = LocalInfluenceColorPalette.current.green))
                            append("회원가입")
                            pop()
                        },
                        modifier = Modifier
                            .padding(horizontal = 16.dp).clickable(
                                interactionSource = remember {
                                    MutableInteractionSource()
                                },
                                indication = null
                            ) {
                                navigator.push(RegisterScreen)
                            },
                        color = LocalInfluenceColorPalette.current.adaptiveGray400,
                        style = InfluenceTypography.body3
                    )

                }

            }

        }
    }

}