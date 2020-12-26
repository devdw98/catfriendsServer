package com.wtw.catfriendsServer.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class UserMailDto {
    private Long id; //메일 아이디
    private String title;
    private String content;
    private List<RewardDto> rewards;
    private int rewardCount;
    private LocalDateTime receivedTime;
    private LocalDateTime readTime;
    private Boolean read;
    private Boolean delete;
    private String productCode;
}
