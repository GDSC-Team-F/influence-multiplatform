package org.gdsc.teamf.influence.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*

- index (Long)
- 누가 찔렀는지 (friendsId : Long)
- 어떤 백신인지 (vaccineId : Long)
* */
@Serializable
data class Point(
    @SerialName("pointId") val id : Long,
    @SerialName("friendsId") val friendsId : Long,
    @SerialName("vaccineId") val vaccineId : Long,
) {
    companion object {
        val mock = Point(
            id = 1,
            friendsId = 1,
            vaccineId = 1,
        )
    }
}