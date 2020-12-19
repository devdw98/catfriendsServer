package com.wtw.catfriendsServer.domain.enums;

public enum  AnimalType {
    CATDOG(1),
    ANIMAL(0);

    private int typeNum;

    AnimalType(int typeNum) {
        this.typeNum = typeNum;
    }
}
