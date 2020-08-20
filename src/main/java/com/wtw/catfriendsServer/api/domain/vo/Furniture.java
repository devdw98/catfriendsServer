package com.wtw.catfriendsServer.api.domain.vo;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Furniture {
    private Long id;
    private String name;
    private FurniturePartParameter part;
    private int level;
}

