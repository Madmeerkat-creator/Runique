package com.plcoding.core.data.auth

import android.content.SharedPreferences
import com.plcoding.core.domain.AuthInfo
import com.plcoding.core.domain.SessionStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/* <6.6.3>
sensitive data
encrypt sharedPreferences -> 다른 앱들이 우리의 sharedPreferences에 접근할 수 없도록
 */
class EncryptedSessionStorage(
    private val sharedPreferences: SharedPreferences
): SessionStorage {

    override suspend fun get(): AuthInfo? {
        return withContext(Dispatchers.IO) {
            val json = sharedPreferences.getString(KEY_AUTH_INFO, null)
            json?.let {
                Json.decodeFromString<AuthInfoSerializable>(it).toAuthInfo()
            }
        }
    }

    override suspend fun set(info: AuthInfo?) {
        withContext(Dispatchers.IO) {
            if(info == null) {
                sharedPreferences.edit().remove(KEY_AUTH_INFO).commit()
                return@withContext
            }
            /*
             if we want to convert data class to json using kotlinx.serialization,
             it need annotation serializable.
             하지만 AuthInfo는 독립적이어야 하기 때문에 serializable을 붙일 수 없음
             */
            val json = Json.encodeToString(info.toAuthInfoSerializable())
            sharedPreferences
                .edit()
                .putString(KEY_AUTH_INFO, json)
                .commit()
        }
    }

    companion object {
        private const val KEY_AUTH_INFO = "KEY_AUTH_INFO"
    }
}