package com.wtw.catfriendsServer.domain.enums;

public enum RewardType {
    NOTICE(0), // 0 : 공지
    DIA(1),    // 1 : 다이아
    MONEY(2),  // 2 : 돈
    HEART(3),  // 3 : 선행포인트
    DRAW(4),   // 4 : 뽑기
    PACK(5);   // 5 : 팩

    private int typeNum;
    RewardType(int num){
        this.typeNum = num;
    }

    public static RewardType fromNum(int num){
        for(RewardType type : values()){
            if(type.ordinal() == num)
                return type;
        }
        return null;
    }
}
