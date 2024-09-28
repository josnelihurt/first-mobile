package com.josnelihurt.home.login.presentation.view

import android.content.res.Configuration
import android.widget.Toast
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.josnelihurt.home.R
import com.josnelihurt.home.login.presentation.viewmodel.LoginState
import com.josnelihurt.home.login.presentation.viewmodel.LoginUISate
import com.josnelihurt.home.login.presentation.viewmodel.LoginViewModel
import kotlinx.coroutines.delay

const val LANDSCAPE_LOGO_SIZE = 0.3f
const val PORTRAIT_LOGO_SIZE = 0.8f
const val BTN_COLOR = 0xFF6200EE
const val LAUNCH_EFFECT_DELAY = 500L

@Composable
fun loginScreen(
    viewModel: LoginViewModel
) {
    when (val state = viewModel.uiState.collectAsState(LoginUISate.Idle(LoginState())).value) {
        is LoginUISate.Loading -> showLoading()
        LoginUISate.Animating -> viewModel.hideAnimating()//TODO: add animation
        is LoginUISate.LoggedIn -> navigateToLogged()
        is LoginUISate.Settings -> settingsDialog(viewModel)
        is LoginUISate.Error -> showError(state.message, viewModel::hideError)
        is LoginUISate.Idle -> idleScreen(viewModel)
    }
}

@Composable
private fun idleScreen(viewModel: LoginViewModel) {
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
            onSettings = { viewModel.showSettings() }
        ),
    )
}

@Composable
private fun showError(message: String, hideError: () -> Unit) {
    val toast = Toast.makeText(
        LocalContext.current,
        message,
        Toast.LENGTH_SHORT
    )
    toast.addCallback(object : Toast.Callback() {
        override fun onToastHidden() {
            hideError()
        }
    })
    toast.show()
}

@Composable
private fun settingsDialog(viewModel: LoginViewModel) {
    serverDialog(
        initialValue = viewModel.server,
        onDismiss = { viewModel.hideSettings() },
        onSave = { newValue ->
            viewModel.onServerChanged(newValue)
        }
    )
}

@Composable
private fun navigateToLogged() {
    //TODO: navigate to logged screen
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
    val state = viewModel.loginState
    val configuration = LocalConfiguration.current
    val screenHeightFraction = getLogoFraction(configuration.orientation)
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
        userField(value = state.email, onChange = { viewModel.onLoginChanged(it, state.password) })
        Spacer(modifier = Modifier.padding(4.dp))
        passwordField(
            value = state.password,
            onChange = { viewModel.onLoginChanged(state.email, it) })
        Spacer(modifier = Modifier.padding(4.dp))
        saveLogin(checked = state.saveLogin, onCheckedChange = { viewModel.onSaveLogin(it) })
        Spacer(modifier = Modifier.padding(16.dp))
        loginButton(enabled = state.loginEnabled, onLogging = { viewModel.login() })
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
fun userField(value: String, onChange: (String) -> Unit) {
    loginTextField("User", KeyboardType.Text, value, onChange)
}

@Composable
fun passwordField(value: String, onChange: (String) -> Unit) {
    loginTextField("Password", KeyboardType.Password, value, onChange)
}
