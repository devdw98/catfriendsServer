package com.wtw.catfriendsServer.firebase.fcm;

import com.google.firebase.messaging.*;
import com.wtw.catfriendsServer.api.domain.PushNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FCMService {
    private Logger log = LoggerFactory.getLogger(FCMService.class);

    public void sendMessage(Map<String, String> data, PushNotificationRequest req) throws InterruptedException, ExecutionException{
        Message message = getPreconfiguredMessageWithData(data, req);
        String response = sendAndGetResponse(message);
        log.info("Send message with Data. Topic: "+req.getTopic()+", "+response);
    }

    public void sendMessageWithoutData(PushNotificationRequest req) throws InterruptedException, ExecutionException{
        Message message = getPreconfiguredMessageWithoutData(req);
        String response = sendAndGetResponse(message);
        log.info("Send message with Data. Topic: "+req.getTopic()+", "+response);
    }

    public void sendMessageToToken(PushNotificationRequest req) throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessageToToken(req);
        String response = sendAndGetResponse(message);
        log.info("Send message to Token. Device Token: "+req.getToken()+", "+response);
    }

    //PreconfigurationMessage
    private String sendAndGetResponse(Message msg) throws InterruptedException, ExecutionException {
        return FirebaseMessaging.getInstance().sendAsync(msg).get();
    }

    private Message getPreconfiguredMessageWithData(Map<String, String> data, PushNotificationRequest req){
        return getPreconfiguredMessageBuilder(req).putAllData(data).setTopic(req.getTopic()).build();
    }

    private Message getPreconfiguredMessageWithoutData(PushNotificationRequest req){
        return getPreconfiguredMessageBuilder(req).setTopic(req.getTopic()).build();
    }

    private Message getPreconfiguredMessageToToken(PushNotificationRequest req){
        return getPreconfiguredMessageBuilder(req).setToken(req.getToken()).build();
    }

    private Message.Builder getPreconfiguredMessageBuilder(PushNotificationRequest req){
        // ios를 다루지 않으므로 필요 없는 코드들 주석처리
        AndroidConfig androidConfig = getAndroidConfig(req.getTopic());
//        ApnsConfig apnsConfig = getApnsConfig(req.getTopic());
        return Message.builder()
                .setAndroidConfig(androidConfig)
//                .setApnsConfig(apnsConfig)
                .setNotification(
                        Notification.builder()
                                .setTitle(req.getTitle())
                                .setBody(req.getMessage()).build());
    }

    private AndroidConfig getAndroidConfig(String topic){
        return AndroidConfig.builder()
                .setTtl(Duration.ofMinutes(2).toMillis())
                .setCollapseKey(topic)
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder()
                .setSound(NotificationParameter.SOUND.getValue())
                .setColor(NotificationParameter.COLOR.getValue())
                .setTag(topic).build()).build();
    }

    private ApnsConfig getApnsConfig(String topic){ //ios 인증
        return ApnsConfig.builder()
                .setAps(Aps.builder().setCategory(topic).setThreadId(topic).build())
                .build();
    }

}
