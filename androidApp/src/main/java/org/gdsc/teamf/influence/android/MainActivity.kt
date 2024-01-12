package org.gdsc.teamf.influence.android

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.essentyLifecycle
import org.gdsc.teamf.influence.compose.screens.RootScreen
import org.gdsc.teamf.influence.utils.ProvideEssentyLifecycleOwner
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT))

        val lifecycleOwner: LifecycleOwner = this

        val essentyLifecycleOwner = object : com.arkivanov.essenty.lifecycle.LifecycleOwner {
            override val lifecycle: Lifecycle
                get() = lifecycleOwner.essentyLifecycle()
        }

        setContent {
            ProvideEssentyLifecycleOwner(lifecycleOwner = essentyLifecycleOwner) {
                RootScreen(
                    application = {
                        androidContext(this@MainActivity.applicationContext)
//                        androidLogger(Level.DEBUG)
                    }
                )
            }
        }
    }
}