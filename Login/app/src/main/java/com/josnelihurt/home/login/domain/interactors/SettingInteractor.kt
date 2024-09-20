package com.josnelihurt.home.login.domain.interactors

import com.josnelihurt.home.login.domain.entities.SettingsEntity

/**
 * Service to manage the settings of the application
 */
interface SettingInteractor {
    /**
     * Save the settings
     * @param settings the settings to save
     */
    fun save(settings: SettingsEntity)
    /**
     * Load the settings
     * @return the settings
     */
    fun load(): SettingsEntity
}
