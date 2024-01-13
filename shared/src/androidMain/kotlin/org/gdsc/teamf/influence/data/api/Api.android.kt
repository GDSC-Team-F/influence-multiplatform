package org.gdsc.teamf.influence.data.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import org.gdsc.teamf.influence.data.ApiHelper
import org.gdsc.teamf.influence.data.ApiHttpClient

actual fun getApiHttpClient(apiHelper: ApiHelper): HttpClient {
    return ApiHttpClient(apiHelper, Android)
}