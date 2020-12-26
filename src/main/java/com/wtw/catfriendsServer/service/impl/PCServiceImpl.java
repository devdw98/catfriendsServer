package com.wtw.catfriendsServer.service.impl;


import com.wtw.catfriendsServer.domain.user.ProtectCenter;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.domain.user.UserAnimal;
import com.wtw.catfriendsServer.dto.ProtectCenterDto;
import com.wtw.catfriendsServer.repository.ProtectCenterRepository;
import com.wtw.catfriendsServer.repository.UserAnimalRepository;
import com.wtw.catfriendsServer.service.PCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PCServiceImpl implements PCService {
    private final ProtectCenterRepository pcRepository;
    private final UserAnimalRepository animalRepository;

    @Override
    public void initial(User user) {
        pcRepository.save(new ProtectCenter(user));
    }

    public void initialClientData(User user, ProtectCenterDto dto){
        ProtectCenter pc = ProtectCenter.builder()
                .user(user)
                .dto(dto)
                .build();
        pcRepository.save(pc);

    }

    @Override
    public ProtectCenterDto getPCInfoDto(User user) {
        ProtectCenter pc = user.getProtectionCentor();
        List<UserAnimal> animals = user.getUserAnimals();
        List<LocalDateTime> clickTime = new ArrayList<>();
        List<Integer> usedNumOfAnimals = new ArrayList<>();
        List<Integer> stepOfSellList = new ArrayList<>();
        for(UserAnimal animal : animals){
            clickTime.add(animal.getClickTime());
            usedNumOfAnimals.add(animal.getUsedAnimal());
            stepOfSellList.add(animal.getStepOfSell());
        }
        ProtectCenterDto result = new ProtectCenterDto();
        result.setCurrentPCIndex(pc.getCurrentPCIndex());
        result.setIsDonationClear(pc.getDonationClear());
        result.setPcClickTime(clickTime);
        //listofanimals
        result.setMaxFriendCount(pc.getMaxFriendCount());
        result.setCurFriendCount(pc.getCurFriendCount());
        result.setMaxTempCareCount(pc.getMaxTempCareCount());
        result.setCurTempCareCount(pc.getCurTempCareCount());
        result.setCountOfAds(pc.getCountOfAds());
        result.setUsedNumOfAnimals(usedNumOfAnimals);
        result.setIsProtectionCenter(pc.getIsPC());
        result.setStepOfSellList(stepOfSellList);

        return result;
    }

    @Override
    public void storePCInfo(ProtectCenterDto dto, User user){
        user.getProtectionCentor().update(dto);
    }
}
