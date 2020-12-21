package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.dto.QuestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "QUEST_DAILY")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestDaily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DAILY_ID")
    private Long id;

    @Column(name = "IS_MAX")
    private Boolean isMax;

    @Column(name = "IS_RECEIVED")
    private Boolean isReceived;

    @Column(name = "GOAL")
    private Integer goal;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "QUEST_ID")
    private Quest quest;

    public QuestDaily(Quest quest, Integer goal){
        this.isMax = false;
        this.isReceived = false;
        this.goal = goal;
        this.quest = quest;
    }

    @Builder
    public QuestDaily(Boolean isMax, Boolean isReceived, Integer goal, Quest quest){
        this.isMax = isMax;
        this.isReceived = isReceived;
        this.goal = goal;
        this.quest = quest;
    }

    public void update(QuestDto dto, int index){
        this.isMax = dto.getIsMax_daily().get(index);
        this.isReceived = dto.getIsReceived_daily().get(index);
    }
}
