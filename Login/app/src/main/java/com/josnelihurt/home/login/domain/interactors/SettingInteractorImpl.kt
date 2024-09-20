package com.josnelihurt.home.login.domain.interactors

import com.josnelihurt.home.login.domain.entities.SettingsEntity
import com.josnelihurt.home.login.domain.repositories.SettingsRepository
import javax.inject.Inject

class SettingInteractorImpl @Inject constructor(
    private val settingsRepository: SettingsRepository
) : SettingInteractor {
    override fun save(settings: SettingsEntity) {
        settingsRepository.save(settings)
    }
    override fun load(): SettingsEntity {
        return settingsRepository.load()
    }
}
