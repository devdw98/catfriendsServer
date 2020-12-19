package com.wtw.catfriendsServer.service.impl;


import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.domain.user.UserCoupon;
import com.wtw.catfriendsServer.dto.UserDto;
import com.wtw.catfriendsServer.repository.UserCouponRepository;
import com.wtw.catfriendsServer.service.UserCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCouponServiceImpl implements UserCouponService {
    private final UserCouponRepository userCouponRepository;

    public void registerUserCoupon(User user, String number){
        UserCoupon coupon = new UserCoupon(number, user);
        userCouponRepository.save(coupon);
    }

    @Override
    public List<UserCoupon> getUserCoupon(User user){
        return userCouponRepository.findAllByUser(user);
    }

    @Override
    public void storeUserCoupon(UserDto dto, User user){
        List<String> coupons = dto.getCouponNumber();
        List<Boolean> isUsed = dto.getIsUsedCoupon();
        for(UserCoupon coupon : user.getCoupons()){
            for(String s : coupons){
                if(coupon.getNumber().equals(s)){
                    coupon.update(isUsed.get(coupons.indexOf(s)));
                }
            }
        }
    }
}
