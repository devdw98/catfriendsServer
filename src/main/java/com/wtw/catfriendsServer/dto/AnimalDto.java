package com.wtw.catfriendsServer.dto;


import com.wtw.catfriendsServer.domain.enums.StoreType;
import com.wtw.catfriendsServer.domain.user.Animal;
import com.wtw.catfriendsServer.domain.user.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AnimalDto {
    private Long animalId;
    private int level;
    private Boolean isRetention;
    private int sortingOrder;
    private StoreType skill;

    public Animal toEntity(User user){
        Animal entity = Animal.builder()
                .id(animalId)
                .level(level)
                .isRetention(isRetention)
                .sortingOrder(sortingOrder)
                .skill(skill)
                .user(user)
                .build();
        return entity;
    }
}
