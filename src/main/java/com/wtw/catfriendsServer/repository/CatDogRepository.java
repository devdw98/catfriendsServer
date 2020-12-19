package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.CatDog;
import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatDogRepository extends JpaRepository<CatDog, Long> {
    public List<CatDog> findAllByUser(User user);
}
