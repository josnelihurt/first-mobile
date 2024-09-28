package com.josnelihurt.home.login.domain.usecases

import com.josnelihurt.home.login.domain.entities.SettingsEntity
import com.josnelihurt.home.login.domain.repositories.SettingsRepository
import javax.inject.Inject

class SaveSettingsUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
){
    operator fun invoke(entity: SettingsEntity) {
        settingsRepository.save(entity)
    }
}