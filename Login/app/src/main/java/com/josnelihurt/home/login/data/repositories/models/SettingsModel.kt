package com.josnelihurt.home.login.data.repositories.models

import android.net.Uri
import com.josnelihurt.home.login.domain.entities.OAuthConfiguration
import com.josnelihurt.home.login.domain.entities.ServerConfiguration
import com.josnelihurt.home.login.domain.entities.SettingsEntity
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


@Serializable
data class SettingsModel(
    val server: String = "",
    val clientID: String = "",
    val authorizationEndpoint: String = "",
    val tokenEndpoint: String = "",
    val redirectUri: String = "",
) {
    companion object {
        fun fromJson(json: String): SettingsModel {
            return Json.decodeFromString(serializer(), json)
        }
        fun fromEntity(entity: SettingsEntity): SettingsModel {
            return SettingsModel(
                server = entity.serverConfiguration.server.toString(),
                clientID = entity.oAuthConfiguration.clientID,
                authorizationEndpoint = entity.oAuthConfiguration.authorizationEndpoint.toString(),
                tokenEndpoint = entity.oAuthConfiguration.tokenEndpoint.toString(),
                redirectUri = entity.oAuthConfiguration.redirectUri.toString(),
            )
        }
    }

    fun toJson(settingsModel: SettingsModel): String {
        return Json.encodeToString(serializer(), settingsModel)
    }
    fun toEntity(): SettingsEntity {
        return SettingsEntity(
            serverConfiguration = ServerConfiguration().withServer(Uri.parse(server)),
            oAuthConfiguration = OAuthConfiguration(
                clientID = clientID,
                authorizationEndpoint = Uri.parse(authorizationEndpoint),
                tokenEndpoint = Uri.parse(tokenEndpoint),
                redirectUri = Uri.parse(redirectUri),
            )
        )
    }
}
