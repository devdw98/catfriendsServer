package com.wtw.catfriendsServer.controller;

import com.wtw.catfriendsServer.domain.enums.QuestType;
import com.wtw.catfriendsServer.dto.MailDto;
import com.wtw.catfriendsServer.dto.QuestDto;
import com.wtw.catfriendsServer.dto.StoreDto;
import com.wtw.catfriendsServer.service.MailService;
import com.wtw.catfriendsServer.service.QuestService;
import com.wtw.catfriendsServer.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/base")
public class BaseController {

    private final QuestService questService;
    private final MailService mailService;
    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<?> get(){
        Map<String, List<?>> map = new HashMap<>();

   //     List<MailDto> mailList = mailService.getMailList();

    //    map.put("mails", mailList);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
