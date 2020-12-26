package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.user.NyanNyaLand;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.NyanNyaLandDto;
import com.wtw.catfriendsServer.dto.RSPGameDto;
import com.wtw.catfriendsServer.dto.UserDto;
import com.wtw.catfriendsServer.repository.NyanNyaLandRepository;
import com.wtw.catfriendsServer.service.NyanNyaLandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NyanNyaLandServiceImpl implements NyanNyaLandService {
    private final NyanNyaLandRepository repository;

    @Override
    public void initialClientData(User user, UserDto dto){
        NyanNyaLand land = NyanNyaLand.builder()
                .winCount(dto.getRspGame().getWinCount())
                .nyanCoin(dto.getNyanNyaLand().getCoin())
                .nyanNyaTicket(dto.getNyanNyaLand().getTicket())
                .nyangPae(dto.getNyanNyaLand().getNyangpae())
                .jokbo(dto.getNyanNyaLand().getJokbo())
                .user(user).build();
        repository.save(land);
    }

    @Override
    public Map<String, Object> getNyanNyaInfoDto(User user){
        Map<String, Object> map = new HashMap<>();
        NyanNyaLand nyanNya = repository.findByUser(user);
        map.put("rspGame", nyanNya.toRspGameDto());
        map.put("nyanNya", nyanNya.toNyanNyaDto());

        return map;
    }

    @Override
    public void storeNyanNyaInfo(User user, RSPGameDto gameDto, NyanNyaLandDto landDto){
        user.getNyanNyaLand().update(gameDto, landDto);
    }
}
