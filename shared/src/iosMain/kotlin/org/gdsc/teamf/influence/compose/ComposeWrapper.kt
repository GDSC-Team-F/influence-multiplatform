package org.gdsc.teamf.influence.compose

import androidx.compose.ui.uikit.ComposeUIViewControllerDelegate
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.gdsc.teamf.influence.compose.screens.RootScreen
import org.gdsc.teamf.influence.utils.ProvideEssentyLifecycleOwner
import platform.UIKit.UIViewController

object ComposeWrapper {

    fun composeViewController(): UIViewController {
        val lifecycleRegistry = LifecycleRegistry()
        val lifecycleOwner = object : LifecycleOwner {
            override val lifecycle: com.arkivanov.essenty.lifecycle.Lifecycle = lifecycleRegistry
        }
        return ComposeUIViewController(
            configure = {
                delegate = object : ComposeUIViewControllerDelegate {
                    override fun viewDidLoad() = lifecycleRegistry.onCreate()
                    override fun viewWillAppear(animated: Boolean) = lifecycleRegistry.onStart()
                    override fun viewDidAppear(animated: Boolean) = lifecycleRegistry.onResume()
                    override fun viewWillDisappear(animated: Boolean) = lifecycleRegistry.onPause()
                    override fun viewDidDisappear(animated: Boolean) = lifecycleRegistry.onStop()
                }
            }
        ) {
            ProvideEssentyLifecycleOwner(lifecycleOwner) {
                RootScreen()
            }
        }
    }
}