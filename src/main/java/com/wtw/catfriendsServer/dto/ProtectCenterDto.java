package com.wtw.catfriendsServer.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProtectCenterDto {
    private int currentPCIndex;//
    private List<LocalDateTime> pcClickTime;//
    private List<Boolean> isDonationClear;//
    private List<AnimalDto> listOfAnimal;//해야함
    private int maxFriendCount;//
    private int curFriendCount;//
    private int maxTempCareCount;//
    private int curTempCareCount;//
    private int countOfAds;//
    private List<Integer> usedNumOfAnimals;
    private Boolean isProtectionCenter;//
    private List<Integer> stepOfSellList;
}
