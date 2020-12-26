package com.wtw.catfriendsServer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.wtw.catfriendsServer.domain.enums.Language;
import com.wtw.catfriendsServer.domain.enums.RequestType;
import com.wtw.catfriendsServer.domain.user.Chunbae;
import com.wtw.catfriendsServer.domain.user.Setting;
import com.wtw.catfriendsServer.domain.user.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class UserDto {
    private double money; //
    private int dia;//
    private int heart;//
    private double curAddMoney;//
    private LocalDateTime curTime;//
    private LocalDateTime saveTime;//

    private int chunbaeLv;//
    private int staminaDrinkAmount;//
    private int maxStamina;//
    private int curStamina;//
    private float soundBgFloat;//
    private float soundEffectFloat;//
    private Boolean vibration;
    private Language language;//

    private List<String> couponNumber;//
    private List<Boolean> isUsedCoupon;//

    private StoreDto store; //
    private NyanNyaLandDto nyanNyaLand;//
    private RSPGameDto rspGame;//
    private int questLv;//
    private Boolean isCompleteQuest;//
    private QuestDto quest;//
    private ProtectCenterDto protectionCenter;//
    private List<CatDogDto> catdog;//
    private List<AnimalDto> animal;//
    private Map<String, RequestType> requestDict;//
    private List<RequestTimeDto> requestTimes;//
    private int requestCount;//
//    private List<?> shopItemDict; //뭔지 꼭 물어보기!
    private ShopDto shop;

//    private List<UserMailDto> mailList;

    public User toEntity(String uid){
        User entity = User.builder()
                .uid(uid)
                .money(money)
                .dia(dia)
                .heart(heart)
                .curAddMoney(curAddMoney)
                .curTime(curTime)
                .saveTime(saveTime)
                .build();
        return entity;
    }

    public Chunbae chunbaeEntity(User user){
        Chunbae entity = Chunbae.builder()
                .level(chunbaeLv)
                .stamina(staminaDrinkAmount)
                .maxStamina(maxStamina)
                .curStamina(curStamina)
                .user(user).build();
        return entity;
    }

    public Setting settingEntity(User user){
        Setting entity = Setting.builder()
                .soundBg(soundBgFloat)
                .soundEf(soundEffectFloat)
                .vibration(vibration)
                .language(language)
                .user(user)
                .build();
        return entity;
    }

}
