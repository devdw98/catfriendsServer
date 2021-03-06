package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.user.*;
import com.wtw.catfriendsServer.dto.NyanNyaLandDto;
import com.wtw.catfriendsServer.dto.QuestDto;
import com.wtw.catfriendsServer.dto.RSPGameDto;
import com.wtw.catfriendsServer.dto.UserDto;
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
    private final NyanNyaLandService nyanNyaLandService;
    private final UserCouponService userCouponService;
    private final StoreService storeService;
    private final QuestService questService;
    private final PCService pcService;
    private final FriendService friendService;
    private final MailService mailService;
    private final RequestService requestService;
    private final UserShopService userShopService;

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
    @Transactional
    public boolean initialClientData(String uid, UserDto dto){
        try{
            User user = userRepository.save(new User(uid, dto));
            baseService.initialClientData(user, dto);
            nyanNyaLandService.initialClientData(user, dto);
            storeService.initialClientData(user, dto.getStore());
            questService.initialClientData(user, dto.getQuestLv(), dto.getIsCompleteQuest(), dto.getQuest());
            pcService.initialClientData(user, dto.getProtectionCenter());
            friendService.initialClientData(user, dto.getCatdog(), dto.getAnimal(), dto.getProtectionCenter().getPcClickTime(),
                    dto.getProtectionCenter().getUsedNumOfAnimals(), dto.getProtectionCenter().getStepOfSellList());
            requestService.initialClientData(user, dto.getRequestDict(), dto.getRequestTimes());
            userShopService.initialClientData(user, dto.getShop());
            userCouponService.initialClientData(user, dto.getCouponNumber());
            return true;
        }catch (IllegalArgumentException e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean checkDuplicateUser(String uid){
        return userRepository.existsByUid(uid);
    }

    @Override
    public UserDto getUser(String uid){
        User user = userRepository.findByUid(uid);
        UserDto result = getDto(user);

        log.info("Successful get User Data!: "+uid);
        return result;
    }

    public User getUserForMails(String uid){
        return userRepository.findByUid(uid);
    }

    @Override
    public UserDto storeUser(String uid, UserDto req){
        User user = userRepository.findByUid(uid);
        user.update(req);
        baseService.storeBaseInfoDto(req, user);
        nyanNyaLandService.storeNyanNyaInfo(user, req.getRspGame(), req.getNyanNyaLand());
        storeService.storeStores(req.getStore(), user);
        questService.storeQuestInfo(req.getQuestLv(), req.getIsCompleteQuest(), req.getQuest(), user);
        pcService.storePCInfo(req.getProtectionCenter(), user);
        friendService.storeCatDogs(req, user);
        friendService.storeAnimals(req, user);
        requestService.storeRequests(req.getRequestTimes(), req.getRequestDict(), user);
        userShopService.storeShopData(user, req.getShop());
        userCouponService.storeUserCoupon(req, user);
//        mailService.storeUserMailData(req.getMailList(), user);

        userRepository.save(user);

        UserDto result = getDto(user);
        log.info("Successful store User Data!: "+uid);
       return result;
    }

    public UserDto getDto(User user){
        List<String> couponNumber = new ArrayList<>();
        List<Boolean> isUsedCoupon = new ArrayList<>();
        Map<String, Object> baseInfo = baseService.getBaseInfoDto(user);
        Map<String, Object> nyanNyaInfo = nyanNyaLandService.getNyanNyaInfoDto(user);
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
        result.setRspGame((RSPGameDto)nyanNyaInfo.get("rspGame"));
        result.setNyanNyaLand((NyanNyaLandDto)nyanNyaInfo.get("nyanNya"));
        result.setQuestLv((Integer)questInfo.get("questLv"));
        result.setIsCompleteQuest((Boolean)questInfo.get("isCompleteQuest"));
        result.setQuest((QuestDto)questInfo.get("result"));
        result.setProtectionCenter(pcService.getPCInfoDto(user));
        result.setCatdog(friendService.getCatDogDtos(user));
        result.setAnimal(friendService.getAnimalDtos(user));

        result.setRequestDict(requestService.getRequestDict(user));
        result.setRequestTimes(requestService.getRequestTimes(user));
        result.setRequestCount(result.getRequestTimes().size());
        result.setShop(userShopService.getShopDto(user));

        return result;
    }
}
