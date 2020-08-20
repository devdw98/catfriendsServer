package com.wtw.catfriendsServer.api.domain.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Challenge {
    private Long id;
    private String title;
    private String content;
    private Integer reward;
    private Boolean achievement;
}
