package com.josnelihurt.home.login.domain.entities

import android.net.Uri

data class ServerConfiguration(
    var server: Uri = Uri.EMPTY,
) {
    fun withServer(server: Uri): ServerConfiguration = copy(server = server)
}

data class OAuthConfiguration(
    val clientID: String = "",
    var authorizationEndpoint: Uri = Uri.EMPTY,
    var tokenEndpoint: Uri = Uri.EMPTY,
    val redirectUri: Uri = Uri.EMPTY,
)
/**
 * Entity to manage the settings of the application implementation 'com.google.code.gson:gson:2.8.8'
 */
data class SettingsEntity(
    var serverConfiguration: ServerConfiguration = ServerConfiguration(),
    var oAuthConfiguration: OAuthConfiguration = OAuthConfiguration(),
) {
    fun withServer(server: String): Result<SettingsEntity> = getUri(server).map {
        copy(serverConfiguration = serverConfiguration.withServer(it))
    }
    val server: String
        get() = serverConfiguration.server.toString()

    private fun getUri(value : String): Result<Uri> {
        if (value.isEmpty()) {
            //TODO: I don´t like this, I should use a custom exception
            return Result.failure(IllegalArgumentException("Uri cannot be empty"))
        }
        return kotlin.runCatching {
            Uri.parse(value)
        }
    }
}
