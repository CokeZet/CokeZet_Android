package buy.coke.zet.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class TokenManager @Inject constructor(
    private val userPreferencesStore: DataStore<Preferences>
) {
    suspend fun saveTokens(accessToken: String?, refreshToken: String?) {
        if (accessToken.isNullOrEmpty() || refreshToken.isNullOrEmpty()) {
            return
        }

        userPreferencesStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = accessToken
            preferences[REFRESH_TOKEN] = refreshToken
        }
    }

    suspend fun saveAccessToken(accessToken: String?) {
        if (accessToken.isNullOrEmpty()) {
            return
        }

        userPreferencesStore.edit { preferences -> preferences[ACCESS_TOKEN] = accessToken }
    }

    suspend fun clearTokens() {
        userPreferencesStore.edit { preferences ->
            preferences.remove(ACCESS_TOKEN)
            preferences.remove(REFRESH_TOKEN)
        }
    }

    fun getAccessToken(): String? = runBlocking {
        userPreferencesStore.data.first()[ACCESS_TOKEN]
    }

    fun getRefreshToken(): String? = runBlocking {
        userPreferencesStore.data.first()[REFRESH_TOKEN]
    }

    fun isHasToken(): Boolean = runBlocking {
        !userPreferencesStore.data.first()[ACCESS_TOKEN].isNullOrEmpty()
    }

    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("access_token")
        private val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
    }
}