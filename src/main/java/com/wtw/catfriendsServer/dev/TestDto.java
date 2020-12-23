package com.wtw.catfriendsServer.dev;

import com.wtw.catfriendsServer.dto.RequestTimeDto;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class TestDto {
    private Map<String, Integer> reqiestDict = new LinkedHashMap<>();
    private List<RequestTimeDto> requestTimes;
    private int requestCount;
}
