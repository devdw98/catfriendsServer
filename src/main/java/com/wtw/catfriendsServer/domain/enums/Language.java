package com.wtw.catfriendsServer.domain.enums;

public enum Language {
    KOR(0),
    JPN(1),
    CHN(2),
    ENG(3);
    private int typeNum;

    Language(int typeNum) {
        this.typeNum = typeNum;
    }
}
