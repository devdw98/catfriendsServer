package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.Request;
import com.wtw.catfriendsServer.domain.enums.RequestType;
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
    public void initialClientData(User user, Map<String, RequestType> requestDict, List<RequestTimeDto> timeDto) {
        int i = 0;
        UserRequest result;
        RequestTimeDto dto;
        List<Request> requests = requestRepository.findAll();
        List<Request> clients = new ArrayList<>();
        List<RequestType> dictTypes = new ArrayList<>();
        for(Request request : requests){
            if(requestDict.containsKey(request.getContent())){
                clients.add(request);
                dictTypes.add(requestDict.get(request.getContent()));
            }
        }
        System.out.println(clients.size());
        System.out.println("timeDto:"+timeDto.size());

//        for(i = 0; i < timeDto.size(); i++){
//            dto = timeDto.get(i);
//            result = UserRequest.builder()
//                    .sibligIdx(dto.getSibligIdx())
//                    .sortingOrder(dto.getSortingOrder())
//                    .str(dto.getStr())
//                    .type(dto.getRequestType())
//                    .status(dictTypes.get(i))
//                    .receivedTime(dto.getReceivedTime())
//                    .completeTime(dto.getCompleteTime())
//                    .user(user)
//                    .request(clients.get(i))
//                    .build();
//            userRequestRepository.save(result);
//        }

    }

    @Override
    public Map<String, RequestType> getRequestDict(User user){
        Map<String, RequestType> result = new LinkedHashMap<>();
        List<UserRequest> userReqs = userRequestRepository.findAllByUser(user);
        for(UserRequest userReq : userReqs){
            result.put(userReq.getRequest().getContent(), userReq.getStatus());
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

    public void storeRequests(List<RequestTimeDto> dtos, Map<String, RequestType> map, User user){
        int i = 0;
        for(UserRequest userRequest : user.getUserRequests()){
            userRequest.update(dtos.get(i), map.get(userRequest.getRequest().getContent()));
            i++;
        }
    }
}
