package org.gdsc.teamf.influence.data.entity

enum class Condition(val value : Int) {
    당뇨병(0),
    만성심혈관질환(1),
    만성폐질환(2),
    만성간질환(3),
    항암치료중인고형암(4),
    이식외의면역어제제사용(5),
    장기이식(6),
    조혈모세포이식(7),
    무비증(8),
    HIV감염_CD4림프구200이하(9),
    HIV감염_CD4림프구200이상(10),
    임산부(11),
    의료기관종사자(12)
}

val Condition.asReadable get() = when(this) {
    Condition.당뇨병 -> "당뇨병"
    Condition.만성심혈관질환 -> "만성 심혈관 질환"
    Condition.만성폐질환 -> "만성 폐 질환"
    Condition.만성간질환 -> "만성 간 질환"
    Condition.항암치료중인고형암 -> "항암 치료 중인 고형암"
    Condition.이식외의면역어제제사용 -> "이식 외의 면역 억제제 사용"
    Condition.장기이식 -> "장기 이식"
    Condition.조혈모세포이식 -> "조혈모 세포 이식"
    Condition.무비증 -> "무비증"
    Condition.HIV감염_CD4림프구200이하 -> "HIV 감염 (CD4 림프구 200 이하)"
    Condition.HIV감염_CD4림프구200이상 -> "HIV 감염 (CD4 림프구 200 이상)"
    Condition.임산부 -> "임산부"
    Condition.의료기관종사자 -> "의료기관 종사자"
}