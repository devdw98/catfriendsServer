package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.Quest;
import com.wtw.catfriendsServer.domain.user.QuestDaily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestDailyRepository extends JpaRepository<QuestDaily, Long> {
    public List<QuestDaily> findAllByQuest(Quest quest);
}
