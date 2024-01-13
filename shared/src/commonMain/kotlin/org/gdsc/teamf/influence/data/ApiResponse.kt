package org.gdsc.teamf.influence.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    @SerialName("status") val status: Int = -1,
    @SerialName("data") val data: T? = null,
    @SerialName("message") val message: String? = null,
    @SerialName("code") val code: String
) {

    fun requireData(): T = data ?: throw ApiResponseException(message ?: "Unknown error")


}

class ApiResponseException(val error: String) : Exception(error)