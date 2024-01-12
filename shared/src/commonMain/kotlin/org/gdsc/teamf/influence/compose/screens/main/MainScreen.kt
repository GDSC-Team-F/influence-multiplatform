package org.gdsc.teamf.influence.compose.screens.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import org.gdsc.teamf.influence.compose.components.InfluenceSurface
import org.gdsc.teamf.influence.compose.style.InfluenceColorPalette
import org.gdsc.teamf.influence.compose.style.InfluenceTypography

object MainScreen : Screen {

    @Composable
    override fun Content() {
        TabNavigator(HomeTab) {
            val tabNavigator = LocalTabNavigator.current
            Scaffold(
                contentWindowInsets = WindowInsets.systemBars,
                modifier = Modifier,
                bottomBar = {
                    InfluenceSurface(
                        border = BorderStroke(1.dp, InfluenceColorPalette.current.adaptiveGray100)
                    ) {

                        NavigationBar(
                            modifier = Modifier.fillMaxWidth().navigationBarsPadding(),
                            containerColor = Color.Unspecified,
                        ) {

                            val tabs = remember { listOf(HomeTab, RegionTab, MyPageTab) }

                            tabs.forEach {
                                val isSelected = tabNavigator.current == it

                                val contentColor by animateColorAsState(
                                    targetValue = if (isSelected) InfluenceColorPalette.current.adaptiveGray900 else InfluenceColorPalette.current.adaptiveGray400,
                                    label = "Content Color"
                                )

                                CompositionLocalProvider(LocalContentColor provides contentColor) {
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .height(70.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .selectable(
                                                    selected = isSelected,
                                                    onClick = { tabNavigator.current = it },
                                                    enabled = true,
                                                    role = Role.Tab,
                                                    interactionSource = remember { MutableInteractionSource() },
                                                    indication = null,
                                                ),
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Box(
                                                modifier = Modifier.size(28.dp),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Icon(it.options.icon!!, contentDescription = null)
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            ProvideTextStyle(InfluenceTypography.body4) {
                                                Text(text = it.options.title)
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            ) {
                CurrentTab()
            }
        }
    }

}