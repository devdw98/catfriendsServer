package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.RSPGame;
import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RSPGameRepository extends JpaRepository<RSPGame, Long> {
    public RSPGame findByUser(User user);
}
