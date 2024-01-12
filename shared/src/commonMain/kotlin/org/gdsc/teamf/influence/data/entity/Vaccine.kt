package org.gdsc.teamf.influence.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/*
디프테리아(Diphtheria)	"디프테리아균(Corynebacterium Diphtheriae) 감염 후
발생하는 급성, 독소(toxin) 매개성 호흡기 감염병입니다. 디프테리아는 온대기후 지역에서 상대적으로 발생율이 높으나 전 세계적으로 디프테리아 발생은 매우 드물며, 예방접종으로 국내에서는 1988년 이후부터는 환자가 발생하고 있지 않습니다."	DTaP, Tdap, Td 예방접종	모든 영유아(DTaP 혹은 DTaP-IPV, DTaP-IPV/Hib), 청소년 및 성인(Tdap 혹은 Td)	"생후 2, 4, 6개월에 3회 기초접종(DTaP 혹은 DTaP-IPV, DTaP-IPV/Hib)
DTaP 백신으로만 생후 15~18개월 접종, 4~6세에 DTaP(혹은 DTaP-IPV) 백신으로 각각 1회 추가접종
11~12세 때 Tdap 또는 Td 백신으로 1회 접종, 이후 매 10년마다 Td 또는 Tdap 백신 추가접종
(11세 이후 접종 중 한번은 Tdap으로 접종하며, 가능한 11~12세에 Tdap으로 접종)"
파상풍(Tetanus)	"파상풍균(Clostridium tetani)이 생산하는 독소에 의해 유발되는
급성질환으로 파상풍에 이환되면 골격근의 경직과 근육수축이 발생하는 질병입니다."	DTaP, Tdap, Td 예방접종	모든 영유아(DTaP 혹은 DTaP-IPV, DTaP-IPV/Hib), 청소년 및 성인(Tdap 혹은 Td)	"생후 2, 4, 6개월에 3회 기초접종(DTaP 혹은 DTaP-IPV, DTaP-IPV/Hib)
DTaP 백신으로만 생후 15~18개월 접종, 4~6세에 DTaP(혹은 DTaP-IPV) 백신으로 각각 1회 추가접종
11~12세 때 Tdap 또는 Td 백신으로 1회 접종, 이후 매 10년마다 Td 또는 Tdap 백신 추가접종
(11세 이후 접종 중 한번은 Tdap으로 접종하며, 가능한 11~12세에 Tdap으로 접종)"
백일해(Pertussis)	"백일해는 그람음성간균인(Bordetella pertussis)에 의한 호흡기 감염 질환입니다.
계절에 따른 발병률 차이는 명백히 밝혀진 바 없으나, 여름과 가을에 증가하는 경향을 보이며 전염성이 매우 높아 가족 내 2차 발병률이 80%에 달합니다."	DTaP, Tdap 예방접종	모든 영유아(DTaP 혹은 DTaP-IPV, DTaP-IPV/Hib), 청소년 및 성인(Tdap 혹은 Td)	"생후 2, 4, 6개월에 3회 기초접종(DTaP 혹은 DTaP-IPV, DTaP-IPV/Hib)
DTaP 백신으로만 생후 15~18개월 접종, 4~6세에 DTaP(혹은 DTaP-IPV) 백신으로 각각 1회 추가접종
11~12세 때 Tdap 또는 Td 백신으로 1회 접종, 이후 매 10년마다 Td 또는 Tdap 백신 추가접종
(11세 이후 접종 중 한번은 Tdap으로 접종하며, 가능한 11~12세에 Tdap으로 접종)"
b형헤모필루스인플루엔자(Haemophilus influenzae type b(Hib))	"b형헤모필루스인플루엔자균(Haemophilus influenzae type b)은
뇌수막염, 후두개염, 폐렴, 화농성 관절염, 봉와직염 등 중증 침습성 감염 질환의 원인이 되며, 특히 5세 미만 소아에서 주로 발생합니다."	Hib 백신 접종	"소아기에 Hib 백신 예방접종을 받지 않은 침습성 Hib 감염의 위험성이 높은 5세 이상의 소아청소년 및 성인
(고위험군: 겸상적혈구증, 비장절제술 후, 면역결핍증, 악성 종양으로 인해 화학요법 또는 방사선 요법에 따른 면역저하, HIV 감염(성인 제외), 초기 요소 보체결핍증, 조혈모세포이식 등)"	"정기접종 : 생후 2, 4, 6개월에 기초접종 및 생후 12~15개월에 추가접종(총 4회 접종)
따라잡기 접종 : 생후 7개월 이상의 영아 및 소아에게 접종을 시작한 경우 시작 연령에 따라 1~3회 접종
고위험군
1) 12개월 미만 : 정기접종에 준함
2) 12개월~59개월의 고위험군"
폐렴구균(Streptococcus pneumoniae) 감염증	"폐렴구균(Streptococcus pneumoniae)은
급성 중이염, 폐렴 및 균혈증, 수막염 등 침습성 감염을 일으키는 주요 원인균 중의 하나이며, 폐렴구균에 의한 침습성 감염은 영아 및 어린 소아와 65세 이상의 고령자에서 발생 빈도가 높습니다."	다당 백신(23가)	"2세 이상 고위험군인 소아청소년과 성인(표1, 표2)
65세 이상 노인"	"65세 이상 연령에서 1회 접종
비장적출술, 면역억제치료, 인공와우 이식술 등이 예정된 소아는 수술이나 치료 시작 전 최소 2주까지는 단백결합 백신 또는 다당 백신으로 접종 완료
기능적 또는 해부학적 무비증, 면역기능 저하 상태의 소아청소년(2세 이상)
65세 이전에 첫 번째 다당 백신을 접종받은 사람이 65세 이상 되었을 경우 첫 번째 다당 백신접종으로부터 5년이 경과한 후 1회에 한하여 재접종"
홍역(Measles)	"홍역은 전 세계적으로 유행하는 급성 발진성 바이러스 질환으로
전염성이 매우 높은 급성 유행성 감염병입니다.
이전에는 소아에서 생명을 위협하는 주요한 질병이었지만 백신이 개발된 이후 그 발생이 현저히 감소하였습니다. 하지만 일부 개발도상국가에서는 아직도 흔히 발생하고 있습니다. 국내에서는 2001년 대유행 이후로는 환자가 급격히 감소하였고, 우리나라는 36개월 이상 토착형 홍역바이러스에 의한 환자발생이 없고, 높은 홍역 예방접종률과 적절한 감시체계 유지, 유전자형 분석결과 등 세계보건기구의 홍역퇴치인증기준을 달성하여 2014년 홍역퇴치인증을 받았습니다.
최근 국내에서 보고되는 환자들은 대부분 국외에서 감염된 사례로 확인되고 있습니다."	MMR 예방접종	청소년 및 성인	"청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 홍역 항체가 확인되지 않는 1968년 1월 1일 이후 출생자는 적어도 1회 접종
(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)"
유행성이하선염(Mumps)	"유행성이하선염은 ‘볼거리’라고도 하며,
귀 아래의 침샘이 부어오르고 열과 두통이 동반되는 감염성 바이러스 질환입니다."	MMR 예방접종	소아, 청소년 및 성인	"소아 : 생후 12~15개월과 4~6세에 각각 1회 접종(총 2회)
청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 홍역 항체가 확인되지 않는 1968년 1월 1일 이후 출생자는 적어도 1회 접종
(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)"
풍진(Rubella)	"풍진은 발진, 림프절염을 동반하는 급성 바이러스성 질환입니다
임신 초기의 임신부가 풍진에 감염될 경우 유산을 하거나 태아에게 선천성 기형을 유발할 수 있습니다."	MMR 예방접종	소아, 청소년 및 성인	"소아 : 생후 12~15개월과 4~6세에 각각 1회 접종(총 2회)
청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 풍진 항체가 확인되지 않았다면 적어도 1회 접종
가임기 여성이 MMR 백신을 과거에 1회 또는 2회 접종을 받았더라도 풍진에 대한 항체검사 결과 양성이 아니라면, MMR 백신을 1회 더 접종하며, 총 접종횟수는 3회를 넘지 않도록 함"
사람유두종바이러스(Human papillomavirus (HPV)) 	"사람유두종바이러스는 생식기 감염을 일으키는
가장 흔한 원인 병원체 중 하나로, 고위험군 HPV 감염과 관련 있는 암으로는 자궁경부암, 질암, 외음부암, 음경암, 항문암, 구강암, 구인두암 등이 있고 저위험군 HPV 감염과 관련 있는 질환으로는 생식기 사마귀, 재발성 호흡기 유두종 등이 있습니다."	가다실(4가)	소아, 청소년 및 성인	"9∼14세 연령에서 첫 접종시 6~12개월 간격으로 2회 접종
15∼26세 이상 연령에서 첫 접종시 0, 2, 6개월 간격으로 3회 접종"
사람유두종바이러스(Human papillomavirus (HPV)) 	"사람유두종바이러스는 생식기 감염을 일으키는
가장 흔한 원인 병원체 중 하나로, 고위험군 HPV 감염과 관련 있는 암으로는 자궁경부암, 질암, 외음부암, 음경암, 항문암, 구강암, 구인두암 등이 있고 저위험군 HPV 감염과 관련 있는 질환으로는 생식기 사마귀, 재발성 호흡기 유두종 등이 있습니다."	서바릭스(2가)	소아, 청소년 및 성인	"9∼14세 연령에서 첫 접종시 6~12개월 간격으로 2회 접종
15∼25세 연령에서 첫 접종시 0, 1, 6개월 간격으로 3회 접종"
사람유두종바이러스(Human papillomavirus (HPV)) 	"사람유두종바이러스는 생식기 감염을 일으키는
가장 흔한 원인 병원체 중 하나로, 고위험군 HPV 감염과 관련 있는 암으로는 자궁경부암, 질암, 외음부암, 음경암, 항문암, 구강암, 구인두암 등이 있고 저위험군 HPV 감염과 관련 있는 질환으로는 생식기 사마귀, 재발성 호흡기 유두종 등이 있습니다."	가다실(9가)	소아, 청소년 및 성인	"9∼14세 연령에서 첫 접종시 6~12개월 간격으로 2회 접종
15~45세(남성의 경우 15∼26세) 연령에서 첫 접종시 0, 2, 6개월 간격으로 3회 접종"
인플루엔자(Influenza (Flu))	"인플루엔자는 인플루엔자 바이러스(Influenza virus)에 의한
감염병으로 매년 겨울철에 유행하여 고열과 함께 기침 등의 호흡기 증상을 일으키는 질환입니다."	인플루엔자 예방접종	"1) 예방접종의 실시기준 및 방법(질병관리청고시 제2023-17호)
ⓛ 인플루엔자 바이러스 감염 시 합병증 발생이 높은 대상자(고위험군)
65세 이상 노인
생후 6개월∼59개월 소아
임신부
만성폐질환자, 만성심장질환자(단순 고혈압 제외)
만성질환으로 사회복지시설 등 집단 시설에서 치료, 요양, 수용 중인 사람
만성간질환자, 만성신질환자, 신경-근육 질환, 혈액-종양 질환, 당뇨환자, 면역저하자(면역억제제 복용자), 60개월~18세의 아스피린 복용자
50~64세 성인
50~64세 성인은 인플루엔자 합병증 발생의 고위험 만성질환을 갖고 있는 경우가 많으나 예방접종률이 낮아 포함된 대상으로 65세 이상 노인과 구분
② 고위험군에게 인플루엔자를 전파시킬 위험이 있는 대상자
의료기관 종사자
6개월 미만의 영아를 돌보는 자
만성질환자, 임신부, 65세 이상 노인 등과 함께 거주하는 자
③ 집단생활로 인한 인플루엔자 유행 방지를 위해 접종이 권장되는 대상자
생후 60개월∼18세 소아 청소년
2)사스 및 조류인플루엔자 대응 정책에 따라 대응기관 종사자 및 관련 업계 종사자도 인플루엔자 백신 우선접종 권장
3)코로나19 대응과 관련한 종사자도 인플루엔자 백신 우선 접종 권장"	매년 10~12월
장티푸스(Typhoid Fever)	"장티푸스는 장티푸스균(Salmonella Typhi)의 파종감염에 의해 발생하는
급성 전신성 열성질환으로 상하수도 시설이 미비한 개발도상국에서 지속적으로 유행이 되는 질환입니다."	불활성화 백신	"위험요인 및 접종환경 등을 고려하여 제한적으로 고위험군을 대상으로 접종 권장
장티푸스 보균자와 밀접하게 접종하는 사람(가족 등)
장티푸스가 유행하는 지역으로 여행하는 사람이나 체류자
장티푸스균을 취급하는 실험실 요원"	2세 이상에서 1회 접종
장티푸스(Typhoid Fever)	"장티푸스는 장티푸스균(Salmonella Typhi)의 파종감염에 의해 발생하는
급성 전신성 열성질환으로 상하수도 시설이 미비한 개발도상국에서 지속적으로 유행이 되는 질환입니다."	경구용 생백신	"위험요인 및 접종환경 등을 고려하여 제한적으로 고위험군을 대상으로 접종 권장
장티푸스 보균자와 밀접하게 접종하는 사람(가족 등)
장티푸스가 유행하는 지역으로 여행하는 사람이나 체류자
장티푸스균을 취급하는 실험실 요원"	5세 이상에서 격일로 3회(1, 3, 5일) 투여
신증후군출혈열(Hemorrhagic Fever with renal Syndrome)	"신증후군출혈열(유행성출혈열)은
고열, 혈소판 감소증, 신부전 등을 특징으로 하는 급성 열성질환으로 Bunyaviridae과의 Hantavirus 속에 포함되는 여러 종의 바이러스에 의한 설치류 매개 인수공통감염병입니다."	신증후군출혈열 예방접종	"19세 이상의 성인으로 다음의 대상자 중 위험요인 및 접종환경 등을 고려하여 제한적으로 접종 권장
군인 및 농부 등 직업적으로 신증후군출혈열 바이러스에 노출될 위험이 높은 집단
신증후군출혈열 바이러스를 다루거나 쥐 실험을 하는 실험실 요원
야외활동이 빈번한 사람 등 개별적 노출 위험이 크다고 판단되는 자"	1개월 간격으로 2회 기초 접종하고, 12개월 뒤에 1회 추가접종(즉, 0, 1, 13개월 일정으로 3회에 걸쳐 접종)
수막구균(Neisseria meningitidis) 감염증	"수막구균 감염증은 수막구균(Neisseria meningitidis)에 의한
급성 감염병으로, 주로 수막염과 패혈증을 일으키는 중증 질환입니다."	멘비오(Menveo)	"보체 결핍
비장 절제 등의 해부학적 또는 기능정 무비증
HIV 감염증
신입 훈련병
수막구균을 다루는 실험실 종사자
수막구균 유행지역 여행자 또는 체류자
소속 집단 또는 지역사회 내 유행 시
예방접종증명서를 필요로 하는 경우
그 외 접종을 고려할 수 있는 경우(기숙사에 거주할 대학교 신입생)"	생후 2개월~55세 이하 1회
수막구균(Neisseria meningitidis) 감염증	"수막구균 감염증은 수막구균(Neisseria meningitidis)에 의한
급성 감염병으로, 주로 수막염과 패혈증을 일으키는 중증 질환입니다."	메낙트라(Menactra)	"보체 결핍
비장 절제 등의 해부학적 또는 기능정 무비증
HIV 감염증
신입 훈련병
수막구균을 다루는 실험실 종사자
수막구균 유행지역 여행자 또는 체류자
소속 집단 또는 지역사회 내 유행 시
예방접종증명서를 필요로 하는 경우
그 외 접종을 고려할 수 있는 경우(기숙사에 거주할 대학교 신입생)"	생후 9개월 ~ 55세 이하 1회
대상포진(Herpes zoster)	"대상포진은 피부분절을 따라서 수포성 발진이 발생하는 질환으로
수두-대상포진바이러스(Varicella-zoster virus, VZV)의 일차 감염 후 감각신경절에 잠복해 있던 바이러스가 재활성화되어 발생하는 질환입니다."	약독화 생백신(종류: 조스타박스, 스카이조스터)	50세 이상의 성인	2회
대상포진(Herpes zoster)	"대상포진은 피부분절을 따라서 수포성 발진이 발생하는 질환으로
수두-대상포진바이러스(Varicella-zoster virus, VZV)의 일차 감염 후 감각신경절에 잠복해 있던 바이러스가 재활성화되어 발생하는 질환입니다."	재조합 백신(종류: 싱그릭스)	"50세 이상 성인, 18세 이상에서 질병 혹은 치료로 인한 면역저하 또는 면역억제로 인하여 대상포진의 위험이 높거나 높을 것으로 예상되는 사람
(예: 자가조혈모세포이식자, 고형암 환자, 혈액암 환자, 고형장기 이식 환자)"	2~6개월 간격으로 총 2회 접종
엠폭스(MPOX)	"엠폭스(MPOX)는 원숭이두창 바이러스(Monkeypox virus)에 감염되어 발생하는
급성 발열, 발진성 질환으로 2022년 5월 이후 유럽과 북미를 중심으로 다수국가에서 풍토병 지역과 연관성이 없는 감염사례가 이례적으로 유행하여 환자가 증가하고 발생지역이 확대되고 있습니다."	3세대 두창 백신	"위험요인 등 고려하여 제한적으로 노출 가능성이 높은 고위험군을 대상으로 접종을 권장하고 있으며, 현재 일반 국민 접종은 대상이 아닙니다.
- 노출 전 : 치료병상 의료진, 진단검사 실험실 요원, 역학조사관, 고위험군 등
- 노출 후 : 역학조사 결과 관리대상 접촉자"	4주 간격, 2회* 접종
* */

@Serializable
data class Diseases(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
) {

    object Mock {
        val Diphtheria = Diseases(
            id = 1,
            name = "디프테리아/파상풍/백일해",
            description = "디프테리아, 파상풍, 백일해는 모두 박테리아에 의한 감염병으로, 디프테리아는 호흡기 감염을 일으키는 디프테리아균(Corynebacterium diphtheriae)에 의해 발생하며, 파상풍은 상처를 통해 파상풍균(Clostridium tetani)이 근육으로 침입하여 발생하며, 백일해는 호흡기 감염을 일으키는 백일해균(Bordetella pertussis)에 의해 발생합니다."
        )

        val Haemophilus = Diseases(
            id = 4,
            name = "b형헤모필루스인플루엔자",
            description = "b형헤모필루스인플루엔자균(Haemophilus influenzae type b)은 뇌수막염, 후두개염, 폐렴, 화농성 관절염, 봉와직염 등 중증 침습성 감염 질환의 원인이 되며, 특히 5세 미만 소아에서 주로 발생합니다."
        )

        val Pneumococcal = Diseases(
            id = 5,
            name = "폐렴구균",
            description = "폐렴구균(Streptococcus pneumoniae)은 급성 중이염, 폐렴 및 균혈증, 수막염 등 침습성 감염을 일으키는 주요 원인균 중의 하나이며, 폐렴구균에 의한 침습성 감염은 영아 및 어린 소아와 65세 이상의 고령자에서 발생 빈도가 높습니다."
        )

        val Measles = Diseases(
            id = 6,
            name = "홍역",
            description = "홍역은 전 세계적으로 유행하는 급성 발진성 바이러스 질환으로 전염성이 매우 높은 급성 유행성 감염병입니다. 이전에는 소아에서 생명을 위협하는 주요한 질병이었지만 백신이 개발된 이후 그 발생이 현저히 감소하였습니다. 하지만 일부 개발도상국가에서는 아직도 흔히 발생하고 있습니다. 국내에서는 2001년 대유행 이후로는 환자가 급격히 감소하였고, 우리나라는 36개월 이상 토착형 홍역바이러스에 의한 환자발생이 없고, 높은 홍역 예방접종률과 적절한 감시체계 유지, 유전자형 분석결과 등 세계보건기구의 홍역퇴치인증기준을 달성하여 2014년 홍역퇴치인증을 받았습니다. 최근 국내에서 보고되는 환자들은 대부분 국외에서 감염된 사례로 확인되고 있습니다."
        )

        val Mumps = Diseases(
            id = 7,
            name = "유행성이하선염",
            description = "유행성이하선염은 ‘볼거리’라고도 하며, 귀 아래의 침샘이 부어오르고 열과 두통이 동반되는 감염성 바이러스 질환입니다."
        )

        val Rubella = Diseases(
            id = 8,
            name = "풍진",
            description = "풍진은 발진, 림프절염을 동반하는 급성 바이러스성 질환입니다 임신 초기의 임신부가 풍진에 감염될 경우 유산을 하거나 태아에게 선천성 기형을 유발할 수 있습니다."
        )

        val HPV = Diseases(
            id = 9,
            name = "사람유두종바이러스",
            description = "사람유두종바이러스는 생식기 감염을 일으키는 가장 흔한 원인 병원체 중 하나로, 고위험군 HPV 감염과 관련 있는 암으로는 자궁경부암, 질암, 외음부암, 음경암, 항문암, 구강암, 구인두암 등이 있고 저위험군 HPV 감염과 관련 있는 질환으로는 생식기 사마귀, 재발성 호흡기 유두종 등이 있습니다."
        )

        val Influenza = Diseases(
            id = 10,
            name = "인플루엔자",
            description = "인플루엔자는 인플루엔자 바이러스(Influenza virus)에 의한 감염병으로 매년 겨울철에 유행하여 고열과 함께 기침 등의 호흡기 증상을 일으키는 질환입니다."
        )

        val Typhoid = Diseases(
            id = 11,
            name = "장티푸스",
            description = "장티푸스는 장티푸스균(Salmonella Typhi)의 파종감염에 의해 발생하는 급성 전신성 열성질환으로 상하수도 시설이 미비한 개발도상국에서 지속적으로 유행이 되는 질환입니다."
        )

        val Hemorrhagic = Diseases(
            id = 12,
            name = "신증후군출혈열",
            description = "신증후군출혈열(유행성출혈열)은 고열, 혈소판 감소증, 신부전 등을 특징으로 하는 급성 열성질환으로 Bunyaviridae과의 Hantavirus 속에 포함되는 여러 종의 바이러스에 의한 설치류 매개 인수공통감염병입니다."
        )

        val Herpes = Diseases(
            id = 13,
            name = "대상포진",
            description = "대상포진은 피부분절을 따라서 수포성 발진이 발생하는 질환으로 수두-대상포진바이러스(Varicella-zoster virus, VZV)의 일차 감염 후 감각신경절에 잠복해 있던 바이러스가 재활성화되어 발생하는 질환입니다."
        )

        val Monkeypox = Diseases(
            id = 14,
            name = "엠폭스",
            description = "엠폭스(MPOX)는 원숭이두창 바이러스(Monkeypox virus)에 감염되어 발생하는 급성 발열, 발진성 질환으로 2022년 5월 이후 유럽과 북미를 중심으로 다수국가에서 풍토병 지역과 연관성이 없는 감염사례가 이례적으로 유행하여 환자가 증가하고 발생지역이 확대되고 있습니다."
        )

        val Meningococcal = Diseases(
            id = 15,
            name = "수막구균 감염증",
            description = "수막구균 감염증은 수막구균(Neisseria meningitidis)에 의한 급성 감염병으로, 주로 수막염과 패혈증을 일으키는 중증 질환입니다."
        )


    }
}

@Serializable
data class Vaccine(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("disease") val disease: Diseases,
    @SerialName("vaccinationTarget") val vaccinationTarget: String,
    @SerialName("vaccinationPeriod") val vaccinationPeriod: String,
    @SerialName("vaccinatedFriends") val vaccinatedFriends: List<Long>,
    @SerialName("notVaccinatedFriends") val notVaccinatedFriends: List<Long>,
    @SerialName("vaccinated") val vaccinated: Boolean,
) {

    val progress : Float
        get() = vaccinatedFriends.size.toFloat() / (vaccinatedFriends.size + notVaccinatedFriends.size).toFloat()

    val progressString : String
        get() = "${(progress * 10000).toInt() / 100.0}%"


    companion object {
        val mockList = listOf(
            Vaccine(
                id = 1,
                name = "DTaP",
                disease = Diseases.Mock.Diphtheria,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 2, 4, 6개월과 15~18개월에 각각 1회 접종(총 4회)\n" +
                    "청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 파상풍 항체가 확인되지 않는 1968년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0, 1, 2),
                notVaccinatedFriends = listOf(3, 4, 5),
                vaccinated = false
            ),
            Vaccine(
                id = 2,
                name = "Tdap",
                disease = Diseases.Mock.Diphtheria,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 2, 4, 6개월과 15~18개월에 각각 1회 접종(총 4회)\n" +
                    "청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 파상풍 항체가 확인되지 않는 1968년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0, 1, 2, 3),
                notVaccinatedFriends = listOf(4, 5),
                vaccinated = true
            ),
            Vaccine(
                id = 3,
                name = "Td",
                disease = Diseases.Mock.Diphtheria,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 2, 4, 6개월과 15~18개월에 각각 1회 접종(총 4회)\n" +
                    "청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 파상풍 항체가 확인되지 않는 1968년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0, 1),
                notVaccinatedFriends = listOf(2, 3, 4, 5),
                vaccinated = true
            ),
            Vaccine(
                id = 4,
                name = "Hib",
                disease = Diseases.Mock.Haemophilus,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 2, 4, 6개월과 15~18개월에 각각 1회 접종(총 4회)\n" +
                    "청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 파상풍 항체가 확인되지 않는 1968년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0, 1, 2, 3, 4, 5),
                notVaccinatedFriends = listOf(),
                vaccinated = false
            ),
            Vaccine(
                id = 5,
                name = "PCV",
                disease = Diseases.Mock.Pneumococcal,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 2, 4, 6개월과 15~18개월에 각각 1회 접종(총 4회)\n" +
                    "청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 파상풍 항체가 확인되지 않는 1968년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0, 1, 2, 3, 4, 5),
                notVaccinatedFriends = listOf(),
                vaccinated = false
            ),
            Vaccine(
                id = 6,
                name = "MMR",
                disease = Diseases.Mock.Measles,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 2, 4, 6개월과 15~18개월에 각각 1회 접종(총 4회)\n" +
                    "청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 파상풍 항체가 확인되지 않는 1968년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = false
            ),

            Vaccine(
                id = 7,
                name = "MMRV",
                disease = Diseases.Mock.Measles,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 2, 4, 6개월과 15~18개월에 각각 1회 접종(총 4회)\n" +
                    "청소년 및 성인 : 과거 백신 접종기록이 없으면서 해당 감염병에 걸린 적이 없거나 파상풍 항체가 확인되지 않는 1968년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = false
            ),

            Vaccine(
                id = 8,
                name = "Mumps",
                disease = Diseases.Mock.Mumps,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 2, 4, 6개월과 15~18개월에 각각 1회 접종(총 4회)\n" +
                    "청소년 및 성인 : 1967년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = false
            ),

            Vaccine(
                id = 9,
                name = "Rubella",
                disease = Diseases.Mock.Rubella,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 12개월 이후 15~18개월에 각각 1회 접종(총 2회)\n" +
                    "청소년 및 성인 : 1967년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = false
            ),

            Vaccine(
                id = 10,
                name = "HPV",
                disease = Diseases.Mock.HPV,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 12개월 이후 15~18개월에 각각 1회 접종(총 2회)\n" +
                    "청소년 및 성인 : 1967년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = true
            ),

            Vaccine(
                id = 11,
                name = "인플루엔자",
                disease = Diseases.Mock.Influenza,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 12개월 이후 15~18개월에 각각 1회 접종(총 2회)\n" +
                    "청소년 및 성인 : 1967년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)",
                vaccinatedFriends = listOf(0, 2),
                notVaccinatedFriends = listOf(1, 3, 4, 5),
                vaccinated = true
            ),

            Vaccine(
                id = 12,
                name = "장티푸스",
                disease = Diseases.Mock.Typhoid,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 12개월 이후 15~18개월에 각각 1회 접종(총 2회)\n" +
                    "청소년 및 성인 : 1967년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 대학생, 직업교육원생, 의료종사자, 해외여행자는 1차 접종과 최소 4주(28일) 이상의 간격으로 2차 접종)\n" +
                    "장티푸스는 장티푸스균(Salmonella Typhi)의 파종감염에 의해 발생하는 급성 전신성 열성질환으로 상하수도 시설이 미비한 개발도상국에서 지속적으로 유행이 되는 질환입니다.",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = false
            ),

            Vaccine(
                id = 13,
                name = "신증후군출혈열",
                disease = Diseases.Mock.Hemorrhagic,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 12개월 이후 15~18개월에 각각 1회 접종(총 2회)\n" +
                    "청소년 및 성인 : 1967년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(특히, 19세 이상의 성인으로 다음의 대상자 중 위험요인 및 접종환경 등을 고려하여 제한적으로 접종 권장\n" +
                    "군인 및 농부 등 직업적으로 신증후군출혈열 바이러스에 노출될 위험이 높은 집단\n" +
                    "신증후군출혈열 바이러스를 다루거나 쥐 실험을 하는 실험실 요원\n" +
                    "야외활동이 빈번한 사람 등 개별적 노출 위험이 크다고 판단되는 자)",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = true
            ),

            Vaccine(
                id = 14,
                name = "대상포진",
                disease = Diseases.Mock.Herpes,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "소아 : 생후 12개월 이후 15~18개월에 각각 1회 접종(총 2회)\n" +
                    "청소년 및 성인 : 1967년 1월 1일 이후 출생자는 적어도 1회 접종\n" +
                    "(대상포진은 피부분절을 따라서 수포성 발진이 발생하는 질환으로 수두-대상포진바이러스(Varicella-zoster virus, VZV)의 일차 감염 후 감각신경절에 잠복해 있던 바이러스가 재활성화되어 발생하는 질환입니다.)",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = false
            ),

            Vaccine(
                id = 15,
                name = "엠폭스",
                disease = Diseases.Mock.Monkeypox,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "위험요인 등 고려하여 제한적으로 노출 가능성이 높은 고위험군을 대상으로 접종을 권장하고 있으며, 현재 일반 국민 접종은 대상이 아닙니다.\n" +
                    "- 노출 전 : 치료병상 의료진, 진단검사 실험실 요원, 역학조사관, 고위험군 등\n" +
                    "- 노출 후 : 역학조사 결과 관리대상 접촉자",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = false
            ),

            Vaccine(
                id = 16,
                name = "수막구균 감염증",
                disease = Diseases.Mock.Meningococcal,
                vaccinationTarget = "소아, 청소년 및 성인",
                vaccinationPeriod = "수막구균 감염증은 수막구균(Neisseria meningitidis)에 의한 급성 감염병으로, 주로 수막염과 패혈증을 일으키는 중증 질환입니다.\n" +
                    "보체 결핍\n" +
                    "비장 절제 등의 해부학적 또는 기능정 무비증\n" +
                    "HIV 감염증\n" +
                    "신입 훈련병\n" +
                    "수막구균을 다루는 실험실 종사자\n" +
                    "수막구균 유행지역 여행자 또는 체류자\n" +
                    "소속 집단 또는 지역사회 내 유행 시\n" +
                    "예방접종증명서를 필요로 하는 경우\n" +
                    "그 외 접종을 고려할 수 있는 경우(기숙사에 거주할 대학교 신입생)",
                vaccinatedFriends = listOf(0),
                notVaccinatedFriends = listOf(1, 2, 3, 4, 5),
                vaccinated = false
            ),
        ).sortedByDescending { it.progress }
    }
}