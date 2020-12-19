package com.wtw.catfriendsServer.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MailDto {
    private String title;
    private String content;
    private List<RewardDto> rewards;
    private int rewardCount;
}
