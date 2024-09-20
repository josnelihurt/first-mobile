package com.josnelihurt.home.login.domain.interactors

import com.josnelihurt.home.login.domain.entities.LoginEntity

interface AuthInteractor {
    suspend fun login(loginEntity: LoginEntity)
    fun restoreLogin(): LoginEntity
}
