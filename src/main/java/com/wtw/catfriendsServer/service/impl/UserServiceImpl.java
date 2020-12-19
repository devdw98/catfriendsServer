package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.user.*;
import com.wtw.catfriendsServer.dto.QuestDto;
import com.wtw.catfriendsServer.dto.RSPGameDto;
import com.wtw.catfriendsServer.dto.UserDto;
import com.wtw.catfriendsServer.repository.ChunbaeRepository;
import com.wtw.catfriendsServer.repository.RSPGameRepository;
import com.wtw.catfriendsServer.repository.SettingRepository;
import com.wtw.catfriendsServer.repository.UserRepository;
import com.wtw.catfriendsServer.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final BaseService baseService;
    private final UserCouponService userCouponService;
    private final StoreService storeService;
    private final QuestService questService;
    private final PCService pcService;
    private final FriendService friendService;
    private final MailService mailService;

    @Transactional
    @Override
    public UserDto initial(String uid) {
        User user = userRepository.save(new User(uid));
        baseService.initial(user);
        storeService.initial(user);
        questService.initial(user);
        pcService.initial(user);
        friendService.initial(user);

        UserDto result = getDto(user);
        log.info("Successful Join!: "+uid);
        return result;
    }

    @Override
    public boolean checkDuplicateUser(String uid){
        if(userRepository.findByUid(uid)!=null) //회원정보 있음
            return true;
        else
            return false; //회원정보 없음
    }

    @Override
    public UserDto getUser(String uid){
        User user = userRepository.findByUid(uid);
        UserDto result = getDto(user);
        log.info("Successful get User Data!: "+uid);
        return result;
    }

    @Override
    public UserDto storeUser(String uid, UserDto req){
        User user = userRepository.findByUid(uid);
        user.update(req);
        baseService.storeBaseInfoDto(req, user);
        friendService.storeCatDogs(req, user);
        friendService.storeAnimals(req, user);
        storeService.storeStores(req.getStore(), user);
        userCouponService.storeUserCoupon(req, user);
        pcService.storePCInfo(req.getProtectionCenter(), user);
        questService.storeQuestInfo(req.getQuest(), user);

        userRepository.save(user);

        UserDto result = getDto(user);
        log.info("Successful store User Data!: "+uid);
       return result;
    }

    public UserDto getDto(User user){
        List<String> couponNumber = new ArrayList<>();
        List<Boolean> isUsedCoupon = new ArrayList<>();
        Map<String, Object> baseInfo = baseService.getBaseInfoDto(user);
        Map<String, Object> questInfo = questService.getQuestInfoDto(user);

        UserDto result = user.toDto();
        result.setChunbaeLv(((Chunbae)baseInfo.get("chunbae")).getLevel());
        result.setStaminaDrinkAmount(((Chunbae)baseInfo.get("chunbae")).getStamina());
        result.setMaxStamina(((Chunbae)baseInfo.get("chunbae")).getMaxStamina());
        result.setCurStamina(((Chunbae)baseInfo.get("chunbae")).getCurStamina());
        result.setSoundBgFloat(((Setting)baseInfo.get("setting")).getSoundBg());
        result.setSoundEffectFloat(((Setting)baseInfo.get("setting")).getSoundEf());
        result.setVibration(((Setting) baseInfo.get("setting")).getVibration());
        result.setLanguage(((Setting)baseInfo.get("setting")).getLanguage());
        for(UserCoupon coupon : userCouponService.getUserCoupon(user)){
            couponNumber.add(coupon.getNumber());
            isUsedCoupon.add(coupon.getIsUsed());
        }
        result.setCouponNumber(couponNumber);
        result.setIsUsedCoupon(isUsedCoupon);

        result.setStore(storeService.getStoreInfoDto(user));
        result.setRspGame((RSPGameDto)baseInfo.get("rspGame"));
        result.setQuestLv((Integer)questInfo.get("questLv"));
        result.setIsQuestConversationEnd((Boolean)questInfo.get("isQuestConversationEnd"));
        result.setQuest((QuestDto)questInfo.get("result"));
        result.setProtectionCenter(pcService.getPCInfoDto(user));
        result.setCatDog(friendService.getCatDogDtos(user));
        result.setAnimal(friendService.getAnimalDtos(user));
        result.setMailList(mailService.getUserMailList(user));

        return result;
    }
}
