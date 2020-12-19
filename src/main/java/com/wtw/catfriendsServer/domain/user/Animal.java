package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.enums.StoreType;
import com.wtw.catfriendsServer.dto.AnimalDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ANIMAL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMAL_ID")
    private Long id;

    @Column(name = "LEVEL")
    private int level;

    @Column(name = "IS_RETENTION")
    private Boolean isRetention;

    @Column(name = "SORTING_ORDER")
    private int sortingOrder;

    @Column(name = "SKILL")
    @Enumerated
    private StoreType skill;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public Animal(User user, StoreType skill){
        this.level = 1;
        this.isRetention = false;
        this.sortingOrder = -1;
        this.user = user;
        this.skill = skill;
    }

    public AnimalDto toDto(){
        AnimalDto dto = AnimalDto.builder()
                .animalId(getId())
                .level(getLevel())
                .isRetention(getIsRetention())
                .sortingOrder(getSortingOrder())
                .skill(getSkill())
                .build();
        return dto;
    }

    @Builder
    public Animal(Long id, int level, Boolean isRetention, int sortingOrder, StoreType skill, User user) {
        this.id = id;
        this.level = level;
        this.isRetention = isRetention;
        this.sortingOrder = sortingOrder;
        this.skill = skill;
        this.user = user;
    }

    public void update(AnimalDto dto){
        this.isRetention = dto.getIsRetention();
        this.level = dto.getLevel();
        this.sortingOrder = dto.getSortingOrder();
    }
}
