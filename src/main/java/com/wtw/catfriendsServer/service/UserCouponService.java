package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.domain.user.UserCoupon;
import com.wtw.catfriendsServer.dto.UserDto;

import java.util.List;

public interface UserCouponService {
    public List<UserCoupon> getUserCoupon(User user);
    public void storeUserCoupon(UserDto dto, User user);
}
