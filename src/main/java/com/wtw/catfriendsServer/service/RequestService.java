package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.RequestTimeDto;

import java.util.List;
import java.util.Map;

public interface RequestService {
    public void initialClientData(User user, Map<String, Integer> requestDict, List<RequestTimeDto> timeDto);
    public Map<String, Integer> getRequestDict(User user);
    public List<RequestTimeDto> getRequestTimes(User user);
}
