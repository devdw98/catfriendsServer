package com.wtw.catfriendsServer.domain.enums;

public enum QuestType {
    ETC(0),
    BOMI(1), //보미 퀘스트
    DAILY(2), //일일 과제
    ACHIEVEMENT(3), //업적
    REQUEST(4); //의뢰

    private int typeNum;

    QuestType(int typeNum) {
        this.typeNum = typeNum;
    }
}
