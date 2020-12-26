package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.enums.PcType;
import com.wtw.catfriendsServer.domain.enums.StoreType;
import com.wtw.catfriendsServer.dto.AnimalDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ANIMAL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMAL_ID")
    private Long id;

    @Column(name = "USER_ANIMAL_ID")
    private int userAnimalId;

    @Column(name = "LEVEL")
    private int level;

    @Column(name = "IS_RETENTION")
    private Boolean isRetention;

    @Column(name = "SORTING_ORDER")
    private int sortingOrder; //동물 구별

    @Column(name = "RETENTION_EFFECT")
    private String retentionEffect;

    @Column(name = "TYPE")
    @Enumerated
    private PcType type;

    @Column(name = "CLICK_TIME")
    private LocalDateTime clickTime;

    @Column(name = "USED_ANIMAL")
    private int usedAnimal;

    @Column(name = "STEP_OF_SELL")
    private int stepOfSell;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public UserAnimal(User user, PcType type){
        this.level = 1;
        this.isRetention = false;
        this.sortingOrder = -1;
        this.user = user;
        this.type = type;
    }

    public AnimalDto toDto(){
        AnimalDto dto = AnimalDto.builder()
        //        .animalId(getId())
                .level(getLevel())
                .isRetention(getIsRetention())
                .sortingOrder(getSortingOrder())
                .retentionEffect(getRetentionEffect())
                .type(getType())
                .build();
        return dto;
    }

    @Builder
    public UserAnimal(int id, int level, Boolean isRetention, int sortingOrder,
                      String retentionEffect , PcType type,LocalDateTime clickTime,
                      int usedAnimal, int stepOfSell, User user) {
        this.userAnimalId = id;
        this.level = level;
        this.isRetention = isRetention;
        this.sortingOrder = sortingOrder;
        this.retentionEffect = retentionEffect;
        this.type = type;
        this.clickTime = clickTime;
        this.usedAnimal = usedAnimal;
        this.stepOfSell = stepOfSell;
        this.user = user;
    }

    public void update(AnimalDto dto, LocalDateTime clickTime,int usedAnimal, int stepOfSell){
        this.isRetention = dto.getIsRetention();
        this.level = dto.getLevel();
        this.sortingOrder = dto.getSortingOrder();
        this.retentionEffect = dto.getRetentionEffect();
        this.type = dto.getType();
        this.clickTime = clickTime;
        this.usedAnimal = usedAnimal;
        this.stepOfSell = stepOfSell;
    }
}
