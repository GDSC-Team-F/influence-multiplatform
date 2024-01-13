package org.gdsc.teamf.influence.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
서울특별시
부산광역시
3,300,836명
경상남도
770.1㎢
1963년 1월 1일[1]
대구광역시
2,377,801명
경상북도
1499.51㎢[2]
1981년 7월 1일[3]
인천광역시
2,987,918명
경기도
1065.2㎢[4]
광주광역시
1,422,999명
전라남도
501.1㎢
1986년 11월 1일[5]
대전광역시
1,444,595명
충청남도
539.7㎢
1989년 1월 1일[6]
울산광역시
1,104,167명
경상남도
1062.1㎢
1997년 7월 15일[7]
* */

@Serializable
data class Me(
    @SerialName("userIdx") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("email") val email: String,
    @SerialName("image") val characterId: Long,
    @SerialName("gender") val gender: String,
    @SerialName("age") val age: Int,
    @SerialName("address") val state: Int,
    @SerialName("conditions") val conditions: List<Int>,
    @SerialName("myPercent") val progress : Float,

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

    val stateModel: LivingState get() = LivingState.entries[state]

    val conditionsAsStrings get() = conditions.map { Condition.entries[it].asReadable }

    companion object {
        val mock = Me(
            id = 0,
            name = "김영훈",
            email = "example@gmail.com",
            gender = "MALE",
            characterId = 0,
            age = 23,
            state = 0,
            conditions = listOf(0, 2, 5),
            progress = 0.1f,
        )
    }

}