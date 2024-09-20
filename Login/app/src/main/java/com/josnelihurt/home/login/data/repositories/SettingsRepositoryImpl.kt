package com.josnelihurt.home.login.data.repositories

import com.josnelihurt.home.login.data.providers.SharedPreferencesProvider
import com.josnelihurt.home.login.domain.entities.SettingsEntity
import com.josnelihurt.home.login.domain.repositories.SettingsRepository
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val sharedPreferencesProvider: SharedPreferencesProvider
) : SettingsRepository {

    val defaultServer = "https://api.josnelihurt.com"

    private val _sharedPreferences = sharedPreferencesProvider.get()
    override fun save(settings: SettingsEntity) {
        _sharedPreferences.edit().putString("server", settings.server).apply()
    }
    override fun load(): SettingsEntity {
        val settings = SettingsEntity()
        settings.server = _sharedPreferences.getString("server", defaultServer) ?: defaultServer
        return settings
    }
}
