package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.NyanNyaLand;
import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NyanNyaLandRepository extends JpaRepository<NyanNyaLand, Long> {
    public NyanNyaLand findByUser(User user);
}
