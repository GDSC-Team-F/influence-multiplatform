package org.gdsc.teamf.influence.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class RegionVaccineAchieve(
    @SerialName("region") val region: LivingState,
    @SerialName("progress") val progress: Float,
) {
    companion object {
        val mock = LivingState.entries.map {
            RegionVaccineAchieve(
                region = it,
                progress = Random.nextInt(0, 100).toFloat() / 100f
            )
        }.sortedByDescending {
            it.progress
        }
    }
}