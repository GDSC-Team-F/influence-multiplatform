package org.gdsc.teamf.influence.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Friend(
    @SerialName("id") val id : Long,
    @SerialName("name") val name : String,
    @SerialName("characterId") val characterId : Int,
    @SerialName("progress") val progress : Float,
) {

    // 1 ~ 7
    private val level get() = when ((progress * 100).toInt()) {
        in 0 until 5 -> 1
        in 5 until 10 -> 2
        in 10 until 30 -> 3
        in 30 until 50 -> 4
        in 50 until 70 -> 5
        in 70 until 90 -> 6
        else -> 7
    }

    val characterImageRes : String get() = "plant_${characterId + 1}_${level}"

    companion object {
        // sample data
        val mock = listOf(
            Friend(
                id = 0,
                name = "김영훈",
                characterId = 0,
                progress = 0.2f,
            ),
            Friend(
                id = 1,
                name = "김영훈",
                characterId = 2,
                progress = 0.5f,
            ),
            Friend(
                id = 2,
                name = "김영훈",
                characterId = 3,
                progress = 0.8f,
            ),
            Friend(
                id = 3,
                name = "김영훈",
                characterId = 1,
                progress = 0.9f,
            ),
            Friend(
                id = 4,
                name = "김영훈",
                characterId = 1,
                progress = 0.6f,
            ),
            Friend(
                id = 5,
                name = "김영훈",
                characterId = 1,
                progress = 0.9f,
            ),
        )
    }
}