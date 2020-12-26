package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wtw.catfriendsServer.dto.QuestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QUEST")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUEST_ID")
    private Long id;

    @Column(name = "QUEST_LV")
    private int questLv;

    @Column(name = "IS_COMPLETE_QUEST")
    private Boolean isCompleteQuest;

    @Column(name = "DAILY_CLEAR_ALL")
    private int clearAll;

    @Column(name = "DAILY_ATTEND")
    private int attendDaily;

    @Column(name = "DAILY_ROAMER")
    private int roamerTouchDaily;

    @Column(name = "DAILY_NYANGNYALAND")
    private int nyangnaLandTouchDaily;

    @Column(name = "DAILY_TOUCH")
    private int touchDaily;

    @Column(name = "DAILY_CUSTOMER_TOUCH")
    private int customerTouchDaily;

    @Column(name = "CHALLENGE_TOUCH")
    private int touchChallenge;

    @Column(name = "CHALLENGE_FEVER")
    private int feverChallenge;

    @Column(name = "CHALLENGE_UNLOCK_STORE")
    private int unlockStoreChallenge;

    @Column(name = "CHALLENGE_ANIMAL_LV")
    private int animalLvChallenge;

    @Column(name = "CHALLENGE_ABSENT_MONEY")
    private int absentMoneyChallenge;

    @Column(name = "CHALLENGE_CATDOG_BATCH")
    private int catdogBatchChallenge;

    @Column(name = "CHALLENGE_GOODPOINT")
    private int goodPointChallenge;

    @Column(name = "CHALLENGE_GIVE")
    private int giveChallenge;

    @Column(name = "CHALLENGE_ROAMER_TOUCH")
    private int roamerTouchChallenge;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "quest")
    @JsonManagedReference
    private List<QuestDaily> daily;

    @OneToMany(mappedBy = "quest")
    @JsonManagedReference
    private List<QuestChallenge> challenge;

    public Quest(User user){
        this.questLv = 1;
        this.isCompleteQuest = false;
        this.clearAll = 0;
        this.attendDaily = 1;
        this.touchDaily = 0;
        this.customerTouchDaily = 0;
        this.touchChallenge = 0;
        this.feverChallenge = 0;
        this.animalLvChallenge = 0;
        this.catdogBatchChallenge = 0;
        this.goodPointChallenge = 0;
        this.giveChallenge = 0;
        this.user = user;
    }

    @Builder
    public Quest(User user, int lv, boolean isEnd, QuestDto dto){
        this.questLv = lv;
        this.isCompleteQuest = isEnd;
        this.clearAll = dto.getClearAllQuestCount_daily();
        this.attendDaily = dto.getAttend_daily();
        this.roamerTouchDaily = dto.getRoamerTouch_daily();
        this.nyangnaLandTouchDaily = dto.getNyangnaland_daily();
        this.touchDaily = dto.getTouch_daily();
        this.customerTouchDaily = dto.getCustomerTouch_daily();
        this.touchChallenge = dto.getTouchCount_challenge();
        this.feverChallenge = dto.getFeverCount_challenge();
        this.unlockStoreChallenge = dto.getUnlockStore_challenge();
        this.animalLvChallenge = dto.getAnimalLvCount_challenge();
        this.absentMoneyChallenge = dto.getAbsentMoney_challenge();
        this.catdogBatchChallenge = dto.getCatdogBatchCount_challenge();

        this.goodPointChallenge = dto.getGoodPoint_challenge();
        this.giveChallenge = dto.getGiveCount_challenge();
        this.roamerTouchChallenge = dto.getRoamerTouch_challenge();
        this.user = user;

    }

    public void update(int lv,Boolean isComplete,QuestDto dto){
        this.questLv = lv;
        this.isCompleteQuest = isComplete;
        this.clearAll = dto.getClearAllQuestCount_daily();
        this.attendDaily = dto.getAttend_daily();
        this.roamerTouchDaily = dto.getRoamerTouch_daily();
        this.nyangnaLandTouchDaily = dto.getNyangnaland_daily();

        this.touchDaily = dto.getTouch_daily();
        this.customerTouchDaily = dto.getCustomerTouch_daily();
        this.touchChallenge = dto.getTouchCount_challenge();
        this.feverChallenge = dto.getFeverCount_challenge();
        this.unlockStoreChallenge = dto.getUnlockStore_challenge();
        this.animalLvChallenge = dto.getAnimalLvCount_challenge();
        this.absentMoneyChallenge = dto.getAbsentMoney_challenge();
        this.catdogBatchChallenge = dto.getCatdogBatchCount_challenge();
        this.goodPointChallenge = dto.getGoodPoint_challenge();
        this.giveChallenge = dto.getGiveCount_challenge();
        this.roamerTouchChallenge = dto.getRoamerTouch_challenge();
    }
}
