package com.wtw.catfriendsServer.domain.enums;

public enum QuestState {
    PROGRESS(0), //진행중
    COMPLETION(1), //퀘스트 완료(수령가능)
    RECEIPT(2); //수령 완료

    private int stateNum;
    QuestState(int num){
        this.stateNum = num;
    }

    public static QuestState fromNum(int num){
        for(QuestState state : values()){
            if(state.ordinal() == num)
                return state;
        }
        return null;
    }
}
