package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.ShopDto;

public interface UserShopService {
    public void initialClientData(User user, ShopDto dto);
    public ShopDto getShopDto(User user);
    public void storeShopData(User user, ShopDto dto);
}
