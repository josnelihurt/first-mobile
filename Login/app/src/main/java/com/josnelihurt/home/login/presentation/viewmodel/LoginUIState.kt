package com.josnelihurt.home.login.presentation.viewmodel

sealed class LoginUISate {
    data object Loading : LoginUISate()
    data object Animating : LoginUISate()
    data object LoggedIn : LoginUISate()
    data object Settings : LoginUISate()
    data class Error(val message: String) : LoginUISate()
    data class Idle(val state: LoginState) : LoginUISate()
}