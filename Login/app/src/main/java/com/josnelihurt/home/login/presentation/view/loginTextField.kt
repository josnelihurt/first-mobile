package com.josnelihurt.home.login.presentation.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.josnelihurt.home.R

@Composable
fun loginTextField(
    name: String,
    keyboardType: KeyboardType,
    value: String,
    onChange: (String) -> Unit
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val visualTransofrmationFunc: () -> VisualTransformation = {
        var result = VisualTransformation.None
        if (keyboardType == KeyboardType.Password && !passwordVisible)
            result = PasswordVisualTransformation()
        result
    }
    TextField(
        value = value,
        onValueChange = onChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(name) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
        ),
        visualTransformation = visualTransofrmationFunc(),
        trailingIcon = {
            if (keyboardType == KeyboardType.Password) {
                val res = if (passwordVisible) R.drawable.visibility_off else R.drawable.visibility
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = res),
                        contentDescription = "Toggle password visibility"
                    )
                }
            }
        },
    )
}

