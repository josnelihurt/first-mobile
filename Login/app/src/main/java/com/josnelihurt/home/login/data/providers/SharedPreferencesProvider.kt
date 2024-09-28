package com.josnelihurt.home.login.data.providers

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Provider for the SharedPreferences, this hides the initialization of the SharedPreferences
 */
class SharedPreferencesProvider @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private const val SHARED_PREFS_NAME = "login_prefs"
    }

    /**
     * The SharedPreferences instance created by this provider
     */
    fun get() = _sharedPreferences

    private val _masterKeys = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val _sharedPreferences = EncryptedSharedPreferences.create(
        context,
        SHARED_PREFS_NAME,
        _masterKeys,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
}
