package com.wtw.catfriendsServer.service.impl;


import com.wtw.catfriendsServer.domain.enums.StoreType;
import com.wtw.catfriendsServer.domain.user.Store;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.StoreDto;
import com.wtw.catfriendsServer.repository.StoreRepository;
import com.wtw.catfriendsServer.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    @Override
    public void initial(User user){
        storeRepository.save(new Store(StoreType.CAFE, true, user));
        storeRepository.save(new Store(StoreType.CHICKEN, false, user));
        storeRepository.save(new Store(StoreType.GOPCHANG, false, user));
        storeRepository.save(new Store(StoreType.HEALTH, false, user));
        storeRepository.save(new Store(StoreType.THEATER, false, user));
    }

    @Override
    public StoreDto getStoreInfoDto(User user){
        List<Store> stores = storeRepository.findAllByUser(user);
        StoreDto result = new StoreDto();
        List<Integer> remodelingLv = new ArrayList<>();
        List<Boolean> isOpen = new ArrayList<>();
        List<LocalDateTime> clickTime = new ArrayList<>();
        List<Integer> levels;
        List<Float> profits;
        for(Store s : stores){
            levels = new ArrayList<>();
            profits = new ArrayList<>();
            levels.add(s.getLv1());
            levels.add(s.getLv2());
            levels.add(s.getLv3());
            levels.add(s.getLv4());
            profits.add(s.getPr1());
            profits.add(s.getPr2());
            profits.add(s.getPr3());
            profits.add(s.getPr4());
            switch(s.getType()){
                case CAFE:
                    remodelingLv.add(0,s.getRemodelingLv());
                    isOpen.add(0,s.getIsOpen());
                    clickTime.add(0, s.getClickTime());
                    result.setCafeFurnitureLv(levels);
                    result.setCafeFurnitureProfit(profits);
                    break;
                case CHICKEN:
                    remodelingLv.add(1, s.getRemodelingLv());
                    isOpen.add(1, s.getIsOpen());
                    clickTime.add(1, s.getClickTime());
                    result.setChickenFurnitureLv(levels);
                    result.setChickenFurnitureProfit(profits);
                    break;
                case GOPCHANG:
                    remodelingLv.add(2, s.getRemodelingLv());
                    isOpen.add(2, s.getIsOpen());
                    clickTime.add(2, s.getClickTime());
                    result.setGopchangFurnitureLv(levels);
                    result.setGopchangFurnitureProfit(profits);
                    break;
                case HEALTH:
                    remodelingLv.add(3, s.getRemodelingLv());
                    isOpen.add(3, s.getIsOpen());
                    clickTime.add(3, s.getClickTime());
                    result.setHealthFurnitureLv(levels);
                    result.setHealthFurnitureProfit(profits);
                    break;
                case THEATER:
                    remodelingLv.add(4, s.getRemodelingLv());
                    isOpen.add(4, s.getIsOpen());
                    clickTime.add(4, s.getClickTime());
                    result.setTheaterFurnitureLv(levels);
                    result.setTheaterFurnitureProfit(profits);
                    break;
            }
        }
        result.setRemodelingLv(remodelingLv);
        result.setIsStoreOpen(isOpen);
        result.setStoreClickTime(clickTime);
        return result;
    }

    @Override
    public void storeStores(StoreDto dto, User user){
        for(Store s : user.getStores()){
            switch (s.getType()){
                case CAFE:
                    s.update(dto, StoreType.CAFE);
                    break;
                case CHICKEN:
                    s.update(dto, StoreType.CHICKEN);
                    break;
                case GOPCHANG:
                    s.update(dto,StoreType.GOPCHANG);
                    break;
                case HEALTH:
                    s.update(dto, StoreType.HEALTH);
                    break;
                case THEATER:
                    s.update(dto, StoreType.THEATER);
                    break;
            }
        }
    }
}
