package com.wtw.catfriendsServer.domain.enums;

public enum FieldType {
    CAFE(1),
    CHICKEN(2),
    GOPCHANG(3),
    GYM(4),
    THEATER(5);

    private int typeNum;

    FieldType(int typeNum) {
        this.typeNum = typeNum;
    }
}
