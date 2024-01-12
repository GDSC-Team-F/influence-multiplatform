package org.gdsc.teamf.influence.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JwtTokenResponse (
    @SerialName("access") val accessToken: String,
    @SerialName("refresh") val refreshToken: String,
)