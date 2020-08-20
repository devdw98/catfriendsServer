package com.wtw.catfriendsServer.api.domain.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AbandonAnimal {
    private Long id;
    private Boolean own;
    private Integer level;
}
