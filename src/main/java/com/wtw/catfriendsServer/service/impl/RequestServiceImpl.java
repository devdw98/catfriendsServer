package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.user.Request;
import com.wtw.catfriendsServer.domain.user.UserRequest;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.RequestTimeDto;
import com.wtw.catfriendsServer.repository.RequestRepository;
import com.wtw.catfriendsServer.repository.UserRequestRepository;
import com.wtw.catfriendsServer.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final UserRequestRepository userRequestRepository;

    @Override
    public void initialClientData(User user, Map<String, Integer> requestDict, List<RequestTimeDto> timeDto) {
        int i = 0;
        UserRequest result;
        List<Request> requests = requestRepository.findAll();
        List<Request> clients = new ArrayList<>();
        for(Request request : requests){
            if(requestDict.containsKey(request.getContent())){
                clients.add(request);
            }
        }
        System.out.println(clients.size());

        for(RequestTimeDto dto : timeDto){
            result = UserRequest.builder()
                    .sibligIdx(dto.getSibligIdx())
                    .sortingOrder(dto.getSortingOrder())
                    .str(dto.getStr())
                    .type(dto.getRequestType())
                    .receivedTime(dto.getReceivedTime())
                    .completeTime(dto.getCompleteTime())
                    .user(user)
                    .request(clients.get(i))
                    .build();
            userRequestRepository.save(result);
            i++;
        }

    }

    @Override
    public Map<String, Integer> getRequestDict(User user){
        Map<String, Integer> result = new LinkedHashMap<>();
        List<Request> requests = new ArrayList<>();
        List<UserRequest> userReqs = userRequestRepository.findAllByUser(user);
        for(UserRequest userReq : userReqs){
            requests.add(userReq.getRequest());
        }
        for(Request req : requests){
            result.put(req.getContent(), req.getStore());
        }
        return result;
    }

    public List<RequestTimeDto> getRequestTimes(User user){
        List<RequestTimeDto> result = new ArrayList<>();
        List<UserRequest> requests = userRequestRepository.findAllByUser(user);
        for(UserRequest req : requests){
            result.add(req.toDto());
        }
        return result;
    }
}
