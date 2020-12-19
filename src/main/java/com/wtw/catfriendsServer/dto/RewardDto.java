package com.wtw.catfriendsServer.dto;

import com.wtw.catfriendsServer.domain.enums.RewardType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardDto {
    private RewardType type;
    private Long degree;
}
