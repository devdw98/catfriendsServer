package com.wtw.catfriendsServer.controller;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.MailListDto;
import com.wtw.catfriendsServer.service.MailService;
import com.wtw.catfriendsServer.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MailController {

    public static final String humbleBox = "100";
    public static final String paperBox1 = "101";
    public static final String paperBox10 = "102";
    public static final String deliveryBox1 = "103";
    public static final String deliveryBox10 = "104";
    public static final String colorfulBox1 = "105";
    public static final String colorfulBox10 = "106";

    public static final String buf1 = "053"; //피버 게이지 증가율 +4%
    public static final String buf2 = "054"; //모든 수익 2배
    public static final String buf3 = "055"; //피버 지속 시간 +3초

    private final MailService mailService;
    private final UserService userService;

    @PostMapping("/shop/{productCode}") //친구들 상품 사기
    public ResponseEntity<?> buyProductFriends(@RequestHeader("uid") String uid, @PathVariable("productCode") String productCode){
        Map<String, Boolean> map = new HashMap<>();
        User user = userService.getUserForMails(uid);
        map.put("check",mailService.getPaidProduct(user, productCode));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/mail")
    public ResponseEntity<?> getUserMails(@RequestHeader("uid") String uid){
        User user = userService.getUserForMails(uid);
        MailListDto dto = MailListDto.builder()
        .mailList(mailService.getUserMailListExcludingDeleteMail(user)).build();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/mail")
    public ResponseEntity<?> putUserMails(@RequestHeader("uid") String uid, @RequestBody MailListDto dto){
        User user = userService.getUserForMails(uid);
        mailService.storeUserMailData(dto.getMailList(), user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
