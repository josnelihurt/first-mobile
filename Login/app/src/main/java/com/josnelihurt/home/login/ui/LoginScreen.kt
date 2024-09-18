package com.josnelihurt.home.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josnelihurt.home.R
import kotlinx.coroutines.launch


@Composable
fun ViewContainer() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            val padding = padding
        },
    )
}

@Composable
@Preview
fun LoginScreen(viewModel: LoginViewModel = LoginViewModel()) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        content = { padding ->
            val padding = padding
            Login(modifier = Modifier, viewModel = viewModel)
        },
    )
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loggingEnabled: Boolean by viewModel.logginEnabled.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()
    val isLogging: Boolean by viewModel.isLogging.observeAsState(initial = false)
    if (isLogging) {
        ShowLoading()
        return
    }
    var onLogging: () -> Unit = {
        coroutineScope.launch { viewModel.login() }
    }
    Column(modifier = modifier) {
        Logo(modifier = modifier)
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField(value = email, onChange = { viewModel.onLoginChanged(it, password) })
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(value = password, onChange = { viewModel.onLoginChanged(email, it) })
        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton(modifier = modifier, enabled = loggingEnabled, onLogging = onLogging)
    }
}

@Composable
fun ShowLoading() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun Logo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.me2),
        contentDescription = "it is me",
        modifier = modifier
    )
}

@Composable
fun LoginButton(modifier: Modifier, enabled: Boolean, onLogging: () -> Unit) {
    val btnColor = Color(0xFF6200EE)
    Button(
        onClick = onLogging,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = btnColor,
            contentColor = Color.White,
            disabledContainerColor = btnColor.copy(alpha = 0.5f),
            disabledContentColor = Color.White.copy(alpha = 0.5f),
        ),
        enabled = enabled,
    ) {
        Text("Login !", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun LoginTextField(
    name: String,
    keyboardType: KeyboardType,
    value: String,
    onChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(name) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
        )
    )
}

@Composable
fun EmailField(value: String, onChange: (String) -> Unit) {
    LoginTextField("Email", KeyboardType.Email, value, onChange)
}

@Composable
fun PasswordField(value: String, onChange: (String) -> Unit) {
    LoginTextField("Password", KeyboardType.Password, value, onChange)
}