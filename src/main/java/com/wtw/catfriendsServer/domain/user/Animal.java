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

@Entity
@Table(name = "ANIMAL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Animal {
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
    private int sortingOrder;

    @Column(name = "TYPE")
    @Enumerated
    private PcType type;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public Animal(User user, PcType type){
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
                .type(getType())
                .build();
        return dto;
    }

    @Builder
    public Animal(int id, int level, Boolean isRetention, int sortingOrder, PcType type, User user) {
        this.userAnimalId = id;
        this.level = level;
        this.isRetention = isRetention;
        this.sortingOrder = sortingOrder;
        this.type = type;
        this.user = user;
    }

    public void update(AnimalDto dto){
        this.isRetention = dto.getIsRetention();
        this.level = dto.getLevel();
        this.sortingOrder = dto.getSortingOrder();
    }
}
