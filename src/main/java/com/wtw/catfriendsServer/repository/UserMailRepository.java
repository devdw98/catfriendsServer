package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.domain.user.UserMail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMailRepository extends JpaRepository<UserMail, Long> {
    public List<UserMail> findAllByUser(User user);
    public List<UserMail> findAllByUserAndIsDelete(User user, boolean isDelete);

}
