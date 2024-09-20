package com.josnelihurt.home.login.domain.entities

data class SettingsEntity (
    var server: String = "",
){
    fun withServer(server: String): SettingsEntity = apply { this.server = server }
}
