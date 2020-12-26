package com.wtw.catfriendsServer.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestDto {
    List<Boolean> isMax_daily;//
    List<Boolean> isReceived_daily;//
    List<Integer> goal_daily;//
    private int clearAllQuestCount_daily;//
    private int attend_daily;//
    private int roamerTouch_daily;
    private int nyangnaland_daily;
    private int touch_daily;
    private int customerTouch_daily;

    List<Boolean> isMax_challenge;//
    List<Integer> count_challenge;//
    List<Integer> limit_challenge;//
    List<Integer> goal_challenge;//

    private int touchCount_challenge;//
    private int feverCount_challenge;//
    private int unlockStore_challenge;
    private int animalLvCount_challenge;
    private int absentMoney_challenge;

    private int catdogBatchCount_challenge;//
    private int goodPoint_challenge;//
    private int giveCount_challenge;//
    private int roamerTouch_challenge;
}
