package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.dto.QuestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "QUEST_CHALLENGE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestChallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHALLENGE_ID")
    private Long id;

    @Column(name = "IS_MAX")
    private Boolean isMax;

    @Column(name = "COUNT_")
    private Integer count;

    @Column(name = "LIMIT_")
    private Integer limit;

    @Column(name = "GOAL_")
    private Integer goal;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "QUEST_ID")
    private Quest quest;

    public QuestChallenge(Quest quest, Integer limit, Integer goal) {
        this.quest = quest;
        this.limit = limit;
        this.goal = goal;
        this.isMax = false;
        this.count = 0;
    }

    @Builder
    public QuestChallenge(Boolean isMax, Integer count, Integer limit, Integer goal, Quest quest){
        this.isMax = isMax;
        this.count = count;
        this.limit = limit;
        this.goal = goal;
        this.quest = quest;
    }

    public void update(QuestDto dto, int index){
        this.isMax = dto.getIsMax_challenge().get(index);
        this.count = dto.getCount_challenge().get(index);
    }
}
