package com.josnelihurt.home.login.domain.interactors

import com.josnelihurt.home.login.domain.entities.SettingsEntity
import com.josnelihurt.home.login.domain.usecases.LoadSettingsUseCase
import com.josnelihurt.home.login.domain.usecases.SaveSettingsUseCase
import javax.inject.Inject

class SettingInteractorImpl @Inject constructor(
    private val saveSettingsUseCase: SaveSettingsUseCase,
    private val loadSettingsUseCase: LoadSettingsUseCase
) : SettingInteractor {
    /**
     * Save the settings
     */
    override fun save(settings: SettingsEntity) = saveSettingsUseCase(settings)
    /**
     * Load the settings
     */
    override fun load(): SettingsEntity = loadSettingsUseCase()
}
