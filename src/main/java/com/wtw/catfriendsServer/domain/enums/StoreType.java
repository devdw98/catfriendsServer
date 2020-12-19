package com.wtw.catfriendsServer.domain.enums;

public enum StoreType {
    NONE(-1),
    CAFE(1),
    CHICKEN(2),
    GOPCHANG(3),
    HEALTH(4),
    THEATER(5);

    private int typeNum;
    StoreType (int num){this.typeNum = num;}
    public static StoreType fromNum(int num){
        for(StoreType type : values()){
            if(type.ordinal() == num)
                return type;
        }
        return null;
    }
    public static int toNum(StoreType type){
        return type.typeNum;
    }
}

