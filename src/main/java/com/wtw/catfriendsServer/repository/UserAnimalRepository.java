package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.UserAnimal;
import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnimalRepository extends JpaRepository<UserAnimal, Long> {
    public List<UserAnimal> findAllByUser(User user);
}
