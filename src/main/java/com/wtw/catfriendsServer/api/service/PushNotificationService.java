package com.wtw.catfriendsServer.api.service;

import com.wtw.catfriendsServer.api.domain.PushNotificationRequest;
import com.wtw.catfriendsServer.firebase.fcm.FCMService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class PushNotificationService {

    @Value("#{${app.notifications.defaults}}")
    private Map<String, String> defaults;

    private Logger log = LoggerFactory.getLogger(PushNotificationService.class);
    private FCMService fcmService;

    @Scheduled(initialDelay = 60000, fixedDelay = 60000)
    public void sendSamplePushNotification(){
        try{
            fcmService.sendMessageWithoutData(getSamplePushNotificationRequest());
        }catch(InterruptedException | ExecutionException e){
            log.error(e.getMessage());
        }
    }

    public void sendPushNotification(PushNotificationRequest req){
        try{
            fcmService.sendMessage(getSamplePayloadData(),req);
        }catch (InterruptedException | ExecutionException e){
            log.error(e.getMessage());
        }
    }

    public void sendPushNotificationWithoutData(PushNotificationRequest req){
        try{
            fcmService.sendMessageWithoutData(req);
        }catch (InterruptedException | ExecutionException e){
            log.error(e.getMessage());
        }
    }

    public void sendPushNotificationToToken(PushNotificationRequest req){
        try{
            fcmService.sendMessageToToken(req);
        }catch (InterruptedException | ExecutionException e){
            log.error(e.getMessage());
        }
    }

    private PushNotificationRequest getSamplePushNotificationRequest(){
        PushNotificationRequest req = new PushNotificationRequest()
                .builder().title(defaults.get("title"))
                .message(defaults.get("message"))
                .topic(defaults.get("topic")).build();
        return req;
    }

    private Map<String, String> getSamplePayloadData(){
        Map<String, String> pushData = new HashMap<>();
        pushData.put("messageId", defaults.get("payloadMessageId"));
        pushData.put("text", defaults.get("payloadData")+" "+ LocalDateTime.now());
        return pushData;
    }
}
