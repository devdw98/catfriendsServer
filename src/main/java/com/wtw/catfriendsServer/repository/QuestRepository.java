package com.wtw.catfriendsServer.repository;


import com.wtw.catfriendsServer.domain.user.Quest;
import com.wtw.catfriendsServer.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends JpaRepository<Quest, Long> {
    public Quest findByUser(User user);
}
