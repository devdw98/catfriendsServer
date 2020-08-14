package com.wtw.catfriendsServer.firebase.fcm;

import com.google.firebase.messaging.*;

import java.util.*;

public class FirebaseFcmService {


    //특정 기기에 메세지 전송
    public Map<?,?> sendMessageOneDevice(String token, Map<String, String> msg) throws FirebaseMessagingException {
        Map<String, String> result = new HashMap<>();
        Message message = Message.builder()
                .putAllData(msg)
                .setToken(token)
                .build();
        String response = FirebaseMessaging.getInstance().send(message);
        result.put("success",response);
        return result;
    }

    //여러 기기에 메세지 전송 (+실패 시 토큰 반환)
    public Map<?,?> sendMessageDevices(List<String> tokenList, Map<String, String> msg) throws FirebaseMessagingException {
        Map<String, String> result = new HashMap<>();
        MulticastMessage message = MulticastMessage.builder()
                .putAllData(msg)
                .addAllTokens(tokenList)
                .build();
        BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
        Integer successCount = response.getSuccessCount();
        Integer failureCount = response.getFailureCount();

        if(failureCount > 0){
            List<SendResponse> responses = response.getResponses();
            List<String> failedTokens = new ArrayList<>();
            for(int i=0;i<responses.size();i++){
                if(!responses.get(i).isSuccessful()){
                    String token = tokenList.get(i);
                    failedTokens.add(token);
                    result.put("failureToken "+i,token);
                }
            }
            result.put("failure","{}");
            result.put("failureCount",failureCount.toString());
        }else{
            result.put("success","{}");
            result.put("successCount",successCount.toString());
        }
        return result;
    }

    //일괄 메세지 전송
//    public Map<?,?> sendMessageAllDevices(List<String> tokenList, List<Message> msg){
//        Map<String, String> result = new HashMap<>();
//        List<Message> messages = Arrays.asList();
//        for(int i=0;i<msg.size();i++){
//            messages.add(Message.builder())
//        }
//
//        return result;
//    }

}
