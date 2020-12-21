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
    private int attend;

    @Column(name = "DAILY_FURNITURE_UPGRADE")
    private int furnitureUpgrade;

    @Column(name = "DAILY_CHUNBAE_LvUp")
    private int chunbaeLvUp;

    @Column(name = "DAILY_TOUCH")
    private int touchDaily;

    @Column(name = "DAILY_CUSTOMER_TOUCH")
    private int customerTouchDaily;

    @Column(name = "CHALLENGE_TOUCH")
    private int touchChallenge;

    @Column(name = "CHALLENGE_FEVER")
    private int feverChallenge;

    @Column(name = "CHALLENGE_CATDOG")
    private int catdogChallenge;

    @Column(name = "CHALLENGE_CATDOG_BATCH")
    private int catdogBatchChallenge;

    @Column(name = "CHALLENGE_ANIMAL")
    private int animalChallenge;

    @Column(name = "CHALLENGE_GOODPOINT")
    private int goodPointChallenge;

    @Column(name = "CHALLENGE_GIVE")
    private int giveChallenge;

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
        this.attend = 1;
        this.furnitureUpgrade = 0;
        this.chunbaeLvUp = 0;
        this.touchDaily = 0;
        this.customerTouchDaily = 0;
        this.touchChallenge = 0;
        this.feverChallenge = 0;
        this.catdogChallenge = 0;
        this.catdogBatchChallenge = 0;
        this.animalChallenge = 0;
        this.goodPointChallenge = 0;
        this.giveChallenge = 0;
        this.user = user;
    }

    @Builder
    public Quest(User user, int lv, boolean isEnd, QuestDto dto){
        this.questLv = lv;
        this.isCompleteQuest = isEnd;
        this.clearAll = dto.getClearAllQuestCount_daily();
        this.attend = dto.getAttend_daily();
        this.furnitureUpgrade = dto.getFurnitureUpgrade_daily();
        this.chunbaeLvUp = dto.getChunbaeLvUp_daily();
        this.touchDaily = dto.getTouch_daily();
        this.customerTouchDaily = dto.getCustomerTouch_daily();
        this.touchChallenge = dto.getTouchCount_challenge();
        this.feverChallenge = dto.getFeverCount_challenge();
        this.catdogChallenge = dto.getCatdogCount_challenge();
        this.catdogBatchChallenge = dto.getCatdogBatchCount_challenge();
        this.animalChallenge = dto.getAnimalCount_challenge();
        this.goodPointChallenge = dto.getGoodPoint_challenge();
        this.giveChallenge = dto.getGiveCount_challenge();
        this.user = user;

    }

    public void update(QuestDto dto){
        this.clearAll = dto.getClearAllQuestCount_daily();
        this.attend = dto.getAttend_daily();
        this.furnitureUpgrade = dto.getFurnitureUpgrade_daily();
        this.chunbaeLvUp = dto.getChunbaeLvUp_daily();
        this.touchDaily = dto.getTouch_daily();
        this.customerTouchDaily = dto.getCustomerTouch_daily();
        this.touchChallenge = dto.getTouchCount_challenge();
        this.feverChallenge = dto.getFeverCount_challenge();
        this.catdogChallenge = dto.getCatdogCount_challenge();
        this.catdogBatchChallenge = dto.getCatdogBatchCount_challenge();
        this.animalChallenge = dto.getAnimalCount_challenge();
        this.goodPointChallenge = dto.getGoodPoint_challenge();
        this.giveChallenge = dto.getGiveCount_challenge();
    }
}
