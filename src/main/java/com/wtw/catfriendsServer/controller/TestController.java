package com.wtw.catfriendsServer.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.wtw.catfriendsServer.dto.UserDto;
import com.wtw.catfriendsServer.firebase.AuthService;
import com.wtw.catfriendsServer.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final AuthService service;

    @GetMapping
    public ResponseEntity<?> getTestUrl(){
        Map<String, String> json = new HashMap<>();
        json.put("success","test");

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> postTestUrl(@RequestBody Map<String, String> req){
        Map<String, String> json = new HashMap<>();
        if(req.get("data") != null){
            json.put(req.get("data"), "success!");
        }else{
            json.put("no data", "fail!");
        }
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @PostMapping("/firebase")
    public void getFirebase(@RequestBody String uid) throws FirebaseAuthException {
    //    service.getUser(uid);
        try{
            if(service.getUser(uid) == null){
                System.out.println("nulltest");
            }else{

                System.out.println("successTest");
            }
        }catch (FirebaseAuthException e){
            log.error(e.getErrorCode());
        }
    }

    @PostMapping("/initial")
    public ResponseEntity<?> getInitial(@RequestBody String str){
        return new ResponseEntity<>(str, HttpStatus.OK);
    }


}
