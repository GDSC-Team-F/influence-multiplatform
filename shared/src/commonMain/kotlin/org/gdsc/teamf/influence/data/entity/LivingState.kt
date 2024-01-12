package org.gdsc.teamf.influence.data.entity

enum class LivingState(val value: Int) {
    서울특별시(0),
    부산광역시(1),
    경상남도(2),
    경상북도(3),
    인천광역시(4),
    광주광역시(5),
    전라남도(6),
    대전광역시(7),
    충청남도(8),
    울산광역시(9),
    대구광역시(10),
    전라북도(11),
    충청북도(12),
    강원도(13),
    제주특별자치도(14),
    세종특별자치시(15),
}

val LivingState.stateReadable
    get() = when (this) {
        LivingState.서울특별시 -> "서울특별시"
        LivingState.부산광역시 -> "부산광역시"
        LivingState.경상남도 -> "경상남도"
        LivingState.경상북도 -> "경상북도"
        LivingState.인천광역시 -> "인천광역시"
        LivingState.광주광역시 -> "광주광역시"
        LivingState.전라남도 -> "전라남도"
        LivingState.대전광역시 -> "대전광역시"
        LivingState.충청남도 -> "충청남도"
        LivingState.울산광역시 -> "울산광역시"
        LivingState.대구광역시 -> "대구광역시"
        LivingState.전라북도 -> "전라북도"
        LivingState.충청북도 -> "충청북도"
        LivingState.강원도 -> "강원도"
        LivingState.제주특별자치도 -> "제주특별자치도"
        LivingState.세종특별자치시 -> "세종특별자치시"
    }