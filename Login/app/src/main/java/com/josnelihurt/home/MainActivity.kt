package com.josnelihurt.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.josnelihurt.home.login.presentation.view.loginScreen
import com.josnelihurt.home.login.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity class that hosts the login screen
 */
@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    private val _loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { loginScreen(viewModel = _loginViewModel) }
    }
}

