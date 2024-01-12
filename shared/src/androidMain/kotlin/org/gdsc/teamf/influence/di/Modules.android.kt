package org.gdsc.teamf.influence.di

import io.ktor.client.engine.android.Android
import okio.Okio
import org.gdsc.teamf.influence.data.ApiHttpClient
import org.gdsc.teamf.influence.data.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single { androidContext().dataStore }
        single { ApiHttpClient(get(), Android) }
    }
}