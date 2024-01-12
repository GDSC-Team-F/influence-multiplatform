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
import org.gdsc.teamf.influence.data.Friend
import org.gdsc.teamf.influence.data.JwtTokenResponse
import org.gdsc.teamf.influence.data.entity.Condition
import org.gdsc.teamf.influence.data.entity.LivingState
import org.gdsc.teamf.influence.data.entity.Me
import org.gdsc.teamf.influence.data.entity.Point
import org.gdsc.teamf.influence.data.entity.Vaccine
import org.koin.core.annotation.Single

@Single
class MeApi(
    private val httpClient: HttpClient,
) {

    suspend fun me() = httpClient.get("/api/me").body<Me>()

}

@Single
class FriendApi(
    private val httpClient: HttpClient,
) {

    suspend fun friends() = httpClient.get("/api/friends").body<List<Friend>>()

    suspend fun invite(email: String) = httpClient.post("/api/friends/invite") {
        contentType(ContentType.Application.Json)
        setBody(mapOf("email" to email))
    }

}

@Single
class VaccineApi(
    private val httpClient: HttpClient,
) {
    suspend fun vaccine() = httpClient.get("/api/vaccine").body<List<Vaccine>>()

    suspend fun vaccinated(vaccineId: Long) = httpClient.post("/api/vaccine/vaccinated") {
        contentType(ContentType.Application.Json)
        setBody(mapOf("vaccine_id" to vaccineId))
    }

    suspend fun ranking(vaccineId: Long) = httpClient.get("/api/region_ranking/${vaccineId}").body<Float>()

}

@Single
class PointApi(
    private val httpClient: HttpClient,
) {


    suspend fun point(vaccineId: Long, friendsId: Long) = httpClient.post("/api/point") {
        contentType(ContentType.Application.Json)
        setBody(mapOf("vaccine_id" to vaccineId, "friends_id" to friendsId))
    }

    suspend fun point() = httpClient.get("/api/point").body<Point>()

    suspend fun point(id: Long) = httpClient.delete("/api/point") {
        contentType(ContentType.Application.Json)
        setBody(mapOf("id" to id))
    }



}

@Single
class AuthApi(
    private val httpClient: HttpClient,
) {

    suspend fun login(email: String, password: String) = httpClient.post("/api/login") {
        contentType(ContentType.Application.Json)
        setBody(mapOf("email" to email, "password" to password))
    }.body<JwtTokenResponse>()

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
            mapOf(
                "email" to email,
                "password" to password,
                "name" to name,
                "conditions" to conditions,
                "livingState" to livingState,
                "gender" to gender,
                "age" to age,
                "characterId" to characterId,
            )
        )
    }.bodyAsText()

}