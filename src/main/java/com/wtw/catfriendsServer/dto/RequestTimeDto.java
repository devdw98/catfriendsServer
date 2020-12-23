package com.wtw.catfriendsServer.dto;

import com.wtw.catfriendsServer.domain.enums.RequestType;

import java.time.LocalDateTime;

public class RequestTimeDto {
    private int sibligIdx;
    private int sortingOrder;
    private String str = " ";
    private RequestType requestType;
    private LocalDateTime receivedTime;
    private LocalDateTime completeTime;
}
