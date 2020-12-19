package com.wtw.catfriendsServer.service.impl;


import com.wtw.catfriendsServer.domain.user.ProtectCenter;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.ProtectCenterDto;
import com.wtw.catfriendsServer.repository.ProtectCenterRepository;
import com.wtw.catfriendsServer.service.PCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PCServiceImpl implements PCService {
    private final ProtectCenterRepository pcRepository;

    @Override
    public void initial(User user) {
        pcRepository.save(new ProtectCenter(user));
    }

    @Override
    public ProtectCenterDto getPCInfoDto(User user) {
        ProtectCenter pc = pcRepository.findByUser(user);
        ProtectCenterDto result = new ProtectCenterDto();
        result.setCurrentPCIndex(pc.getCurrentPCIndex());
        result.setMaxFriendCount(pc.getMaxFriendCount());
        result.setCurFriendCount(pc.getCurFriendCount());
        result.setMaxTempCareCount(pc.getMaxTempCareCount());
        result.setCurTempCareCount(pc.getCurTempCareCount());
        result.setCountOfAds(pc.getCountOfAds());
        return result;
    }

    @Override
    public void storePCInfo(ProtectCenterDto dto, User user){
        user.getProtectionCentor().update(dto);
    }
}
