package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUid(String uid);
}
