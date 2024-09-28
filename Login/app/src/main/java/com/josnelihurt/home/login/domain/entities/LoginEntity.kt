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
    /**
     * Copies the login data to be saved.
     * @return The login entity with the password removed if the login data is not to be saved.
     */
    fun copyToSave(): LoginEntity =
        this.copy(password = "").apply { if (!this.saveLogin) this.email = "" }
    /**
     * Validates the email. Uses the [Patterns.EMAIL_ADDRESS] pattern.
     */
    private fun isValidEmail(email: String): Boolean =
        email.isNotEmpty()
        //Patterns.EMAIL_ADDRESS.matcher(email).matches()
    /**
     * Validates the password.
     * @return True if the password is valid, false otherwise.
     */
    private fun isValidPassword(password: String): Boolean = password.length > MIN_PASSWORD_LENGTH
}
