package com.josnelihurt.home.login.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josnelihurt.home.login.domain.entities.SettingsEntity
import com.josnelihurt.home.login.domain.interactors.AuthInteractor
import com.josnelihurt.home.login.domain.interactors.SettingInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor,
    private val settingsService: SettingInteractor,
) : ViewModel() {
    private val _loginState =
        MutableLiveData(LoginState().fromEntity(authInteractor.restoreLogin()))
    val loginState: LiveData<LoginState> = _loginState
    val server: String = settingsService.load().server

    fun onLoginChanged(email: String, password: String) {
        var curentState = getCurrentState().withEmail(email).withPassword(password)
        val entity = curentState.toEntity()
        updateState(curentState.withEnableLogin(entity.isValid()))
    }

    fun onSaveLogin(saveLogin: Boolean) = updateState(getCurrentState().withSaveLogin(saveLogin))

    fun onServerChanged(newValue: String) =
        settingsService.save(SettingsEntity().withServer(newValue))

    fun login() {
        val currentState = getCurrentState()
        if (!currentState.loginEnabled) return
        updateState(currentState.startLogin())

        viewModelScope.launch {
            authInteractor.login(currentState.toEntity())
            updateState(currentState.endLogin())
        }
    }

    private fun getCurrentState(): LoginState = _loginState.value ?: LoginState()
    private fun updateState(newState: LoginState) = _loginState.postValue(newState.copy())
}
