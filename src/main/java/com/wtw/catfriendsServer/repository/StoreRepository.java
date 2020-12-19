package com.wtw.catfriendsServer.repository;


import com.wtw.catfriendsServer.domain.user.Store;
import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    public List<Store> findAllByUser(User user);
}
