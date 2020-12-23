package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.user.Chunbae;
import com.wtw.catfriendsServer.domain.user.NyanNyaLand;
import com.wtw.catfriendsServer.domain.user.Setting;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.UserDto;
import com.wtw.catfriendsServer.repository.ChunbaeRepository;
import com.wtw.catfriendsServer.repository.NyanNyaLandRepository;
import com.wtw.catfriendsServer.repository.SettingRepository;
import com.wtw.catfriendsServer.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BaseServiceImpl implements BaseService {
    private final ChunbaeRepository chunbaeRepository;
    private final SettingRepository settingRepository;
    private final NyanNyaLandRepository nyanNyaLandRepository;

    @Override
    public void initial(User user) {
        chunbaeRepository.save(new Chunbae(user));
        settingRepository.save(new Setting(user));
        nyanNyaLandRepository.save(new NyanNyaLand(user));
    }

    @Override
    public void initialClientData(User user, UserDto dto){
        Chunbae chunbae = Chunbae.builder()
                .level(dto.getChunbaeLv())
                .stamina(dto.getStaminaDrinkAmount())
                .maxStamina(dto.getMaxStamina())
                .curStamina(dto.getMaxStamina())
                .user(user).build();
        Setting setting = Setting.builder()
                .soundBg(dto.getSoundBgFloat())
                .soundEf(dto.getSoundEffectFloat())
                .vibration(false)
                .language(dto.getLanguage())
                .user(user)
                .build();
        NyanNyaLand land = NyanNyaLand.builder()
                .winCount(dto.getRspGame().getWinCount())
                .nyanCoin(dto.getNyanNyaLand().getCoin())
                .nyanNyaTicket(dto.getNyanNyaLand().getTicket())
                .user(user).build();
        chunbaeRepository.save(chunbae);
        settingRepository.save(setting);
        nyanNyaLandRepository.save(land);
    }

    @Override
    public Map<String, Object> getBaseInfoDto(User user) {
        Map<String, Object> map = new HashMap<>();
        NyanNyaLand nyanNya = nyanNyaLandRepository.findByUser(user);
        map.put("chunbae", chunbaeRepository.findByUser(user));
        map.put("setting", settingRepository.findByUser(user));
        map.put("rspGame", nyanNya.toRspGameDto());
        map.put("nyanNya", nyanNya.toNyanNyaDto());
        return map;
    }

    @Override
    public void storeBaseInfoDto(UserDto dto, User user) {
        user.getChunbae().update(dto);
        user.getSetting().update(dto);
    //    user.getRsp().update(dto.getRspGame());
    }
}
