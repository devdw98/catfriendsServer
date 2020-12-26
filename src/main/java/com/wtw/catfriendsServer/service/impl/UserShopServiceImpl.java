package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.domain.user.UserShop;
import com.wtw.catfriendsServer.dto.ShopDto;
import com.wtw.catfriendsServer.repository.UserShopRepository;
import com.wtw.catfriendsServer.service.UserShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserShopServiceImpl implements UserShopService {
    private final UserShopRepository repository;

    @Override
    public void initialClientData(User user, ShopDto dto) {
        UserShop shop = UserShop.builder()
                .isBuyLp1(dto.getIsBuyLP().get(0))
                .isBuyLp2(dto.getIsBuyLP().get(1))
                .ads1(dto.getAds().get(0))
                .ads2(dto.getAds().get(1))
                .ads3(dto.getAds().get(2))
                .period1(dto.getPeriod().get(0))
                .period2(dto.getPeriod().get(1))
                .period3(dto.getPeriod().get(2))
                .daily1(dto.getDaily().get(0))
                .daily2(dto.getDaily().get(1))
                .daily3(dto.getDaily().get(2))
                .user(user)
                .build();
        repository.save(shop);
    }

    @Override
    public ShopDto getShopDto(User user) {
        return repository.findByUser(user).toDto();
    }

    @Override
    public void storeShopData(User user, ShopDto dto) {
        user.getShop().update(dto);
    }
}
