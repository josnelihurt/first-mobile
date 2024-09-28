package com.josnelihurt.home.login.data.api

import android.net.Uri
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.josnelihurt.home.login.domain.entities.OAuthConfiguration
import com.josnelihurt.home.login.domain.entities.SettingsEntity
import com.josnelihurt.mobile_api_stub.gen.BootResponse
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.http.GET
import okhttp3.MediaType.Companion.toMediaType
import kotlinx.serialization.json.Json



interface ApiService {
    @GET("boot")
    suspend fun boot(): BootResponse
}


fun BootResponse.toDomainModel(): SettingsEntity {
    return SettingsEntity(
        oAuthConfiguration = OAuthConfiguration(
            clientID = services.clientId,
            authorizationEndpoint = Uri.parse(services.authorizationServiceUrl),
            tokenEndpoint = Uri.parse(services.tokenServiceUrl),
        )
    )
}

class MobileAPI (
    private val baseUrl: Uri
) {
    private val contentType = "application/json".toMediaType()
    private val json = Json { ignoreUnknownKeys = true }

    //Desafortunadamente no se puede usar el plugin de serialization para retrofit,
    //porque los archivos generados no son compatibles con el plugin de serialization
    //por lo que se debe hacer la conversión manualmente, los archivos generados son para gRPC y no para HTTP
    private val _retrofit = Retrofit.Builder()
        .baseUrl(baseUrl.toString()+"/v1/")
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()

    val apiService = _retrofit.create(ApiService::class.java)
    fun boot(): SettingsEntity {
        val bootResponse = runBlocking {
            try {
                apiService.boot()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
        return bootResponse?.toDomainModel() ?: throw IllegalStateException("Boot response is null")
    }
}