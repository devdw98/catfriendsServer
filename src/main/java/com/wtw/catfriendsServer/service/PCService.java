package com.wtw.catfriendsServer.service;


import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.ProtectCenterDto;

public interface PCService {
    public void initial(User user);
    public ProtectCenterDto getPCInfoDto(User user);
    public void storePCInfo(ProtectCenterDto dto, User user);
}
