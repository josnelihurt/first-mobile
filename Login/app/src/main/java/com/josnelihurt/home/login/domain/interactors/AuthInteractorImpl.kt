package com.josnelihurt.home.login.domain.interactors

import com.josnelihurt.home.login.domain.entities.LoginEntity
import com.josnelihurt.home.login.domain.usecases.LoginRestoreUseCase
import com.josnelihurt.home.login.domain.usecases.LoginUseCase
import com.josnelihurt.home.login.domain.usecases.SaveLoginUseCase
import javax.inject.Inject

/**
 * Interactor that manages the authentication process of the application and its persistence
 * @param loginUseCase use case that performs the login
 * @param loginRestoreUseCase use case that restores the login
 * @param saveLoginUseCase use case that saves the login
 */
class AuthInteractorImpl @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val loginRestoreUseCase: LoginRestoreUseCase,
    private val saveLoginUseCase: SaveLoginUseCase,
) : AuthInteractor {
    /**
     * Performs the login process and saves the login if the user has selected the option
     * @param loginEntity entity with the login data
     */
    override suspend fun login(loginEntity: LoginEntity) {
        loginUseCase(loginEntity)
        saveLoginUseCase(loginEntity)
    }
    /**
     * Restores the login data
     * @return the login entity
     */
    override fun restoreLogin() = loginRestoreUseCase()
}
