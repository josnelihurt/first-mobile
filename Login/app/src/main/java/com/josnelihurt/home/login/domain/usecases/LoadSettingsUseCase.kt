package com.josnelihurt.home.login.domain.usecases

import com.josnelihurt.home.login.domain.entities.SettingsEntity
import com.josnelihurt.home.login.domain.repositories.SettingsRepository
import javax.inject.Inject

class LoadSettingsUseCase @Inject constructor(
    private val settingsRepository: SettingsRepository
) {
    operator fun invoke(): SettingsEntity = settingsRepository.load()
}