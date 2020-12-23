package com.wtw.catfriendsServer.dto;

import com.wtw.catfriendsServer.domain.user.Animal;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class ProtectCenterDto {
    private int currentPCIndex;
    private List<LocalDateTime> pcClickTime;
//    private List<Boolean> isDonationClear;
    private List<AnimalDto> listOfAnimal;
    private int maxFriendCount;
    private int curFriendCount;
    private int maxTempCareCount;
    private int curTempCareCount;
    private int countOfAds;
//    private List<?> sortingOrderOfSellList;
//    private List<?> dataOfRewards;
//    private List<Integer> usedNumOfAnimals;
}
