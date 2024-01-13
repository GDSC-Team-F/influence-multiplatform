package org.gdsc.teamf.influence.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.gdsc.teamf.influence.data.ApiHelper
import org.gdsc.teamf.influence.data.ApiResponse
import org.gdsc.teamf.influence.data.Friend
import org.gdsc.teamf.influence.data.JwtTokenResponse
import org.gdsc.teamf.influence.data.entity.Condition
import org.gdsc.teamf.influence.data.entity.LivingState
import org.gdsc.teamf.influence.data.entity.Me
import org.gdsc.teamf.influence.data.entity.Point
import org.gdsc.teamf.influence.data.entity.Vaccine
import org.koin.core.annotation.Single

expect fun getApiHttpClient(apiHelper: ApiHelper): HttpClient

@Single
class MeApi(
    private val apiHelper: ApiHelper
) {
    private val httpClient: HttpClient get() = getApiHttpClient(apiHelper)

    suspend fun me() = httpClient.get("/api/me").body<ApiResponse<Me>>().data!!

}

@Single
class FriendApi(
    private val apiHelper: ApiHelper
) {
    private val httpClient: HttpClient get() = getApiHttpClient(apiHelper)

    suspend fun friends() = httpClient.get("/api/friends/").body<ApiResponse<List<Friend>>>().data.orEmpty()

    suspend fun invite(email: String) = httpClient.post("/api/friends/invite") {
        contentType(ContentType.Application.Json)
        setBody(EmailRequest(email))
    }.bodyAsText()

    @Serializable
    data class EmailRequest(
        @SerialName("email") val email: String,
    )

}

@Single
class VaccineApi(
    private val apiHelper: ApiHelper
) {

    private val httpClient: HttpClient get() = getApiHttpClient(apiHelper)
    suspend fun vaccine() = httpClient.get("/api/injection").body<ApiResponse<List<Vaccine>>>().data!!

    suspend fun vaccinated(vaccineId: Long) = httpClient.post("/api/injection") {
        contentType(ContentType.Application.Json)
        setBody(VaccinateRequest(vaccineId))
    }

    @Serializable
    data class VaccinateRequest(
        @SerialName("vaccineId") val vaccineId: Long,
    )

    suspend fun ranking(vaccineId: Long) = httpClient.get("/api/region_ranking/${vaccineId}").body<Float>()

}

@Single
class PointApi(
    private val apiHelper: ApiHelper
) {

    private val httpClient: HttpClient get() = getApiHttpClient(apiHelper)

    suspend fun point(vaccineId: Long, friendsId: Long) = httpClient.post("/api/point") {
        contentType(ContentType.Application.Json)
        setBody(mapOf("vaccineId" to vaccineId, "friendsId" to friendsId))
    }.bodyAsText()

    suspend fun get() = httpClient.get("/api/point").body<ApiResponse<List<Point>>>().data!!

    suspend fun delete(id: Long) = httpClient.delete("/api/point") {
        contentType(ContentType.Application.Json)
        setBody(DeleteRequest(id))
    }

    @Serializable
    data class DeleteRequest(
        @SerialName("id") val id: Long,
    )


}

@Single
class AuthApi(
    private val apiHelper: ApiHelper
) {

    private val httpClient: HttpClient get() = getApiHttpClient(apiHelper)

    suspend fun login(email: String, password: String) = httpClient.post("/api/login") {
        contentType(ContentType.Application.Json)
        setBody(LoginRequest(email, password))
    }.body<ApiResponse<JwtTokenResponse>>().data

    @Serializable
    data class LoginRequest(
        @SerialName("email") val email: String,
        @SerialName("password") val password: String,
    )

    suspend fun register(
        email: String,
        password: String,
        name: String,
        conditions: List<Condition>,
        livingState: LivingState,
        gender: Int,
        age: Int,
        characterId: Int,
    ) = httpClient.post("/api/register") {
        contentType(ContentType.Application.Json)
        setBody(
            RegisterRequest(
                email,
                password,
                name,
                conditions.map { it.ordinal },
                livingState.ordinal,
                gender,
                age,
                characterId,
            )
        )
    }.bodyAsText()

    @Serializable
    data class RegisterRequest(
        @SerialName("email") val email: String,
        @SerialName("password") val password: String,
        @SerialName("name") val name: String,
        @SerialName("conditions") val conditions: List<Int>,
        @SerialName("address") val livingState: Int,
        @SerialName("gender") val gender: Int,
        @SerialName("age") val age: Int,
        @SerialName("image") val characterId: Int,
    )

}