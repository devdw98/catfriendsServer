package com.wtw.catfriendsServer.api.domain.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CatDogPeople {
    private Long id;
    private String name;
    private Boolean own;
    private Integer level;
}
