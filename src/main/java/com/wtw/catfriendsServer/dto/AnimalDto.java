package com.wtw.catfriendsServer.dto;


import com.wtw.catfriendsServer.domain.enums.PcType;
import com.wtw.catfriendsServer.domain.enums.StoreType;
import com.wtw.catfriendsServer.domain.user.Animal;
import com.wtw.catfriendsServer.domain.user.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AnimalDto {
    private int level;
    private Boolean isRetention;
    private int sortingOrder;
    private PcType type;
}
