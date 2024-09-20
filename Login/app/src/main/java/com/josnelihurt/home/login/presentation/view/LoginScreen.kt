package com.josnelihurt.home.login.presentation.view

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.josnelihurt.home.R
import com.josnelihurt.home.login.presentation.viewmodel.LoginState
import com.josnelihurt.home.login.presentation.viewmodel.LoginViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val LANDSCAPE_LOGO_SIZE = 0.3f
const val PORTRAIT_LOGO_SIZE = 0.8f

@Composable
fun loginScreen(
    viewModel: LoginViewModel
) {
    var showServerDialog by remember { mutableStateOf(false) }
    if (showServerDialog) {
        serverDialog(
            initialValue = viewModel.server,
            onDismiss = { showServerDialog = false },
            onSave = { newValue ->
                viewModel.onServerChanged(newValue)
                showServerDialog = false
            }
        )
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        content = { padding ->
            login(
                modifier = Modifier
                    .padding(padding)
                    .padding(4.dp), viewModel = viewModel
            )
        },
        topBar = topBar(
            onSettings = { showServerDialog = true }
        ),
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun topBar(onSettings: () -> Unit) = @Composable {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(
                text = "Josnelihurt App",
                fontWeight = FontWeight.Bold,
            )
        },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.service),
                    contentDescription = "More options"
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        expanded = false
                        onSettings()
                    }
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun getLogoFraction(orientation: Int): Float {
    var screenHeightFraction = PORTRAIT_LOGO_SIZE
    if (orientation == Configuration.ORIENTATION_LANDSCAPE)
        screenHeightFraction = LANDSCAPE_LOGO_SIZE
    return screenHeightFraction
}
@Composable
fun login(modifier: Modifier, viewModel: LoginViewModel) {
    val state: LoginState by viewModel.loginState.observeAsState(initial = LoginState())
    val email = state.email
    val password = state.password
    val loggingEnabled = state.loginEnabled
    val saveLogin = state.saveLogin
    val coroutineScope = rememberCoroutineScope()
    val isLogging = state.isLogging
    val configuration = LocalConfiguration.current
    val screenHeightFraction = getLogoFraction(configuration.orientation)
    if (isLogging) {
        showLoading()
        return
    }
    var onLogging: () -> Unit = {
        coroutineScope.launch { viewModel.login() }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        logo(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxSize(fraction = screenHeightFraction)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        emailField(value = email, onChange = { viewModel.onLoginChanged(it, password) })
        Spacer(modifier = Modifier.padding(4.dp))
        passwordField(value = password, onChange = { viewModel.onLoginChanged(email, it) })
        Spacer(modifier = Modifier.padding(4.dp))
        saveLogin(checked = saveLogin, onCheckedChange = { viewModel.onSaveLogin(it) })
        Spacer(modifier = Modifier.padding(16.dp))
        loginButton(enabled = loggingEnabled, onLogging = onLogging)
    }
}

@Composable
fun saveLogin(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.fillMaxWidth()
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(text = "Remember Email")
    }
}

@Composable
fun showLoading() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}
const val LAUNCH_EFFECT_DELAY = 500L
@Composable
fun logo(modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (expanded) 1f else 0f)

    LaunchedEffect(Unit) {
        delay(LAUNCH_EFFECT_DELAY) // Delay to start the animation
        expanded = true
    }
    Image(
        painter = painterResource(id = R.drawable.me2),
        contentDescription = "it is me",
        modifier = modifier
            .clip(CircleShape)
            .scale(scale)
    )
}

const val BTN_COLOR = 0xFF6200EE

@Composable
fun loginButton(enabled: Boolean, onLogging: () -> Unit) {
    val btnColor = Color(BTN_COLOR)
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
fun emailField(value: String, onChange: (String) -> Unit) {
    loginTextField("Email", KeyboardType.Email, value, onChange)
}

@Composable
fun passwordField(value: String, onChange: (String) -> Unit) {
    loginTextField("Password", KeyboardType.Password, value, onChange)
}
