package org.gdsc.teamf.influence.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock

class ApiHelper(
    private val preference: DataStore<Preferences>,
) {

    private var _isExpired: Boolean = false
    val isExpired: Boolean get() = _isExpired

    init {
        CoroutineScope(Dispatchers.Default).launch {
            _isExpired = isExpired()
        }
    }

    suspend fun setToken(jwtTokenResponse: JwtTokenResponse) {
        preference.edit {
            it[KEY_ACCESS_TOKEN] = jwtTokenResponse.accessToken
            it[KEY_REFRESH_TOKEN] = jwtTokenResponse.refreshToken
            it[KEY_EXPIRE_IN] = Clock.System.now().toEpochMilliseconds() + EXPIRE_ACCESS_TOKEN_TIME
        }
    }

    suspend fun accessToken(): String? {
        return preference.data.map { it[KEY_ACCESS_TOKEN] }.firstOrNull()
    }

    suspend fun refreshToken(): String? {
        return preference.data.map { it[KEY_REFRESH_TOKEN] }.firstOrNull()
    }

    suspend fun clear() {
        preference.edit {
            it.remove(KEY_ACCESS_TOKEN)
            it.remove(KEY_REFRESH_TOKEN)
        }
    }

    private suspend fun isExpired(): Boolean {
        return (preference.data.map { it[KEY_EXPIRE_IN] ?: 0 }.firstOrNull() ?: 0) < Clock.System.now().toEpochMilliseconds()
    }

    companion object {
        val KEY_ACCESS_TOKEN = stringPreferencesKey("access_token")
        val KEY_REFRESH_TOKEN = stringPreferencesKey("refresh_token")
        val KEY_EXPIRE_IN = longPreferencesKey("expire_in")

        // 30m
        private const val EXPIRE_ACCESS_TOKEN_TIME = 30 * 60 * 1000

    }
}