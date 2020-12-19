package com.wtw.catfriendsServer.dto;

import com.wtw.catfriendsServer.domain.enums.StoreType;
import com.wtw.catfriendsServer.domain.user.CatDog;
import com.wtw.catfriendsServer.domain.user.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatDogDto {
    private String name;
    private int level;
    private Boolean isRetention;
    private StoreType batchLocation;

    public CatDog toEntity(User user){
        CatDog entity = CatDog.builder()
                .name(name)
                .level(level)
                .isRetention(isRetention)
                .batchLocation(batchLocation)
                .user(user).build();
        return entity;
    }
}
