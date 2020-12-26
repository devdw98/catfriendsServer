package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.NyanNyaLandDto;
import com.wtw.catfriendsServer.dto.RSPGameDto;
import com.wtw.catfriendsServer.dto.UserDto;

import java.util.Map;

public interface NyanNyaLandService {
    public void initialClientData(User user, UserDto dto);
    public Map<String, Object> getNyanNyaInfoDto(User user);
    public void storeNyanNyaInfo(User user, RSPGameDto gameDto, NyanNyaLandDto landDto);
}
