package com.wtw.catfriendsServer.domain.enums;

public enum KindType {
    CATDOG(0),
    ANIMAL(1);

    private int typeNum;

    KindType(int typeNum) {
        this.typeNum = typeNum;
    }
}
