package com.josnelihurt.home.login.data.repositories

import android.content.Context
import android.net.Uri
import com.josnelihurt.home.R
import com.josnelihurt.home.login.data.api.MobileAPI
import com.josnelihurt.home.login.data.providers.SharedPreferencesProvider
import com.josnelihurt.home.login.data.repositories.models.SettingsModel
import com.josnelihurt.home.login.domain.entities.SettingsEntity
import com.josnelihurt.home.login.domain.repositories.SettingsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val sharedPreferencesProvider: SharedPreferencesProvider,
) : SettingsRepository {
    companion object{
        private const val SETTINGS_KEY = "local_settings"
    }

    val defaultServer = context.getString(R.string.default_server)
    private val _sharedPreferences = sharedPreferencesProvider.get()
    override fun save(settings: SettingsEntity) =
        _sharedPreferences.edit().putString("server", settings.server).apply()

    override fun load(): SettingsEntity {
        val result = loadLocal()
        val mobileAPI = MobileAPI(result.serverConfiguration.server)
        val remoteSettings = mobileAPI.boot()
        result.oAuthConfiguration = remoteSettings.oAuthConfiguration
        return result
    }

    private fun loadLocal(): SettingsEntity  {
        val settingsJSON = _sharedPreferences.getString(SETTINGS_KEY, "")
        if (settingsJSON.isNullOrEmpty()) {
            var defaultResult = SettingsEntity()
            defaultResult.serverConfiguration.server = Uri.parse(defaultServer)
            return defaultResult
        }
        val settings = SettingsModel.fromJson(settingsJSON)
        return settings.toEntity()
    }
}
