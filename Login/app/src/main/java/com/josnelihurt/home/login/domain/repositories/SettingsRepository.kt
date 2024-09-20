package com.josnelihurt.home.login.domain.repositories

import com.josnelihurt.home.login.domain.entities.SettingsEntity

interface SettingsRepository {
    fun save(settings: SettingsEntity)
    fun load(): SettingsEntity
}
