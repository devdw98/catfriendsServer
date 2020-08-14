package com.wtw.catfriendsServer.firebase.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.GoogleCredentials;
import com.wtw.catfriendsServer.etc.YamlPropertySourceFactory;
import com.wtw.catfriendsServer.firebase.config.FirebaseConfig;
import com.wtw.catfriendsServer.firebase.fcm.FirebaseFcmService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/firebase")
//@PropertySource(value = "classpath:firebase.yml", factory = YamlPropertySourceFactory.class)
//@ConfigurationProperties(prefix = "firebase")
public class FirebaseController {
    private final FirebaseConfig config;
    private final FirebaseFcmService fcmService;
//    @GetMapping(value="/fcm", produces = "text/plain;charset=utf-8")
//    public ResponseEntity<?> fcm() throws Exception{
//        Map<?, ?> result = new HashMap<>();
//        try{
//            String token = "eF_vvq70Ksw:APA91bHacwITMTvxRkhHFAem7gzTC1cbjPnz2BWTpgpOLgjgKlUMKHm9MdKu8hBzi61GLNBWp_mVrAC2N1TO75AJMH2f-H3_vz7HUpTxH3ehvPcyqyeVzlTmEksRAVPjztSLBjHN3HKx";
//            Map<String, String> msg = new HashMap<>();
//            msg.put("message","test1");
//            config.initial();
//            result= fcmService.sendMessageOneDevice(token, msg);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(result, HttpStatus.OK);
//    }

    @GetMapping(value="/fcmTest", produces="text/plain;charset=UTF-8")
    public void fcmTest() throws Exception {
        try {

            String path = "C:/**..**/catfriendsServer/src/main/resources/key/catfriends-91f48-firebase-adminsdk-4ugvl-cbdb82fe50.json";
            String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
            String[] SCOPES = { MESSAGING_SCOPE };

            GoogleCredentials googleCredentials = GoogleCredentials
                    .fromStream(new FileInputStream(path))
                    .createScoped(Arrays.asList(SCOPES));
//            googleCredentials.refreshToken();

            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type" , MediaType.APPLICATION_JSON_VALUE);
            headers.add("Authorization", "Bearer " + googleCredentials.getAccessToken());

            JSONObject notification = new JSONObject();
            notification.put("body", "TEST");
            notification.put("title", "TEST");

            JSONObject message = new JSONObject();
            message.put("token", "eF_vvq70Ksw:APA91bHacwITMTvxRkhHFAem7gzTC1cbjPnz2BWTpgpOLgjgKlUMKHm9MdKu8hBzi61GLNBWp_mVrAC2N1TO75AJMH2f-H3_vz7HUpTxH3ehvPcyqyeVzlTmEksRAVPjztSLBjHN3HKx");
            message.put("notification", notification);

            JSONObject jsonParams = new JSONObject();
            jsonParams.put("message", message);

            HttpEntity<JSONObject> httpEntity = new HttpEntity<JSONObject>(jsonParams, headers);
            RestTemplate rt = new RestTemplate();

            ResponseEntity<String> res = rt.exchange("https://fcm.googleapis.com/v1/projects/catfriends-91f48/messages:send"
                    , HttpMethod.POST
                    , httpEntity
                    , String.class);

            if (res.getStatusCode() != HttpStatus.OK) {
//                log.debug("FCM-Exception");
//                log.debug(res.getStatusCode().toString());
//                log.debug(res.getHeaders().toString());
//                log.debug(res.getBody().toString());
                System.out.println("FCM-Exeption");
                System.out.println(res.getStatusCode().toString());
                System.out.println(res.getHeaders().toString());
                System.out.println(res.getBody().toLowerCase());
            } else {
//                log.debug(res.getStatusCode().toString());
//                log.debug(res.getHeaders().toString());
//                log.debug(res.getBody().toLowerCase());
                System.out.println(res.getStatusCode().toString());
                System.out.println(res.getHeaders().toString());
                System.out.println(res.getBody().toLowerCase());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
