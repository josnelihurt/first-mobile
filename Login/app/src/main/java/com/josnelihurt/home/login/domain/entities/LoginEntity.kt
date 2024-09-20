package com.josnelihurt.home.login.domain.entities

import android.util.Patterns

const val MIN_PASSWORD_LENGTH = 6

/**
 * Entity class that represents the login data
 */
data class LoginEntity(
    var email: String = "",
    var password: String = "",
    var saveLogin: Boolean = false,
) {
    /**
     * Validates the login data.
     * @return True if the login data is valid, false otherwise.
     */
    fun isValid(): Boolean = isValidEmail(email) && isValidPassword(password)
    fun copyToSave(): LoginEntity =
        this.copy(password = "").apply { if (!this.saveLogin) this.email = "" }


    private fun isValidEmail(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isValidPassword(password: String): Boolean = password.length > MIN_PASSWORD_LENGTH

}
