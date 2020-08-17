package com.wtw.catfriendsServer.api.controller;

import com.wtw.catfriendsServer.api.service.PushNotificationService;
import com.wtw.catfriendsServer.firebase.model.PushNotificationRequest;
import com.wtw.catfriendsServer.firebase.model.PushNotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class PushNotificationController {

    private PushNotificationService pushNotificationService;

    @GetMapping
    public ResponseEntity sendSampleNotification(){
        pushNotificationService.sendSamplePushNotification();
        PushNotificationResponse resp = PushNotificationResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Notification has been sent.").build();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/topic")
    public ResponseEntity sendNotification(@RequestBody PushNotificationRequest req){
        pushNotificationService.sendPushNotificationWithoutData(req);
        PushNotificationResponse resp = PushNotificationResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Notification has been sent.").build();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/data")
    public ResponseEntity sendDataNotification(@RequestBody PushNotificationRequest req){
        pushNotificationService.sendPushNotification(req);
        PushNotificationResponse resp = PushNotificationResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Notification has been sent.").build();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest req){
        pushNotificationService.sendPushNotificationToToken(req);
        PushNotificationResponse resp = PushNotificationResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Notification has been sent.").build();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
