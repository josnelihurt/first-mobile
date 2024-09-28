package com.josnelihurt.home.login.presentation.viewmodel

import com.josnelihurt.home.login.domain.entities.LoginEntity

data class LoginState(
    val loginEnabled: Boolean = false,
    val saveLogin: Boolean = false,
    val email: String = "",
    val password: String = "",
) {
    fun withEnableLogin(enableLogin: Boolean): LoginState = copy(loginEnabled = enableLogin)
    fun withSaveLogin(saveLogin: Boolean): LoginState = copy(saveLogin = saveLogin)
    fun withEmail(email: String): LoginState = copy(email = email)
    fun withPassword(password: String): LoginState = copy(password = password)
    fun fromEntity(entity: LoginEntity): LoginState =
        copy(
            email = entity.email,
            password = entity.password,
            saveLogin = entity.saveLogin,
            loginEnabled = entity.isValid(),
        )
    fun toEntity(): LoginEntity = LoginEntity(email, password, saveLogin)
}
