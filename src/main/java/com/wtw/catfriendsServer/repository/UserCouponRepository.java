package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.domain.user.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCouponRepository extends JpaRepository<UserCoupon, Long> {
    public List<UserCoupon> findAllByUser(User user);
}
