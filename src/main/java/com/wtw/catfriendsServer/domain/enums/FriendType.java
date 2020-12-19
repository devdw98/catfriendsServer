package com.wtw.catfriendsServer.domain.enums;

public enum FriendType {
    CATDOG(1),
    ANIMAL(0);

    private int typeNum;

    FriendType(int typeNum) {
        this.typeNum = typeNum;
    }
}
