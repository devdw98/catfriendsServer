package com.wtw.catfriendsServer.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProtectCenterDto {
    private int currentPCIndex;
//    private List<Date> pcClickTime;
//    private List<Boolean> isDonationClear;
//    private List<?> listOfAnimal;
    private int maxFriendCount;
    private int curFriendCount;
    private int maxTempCareCount;
    private int curTempCareCount;
    private int countOfAds;
//    private List<?> sortingOrderOfSellList;
//    private List<?> dataOfRewards;
//    private List<Integer> usedNumOfAnimals;
}
