package com.wtw.catfriendsServer.dto;

import com.wtw.catfriendsServer.domain.enums.RequestType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RequestTimeDto {
    private int sibligIdx;
    private int sortingOrder;
    private String str = " ";
    private RequestType requestType;
    private LocalDateTime receivedTime;
    private LocalDateTime completeTime;
}
