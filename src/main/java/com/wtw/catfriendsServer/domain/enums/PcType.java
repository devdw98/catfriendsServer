package com.wtw.catfriendsServer.domain.enums;

public enum PcType {
    FRIEND(0),
    TEMP(1);

    private int typeNum;

    PcType(int typeNum) {
        this.typeNum = typeNum;
    }
}
