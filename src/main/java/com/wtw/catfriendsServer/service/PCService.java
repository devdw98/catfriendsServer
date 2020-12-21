package com.wtw.catfriendsServer.service;


import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.ProtectCenterDto;

public interface PCService {
    public void initial(User user);
    public void initialClientData(User user, ProtectCenterDto dto);
    public ProtectCenterDto getPCInfoDto(User user);
    public void storePCInfo(ProtectCenterDto dto, User user);
}
