package com.josnelihurt.home.login.domain.repositories

import com.josnelihurt.home.login.domain.entities.LoginEntity

/**
 * Repository interface that defines the methods to save and retrieve the login entity.
 */
interface LoginRepository {
    /**
     * Saves the login entity data.
     * @param loginEntity The login entity containing the data to be saved.
     */
    fun save(loginEntity: LoginEntity)
    /**
     * Retrieves the login entity data.
     * @return The login entity containing the retrieved data.
     */
    fun get(): LoginEntity
}

