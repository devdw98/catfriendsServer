package com.wtw.catfriendsServer.dto;


import com.wtw.catfriendsServer.domain.enums.PcType;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AnimalDto {
    private int sortingOrder;
    private Boolean isRetention;
    private int level;
//    private T data;
    private String retentionEffect;
    private PcType type;
}
