// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json = Json { allowStructuredMapKeys = true }
// val test = json.parse(Test.serializer(), jsonString)

package quicktype

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class Test (
    val services: ServicesSettings? = null
)

@Serializable
data class ServicesSettings (
    @SerialName("authorization_service_url")
    val authorizationServiceURL: String? = null,

    @SerialName("client_id")
    val clientID: String? = null,

    @SerialName("token_service_url")
    val tokenServiceURL: String? = null
)
