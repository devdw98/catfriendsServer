package com.wtw.catfriendsServer.repository;

import com.wtw.catfriendsServer.domain.user.Quest;
import com.wtw.catfriendsServer.domain.user.QuestChallenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestChallengeRepository extends JpaRepository<QuestChallenge, Long> {
    public List<QuestChallenge> findAllByQuest(Quest quest);
}
