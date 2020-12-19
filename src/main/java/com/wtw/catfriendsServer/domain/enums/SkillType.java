package com.wtw.catfriendsServer.domain.enums;

public enum SkillType {
    CAFE(1), //카페
    CHICKEN(2), //치킨
    GOPCHANG(3), //곱창
    GYM(4), //역기
    THEATER(5), //영화관

    WHOLE_FIELD(100), //전체 가게 매출
    WHOLE_PROFIT(101), //전체 수익
    TOUCH_PROFIT(102), //터치 수익
    FATIGUE_INCREASE(103), //피로도 최대치 증가
    FATIGUE_REDUCTION(104), //피로도 소모량 감소
    TOUCH_FEVER(105), //터치당 피버 게이지 증가
    TOUCN_JACKPOT(106), //터치 시 돈벼락 확률
    TOUCH_GAUGE_100(107), //게이지 100% 일 때의 터치 돈 관련
    UPGRADE(108), //춘배, 가게 업그레이드 비용 관련
    UPGRADE_FRIENDS(109), //친구들 업그레이드 선행 포인트 소모량 감소 관련
    FEVER_DURATION(110),//피버타임 지속 시간
    FEVER_MULTIPLE(111);//피버타임 배수




    private int typeNum;

    SkillType(int typeNum) {
        this.typeNum = typeNum;
    }
}
