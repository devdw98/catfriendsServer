package com.wtw.catfriendsServer.service.impl;


import com.wtw.catfriendsServer.domain.user.Quest;
import com.wtw.catfriendsServer.domain.user.QuestChallenge;
import com.wtw.catfriendsServer.domain.user.QuestDaily;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.QuestDto;
import com.wtw.catfriendsServer.dto.UserDto;
import com.wtw.catfriendsServer.repository.QuestChallengeRepository;
import com.wtw.catfriendsServer.repository.QuestDailyRepository;
import com.wtw.catfriendsServer.repository.QuestRepository;
import com.wtw.catfriendsServer.service.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QuestServiceImpl implements QuestService {
    private final QuestRepository questRepository;
    private final QuestDailyRepository dailyRepository;
    private final QuestChallengeRepository challengeRepository;

    @Override
    public void initial(User user) {
        Quest quest = questRepository.save(new Quest(user));
        dailyRepository.save(new QuestDaily(quest, 1));
        dailyRepository.save(new QuestDaily(quest, 5));
        dailyRepository.save(new QuestDaily(quest, 5));
        dailyRepository.save(new QuestDaily(quest, 3));
        dailyRepository.save(new QuestDaily(quest, 1000));
        dailyRepository.save(new QuestDaily(quest, 1));
        challengeRepository.save(new QuestChallenge(quest, 13,10000));
        challengeRepository.save(new QuestChallenge(quest, 15, 500));
        challengeRepository.save(new QuestChallenge(quest, 15, 10));
        challengeRepository.save(new QuestChallenge(quest, 4, 100)); //해금
        challengeRepository.save(new QuestChallenge(quest, 5, 40)); //가게마다 레벨 올리기
        challengeRepository.save(new QuestChallenge(quest, 5, 40));
        challengeRepository.save(new QuestChallenge(quest, 5, 40));
        challengeRepository.save(new QuestChallenge(quest, 5, 40));
        challengeRepository.save(new QuestChallenge(quest, 5, 40));
        challengeRepository.save(new QuestChallenge(quest, 10, 100));
        challengeRepository.save(new QuestChallenge(quest, 3, 2));
        challengeRepository.save(new QuestChallenge(quest, 8, 100000));
        challengeRepository.save(new QuestChallenge(quest, 3, 10));
        challengeRepository.save(new QuestChallenge(quest, 5, 10));
        challengeRepository.save(new QuestChallenge(quest, 5, 10));
        challengeRepository.save(new QuestChallenge(quest, 5, 1)); //가게 리모델링
        challengeRepository.save(new QuestChallenge(quest, 5, 1));
        challengeRepository.save(new QuestChallenge(quest, 5, 1));
        challengeRepository.save(new QuestChallenge(quest, 5, 1));
        challengeRepository.save(new QuestChallenge(quest, 5, 1));
        challengeRepository.save(new QuestChallenge(quest, 15, 500));
    }

    @Override
    public void initialClientData(User user, int questLv, Boolean isQuestConversationEnd, QuestDto dto){
        Quest quest = Quest.builder()
                .lv(questLv)
                .isEnd(isQuestConversationEnd)
                .dto(dto)
                .user(user)
                .build();
        QuestDaily daily = null;
        QuestChallenge challenge = null;

        questRepository.save(quest);
        for(int i = 0; i < dto.getIsMax_daily().size(); i++){
            daily = QuestDaily.builder()
                    .isMax(dto.getIsMax_daily().get(i))
                    .isReceived(dto.getIsReceived_daily().get(i))
                    .goal(dto.getGoal_daily().get(i))
                    .quest(quest).build();
            dailyRepository.save(daily);
        }
        for(int i = 0; i < dto.getIsMax_challenge().size(); i++){
            challenge = QuestChallenge.builder()
                    .isMax(dto.getIsMax_challenge().get(i))
                    .count(dto.getCount_challenge().get(i))
                    .limit(dto.getLimit_challenge().get(i))
                    .goal(dto.getGoal_challenge().get(i))
                    .quest(quest).build();
            challengeRepository.save(challenge);
        }
    }

    @Override
    public Map<String, Object> getQuestInfoDto(User user) {
        Map<String, Object> map = new HashMap<>();
        QuestDto result = new QuestDto();
        Quest quest = questRepository.findByUser(user);
        List<QuestDaily> dailyList = dailyRepository.findAllByQuest(quest);
        List<QuestChallenge> challengeList = challengeRepository.findAllByQuest(quest);

        List<Boolean> isMax_daily = new ArrayList<>();
        List<Boolean> isReceived_daily = new ArrayList<>();
        List<Integer> goal_daily = new ArrayList<>();
        List<Boolean> isMax_challenge = new ArrayList<>();
        List<Integer> count_challenge = new ArrayList<>();
        List<Integer> limit_challenge = new ArrayList<>();
        List<Integer> goal_challenge = new ArrayList<>();

        for(QuestDaily d : dailyList){
            isMax_daily.add(d.getIsMax());
            isReceived_daily.add(d.getIsReceived());
            goal_daily.add(d.getGoal());
        }
        for(QuestChallenge c : challengeList){
            isMax_challenge.add(c.getIsMax());
            count_challenge.add(c.getCount());
            limit_challenge.add(c.getLimit());
            goal_challenge.add(c.getGoal());
        }

        result.setIsMax_daily(isMax_daily);
        result.setIsReceived_daily(isReceived_daily);
        result.setGoal_daily(goal_daily);
        result.setClearAllQuestCount_daily(quest.getClearAll());
        result.setAttend_daily(quest.getAttend());
        result.setFurnitureUpgrade_daily(quest.getFurnitureUpgrade());
        result.setChunbaeLvUp_daily(quest.getChunbaeLvUp());
        result.setTouch_daily(quest.getTouchDaily());
        result.setCustomerTouch_daily(quest.getCustomerTouchDaily());

        result.setIsMax_challenge(isMax_challenge);
        result.setCount_challenge(count_challenge);
        result.setLimit_challenge(limit_challenge);
        result.setGoal_challenge(goal_challenge);
        result.setTouchCount_challenge(quest.getTouchChallenge());
        result.setFeverCount_challenge(quest.getFeverChallenge());
        result.setCatCount_challenge(quest.getCatdogChallenge());
        result.setCatdogBatchCount_challenge(quest.getCatdogBatchChallenge());
        result.setAnimalCount_challenge(quest.getAnimalChallenge());
        result.setGoodPoint_challenge(quest.getGoodPointChallenge());
        result.setGiveCount_challenge(quest.getGiveChallenge());
        map.put("result", result);
        map.put("questLv", quest.getQuestLv());
        map.put("isQuestConversationEnd", quest.getIsQuestConversationEnd());
        return map;
    }

    @Override
    public void storeQuestInfo(QuestDto dto, User user) {
        int i = 0;
        user.getQuest().update(dto);
        for(QuestDaily daily : user.getQuest().getDaily()){
            daily.update(dto, i);
            i++;
        }
        i = 0;
        for(QuestChallenge challenge : user.getQuest().getChallenge()){
            challenge.update(dto, i);
            i++;
        }
    }
}
