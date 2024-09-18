package com.josnelihurt.home.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class LoginViewModel : ViewModel() {

    private val _email = MutableLiveData<String>();
    val email : LiveData<String> = _email;

    private val _password = MutableLiveData<String>();
    val password : LiveData<String> = _password;

    private val _logginEnabled = MutableLiveData<Boolean>();
    val logginEnabled: LiveData<Boolean> = _logginEnabled;

    private val _isLogging = MutableLiveData<Boolean>();
    val isLogging: LiveData<Boolean> = _isLogging;

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _logginEnabled.value = isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean  = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String): Boolean = password.length > 6


    suspend fun login() {
        _logginEnabled.value = false
        _isLogging.value = true
        //TODO: change this by the login logic
        delay(timeMillis = 2000)
        _logginEnabled.value = true
        _isLogging.value = false
    }
}