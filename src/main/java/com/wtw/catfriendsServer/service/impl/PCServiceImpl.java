package com.wtw.catfriendsServer.service.impl;


import com.wtw.catfriendsServer.domain.user.pc.PcClickTime;
import com.wtw.catfriendsServer.domain.user.pc.ProtectCenter;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.ProtectCenterDto;
import com.wtw.catfriendsServer.repository.PcClickTimeRepository;
import com.wtw.catfriendsServer.repository.ProtectCenterRepository;
import com.wtw.catfriendsServer.service.PCService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PCServiceImpl implements PCService {
    private final ProtectCenterRepository pcRepository;
    private final PcClickTimeRepository clickTimeRepository;

    @Override
    public void initial(User user) {
        pcRepository.save(new ProtectCenter(user));
    }

    public void initialClientData(User user, ProtectCenterDto dto){
        List<LocalDateTime> times = dto.getPcClickTime();
        ProtectCenter pc = ProtectCenter.builder()
                .user(user)
                .dto(dto)
                .build();
        pcRepository.save(pc);

        PcClickTime clickTime = PcClickTime.builder()
                .time1(times.get(0))
                .time2(times.get(1))
                .time3(times.get(2))
                .time4(times.get(3))
                .time5(times.get(4))
                .time6(times.get(5))
                .time7(times.get(6))
                .time8(times.get(7))
                .time9(times.get(8))
                .time10(times.get(9))
                .time11(times.get(10))
                .time12(times.get(11))
                .time13(times.get(12))
                .time14(times.get(13))
                .time15(times.get(14))
                .time16(times.get(15))
                .time17(times.get(16))
                .time18(times.get(17))
                .time19(times.get(18))
                .time20(times.get(19))
                .pc(pc)
                .build();
        clickTimeRepository.save(clickTime);
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
        result.setPcClickTime(pc.getClickTime().toList());
        return result;
    }

    @Override
    public void storePCInfo(ProtectCenterDto dto, User user){
        user.getProtectionCentor().update(dto);
    }
}
