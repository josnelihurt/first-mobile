package com.josnelihurt.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.josnelihurt.home.login.presentation.view.loginScreen
import com.josnelihurt.home.login.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main activity class that hosts the login screen
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val _loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { loginScreen(viewModel = _loginViewModel) }
        _loginViewModel.setOnLogin(::startLogin)
    }

    private val _authResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            _loginViewModel.handleAuthResult(result.data)
        }

    private fun startLogin(authIntent: Intent) {
        _authResultLauncher.launch(authIntent)
    }
}

