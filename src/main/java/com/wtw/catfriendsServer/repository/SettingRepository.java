package com.wtw.catfriendsServer.repository;


import com.wtw.catfriendsServer.domain.user.Setting;
import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
    public Setting findByUser(User user);
}
