package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.StoreDto;
import com.wtw.catfriendsServer.dto.UserDto;

import java.util.Map;

public interface BaseService {
    public void initial(User user);
    public Map<String, Object> getBaseInfoDto(User user);
    public void storeBaseInfoDto(UserDto dto, User user);
}
