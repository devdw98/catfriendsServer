package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.StoreDto;

public interface StoreService {
    public void initial(User user);
    public StoreDto getStoreInfoDto(User user);
    public void storeStores(StoreDto dto, User user);
}
