package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.ProtectCenter;
import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProtectCenterRepository extends JpaRepository<ProtectCenter, Long> {
    public ProtectCenter findByUser(User user);
}
