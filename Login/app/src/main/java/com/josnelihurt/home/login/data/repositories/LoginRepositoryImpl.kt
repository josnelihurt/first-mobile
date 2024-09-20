package com.josnelihurt.home.login.data.repositories

import com.josnelihurt.home.login.data.providers.SharedPreferencesProvider
import com.josnelihurt.home.login.domain.entities.LoginEntity
import com.josnelihurt.home.login.domain.repositories.LoginRepository
import javax.inject.Inject

/**
 * Repository class that handles the encrypted shared preferences for the login entity.
 */
class LoginRepositoryImpl @Inject constructor(
    private val sharedPreferencesProvider: SharedPreferencesProvider
) : LoginRepository {
    companion object {
        private const val EMAIL_KEY = "email"
        private const val PASSWORD_KEY = "password"
        private const val SAVE_LOGIN_KEY = "save_login"
    }

    private val _sharedPreference = sharedPreferencesProvider.get()

    /**
     * Saves the login entity data to encrypted shared preferences.
     * @param loginEntity The login entity containing the data to be saved.
     */
    override fun save(loginEntity: LoginEntity) {
        putString(EMAIL_KEY, loginEntity.email)
        putString(PASSWORD_KEY, loginEntity.password)
        putBoolean(SAVE_LOGIN_KEY, loginEntity.saveLogin)
    }

    /**
     * Retrieves the login entity data from encrypted shared preferences.
     * @return The login entity containing the retrieved data.
     */
    override fun get(): LoginEntity {
        val loginEntity = LoginEntity()
        loginEntity.email = getString(EMAIL_KEY) ?: ""
        loginEntity.password = getString(PASSWORD_KEY) ?: ""
        loginEntity.saveLogin = getBoolean(SAVE_LOGIN_KEY)
        return loginEntity

    }

    private fun putString(key: String, value: String) =
        _sharedPreference.edit().putString(key, value).apply()

    private fun putBoolean(key: String, value: Boolean) =
        _sharedPreference.edit().putBoolean(key, value).apply()

    private fun getString(key: String): String? =
        _sharedPreference.getString(key, null)

    private fun getBoolean(key: String): Boolean = _sharedPreference.getBoolean(key, false)

}
