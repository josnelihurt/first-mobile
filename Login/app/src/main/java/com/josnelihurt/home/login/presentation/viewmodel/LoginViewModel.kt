package com.josnelihurt.home.login.presentation.viewmodel

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josnelihurt.home.login.domain.entities.SettingsEntity
import com.josnelihurt.home.login.domain.interactors.AuthInteractor
import com.josnelihurt.home.login.domain.interactors.SettingInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationResponse
import net.openid.appauth.AuthorizationService
import net.openid.appauth.AuthorizationServiceConfiguration
import net.openid.appauth.ResponseTypeValues
import javax.inject.Inject

fun interface AuthCallback {
    fun onLogin(intent: Intent)
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor,
    private val settingsInteractor: SettingInteractor,
    @ApplicationContext private val context: Context,
) : ViewModel() {
    private var onAuthCallback: AuthCallback? = null
    private fun onLogin(intent: Intent) = onAuthCallback?.onLogin(intent)
    fun setOnLogin(callback: AuthCallback) {
        onAuthCallback = callback
    }

    private val _uiState = MutableStateFlow<LoginUISate>(LoginUISate.Loading)
    val uiState = _uiState.onStart { load() }
    private var _loginState = LoginState()
    val loginState: LoginState get() = _loginState

    private var _serverSettings: SettingsEntity = SettingsEntity()
    val server: String get() = _serverSettings.server
    fun onLoginChanged(email: String, password: String) {
        var currentState = _loginState.withEmail(email).withPassword(password)
        val entity = currentState.toEntity()
        showIdle(currentState.withEnableLogin(entity.isValid()))

    }

    fun onSaveLogin(saveLogin: Boolean) = showIdle(_loginState.withSaveLogin(saveLogin))

    fun onServerChanged(newValue: String) {
        SettingsEntity().withServer(newValue).onSuccess {
            settingsInteractor.save(it)
        }.onFailure {
            showError("Invalid server")
        }
        showIdle()
    }

    private fun load() {
        val loginEntity = authInteractor.restoreLogin()
        val settingsEntity = settingsInteractor.load()
        _serverSettings = settingsEntity
        showIdle(LoginState().fromEntity(loginEntity))
    }

    private fun getAuthorizationRequestIntent(): Intent {
        val oAuthConfiguration = _serverSettings.oAuthConfiguration

        val authRequest = AuthorizationRequest.Builder(
            AuthorizationServiceConfiguration(
                oAuthConfiguration.authorizationEndpoint,
                oAuthConfiguration.tokenEndpoint
            ),
            oAuthConfiguration.clientID,
            ResponseTypeValues.CODE,
            oAuthConfiguration.redirectUri
        ).build()

        val authService = AuthorizationService(context)
        return authService.getAuthorizationRequestIntent(authRequest)
    }

    fun login() {
        if (!_loginState.loginEnabled) return
        showError("Login not enabled")

        viewModelScope.launch {
            authInteractor.login(_loginState.toEntity())
            val oauthIntent = getAuthorizationRequestIntent()
            onLogin(oauthIntent)
            hideLogin()
        }
    }

    fun handleAuthResult(data: Intent?) {
        val errorCase = { showError("Authorization failed try again") }
        if (data == null || data.data == null) {
            errorCase()
            return
        }

        val response = AuthorizationResponse.fromIntent(data)
        if (response == null) {
            errorCase()
            return
        }
        handleAuthorizationResponse(response)
    }

    fun handleAuthorizationResponse(response: AuthorizationResponse) {
        val accessToken = response.accessToken
        val idToken = response.idToken
        val tokenType = response.tokenType
        val expiresAt = response.accessTokenExpirationTime
        val authorizationCode = response.authorizationCode

        // Guarda estos valores en tu almacenamiento seguro o en tu ViewModel
        Log.d("AuthorizationResponse", "Access Token: $accessToken")
        Log.d("AuthorizationResponse", "ID Token: $idToken")
        Log.d("AuthorizationResponse", "Token Type: $tokenType")
        Log.d("AuthorizationResponse", "Expires At: $expiresAt")
        Log.d("AuthorizationResponse", "Authorization Code: $authorizationCode")

    }

    fun showSettings() = setState(LoginUISate.Settings)
    fun hideSettings() = showIdle()
    fun showLogin() = setState(LoginUISate.Loading)
    fun hideLogin() = showIdle()
    fun showError(message: String) = setState(LoginUISate.Error(message))
    fun hideError() = showIdle()
    fun hideAnimating() = showIdle()
    fun showIdle() = setState(LoginUISate.Idle(_loginState))
    fun showIdle(state: LoginState) {
        _loginState = state
        setState(LoginUISate.Idle(state))
    }

    private fun setState(newState: LoginUISate) {
        _uiState.value = newState
    }
}
