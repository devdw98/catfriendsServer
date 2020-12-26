package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.domain.user.UserShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserShopRepository extends JpaRepository<UserShop, Long> {
    public UserShop findByUser(User user);
}
