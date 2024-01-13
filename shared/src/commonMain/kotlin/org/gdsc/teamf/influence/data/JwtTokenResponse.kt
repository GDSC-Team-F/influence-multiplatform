package org.gdsc.teamf.influence.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JwtTokenResponse(
    @SerialName("accessToken") val accessToken: String,
    @SerialName("refreshToken") val refreshToken: String,
    @SerialName("userIdx") val userIdx: Long,
    @SerialName("nickname") val nickname: String,
    @SerialName("email") val email: String,
    @SerialName("conditions") val conditions: List<Int>,
)

/*

    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6NSwiaWF0Ijox123456wMDM5LCJleHAiOjE3MDAyNzIwMzl9.0mjwFO6JtabcdefgrPgGm-2XWY60G2YH6HbTwU386Po",
    "conditions": [
      0
    ],
    "email": "example@gmail.com",
    "nickname": "닉네임",
    "refreshToken": "eyABCDciOiJIUzI1NiJ9.abcdefg6NSwiaWF0IjoxNjk3NjgwMDM5LCJleHAiOjE3Mxyz987wMzl9.0mjwFO6Jtqz616yprPgGm-2XWY60G2YH6HbTwU123q0",
    "userIdx": 1
* */