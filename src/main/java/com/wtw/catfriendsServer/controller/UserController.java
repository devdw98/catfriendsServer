package com.wtw.catfriendsServer.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.wtw.catfriendsServer.domain.user.User;

import com.wtw.catfriendsServer.dto.UserDto;
import com.wtw.catfriendsServer.firebase.AuthService;
import com.wtw.catfriendsServer.service.MailService;
import com.wtw.catfriendsServer.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<?> signIn(@RequestHeader("uid") String uid){ //중복체크하기
        String firebase;
        UserDto result = null;
        try{
            firebase = authService.getUser(uid).getUid();
            if(!userService.checkDuplicateUser(firebase))
                result = userService.initial(firebase);
            else
                result = userService.getUser(uid);
            
        }catch (FirebaseAuthException e){
            log.error(e.getErrorCode());
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


//    public ResponseEntity<?> getUser(@RequestHeader("uid") String uid){
//        return new ResponseEntity<>(userService.getUser(uid), HttpStatus.OK);
//    }

    @PutMapping
    public ResponseEntity<?> storeUser(@RequestHeader("uid") String uid, @RequestBody UserDto dto){
        UserDto result = userService.storeUser(uid, dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @DeleteMapping
//    public ResponseEntity<?> destroy(@RequestBody String uid){
//
//    }

/*    @PostMapping
    public ResponseEntity<?> register(@RequestBody String uid){
        UserDto result = userService.initialDto(uid);
        if(result != null){
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<?> login(@PathVariable("uid") String uid){

        UserDto result = userService.getUser(uid);
        if(result != null){
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<?> store(@PathVariable("uid") String uid, @RequestBody UserDto req){
        UserDto result = userService.storeUserData(req);
        if(result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/test/{uid}")
    public ResponseEntity<?> test(@PathVariable("uid") String uid, @RequestBody String req) throws JsonProcessingException {
        User user = userService.initial(uid);
        String json = req.split(":",2)[1];
        ObjectMapper mapper = new ObjectMapper();

        List<UserMailDto> dto = mapper.readValue(json, new TypeReference<List<UserMailDto>>() {});

        if(mailService.storeUserMailData(user, dto))
            return new ResponseEntity<>(mailService.getUserMailListExcludingDeleteMail(user),HttpStatus.OK);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/test/{uid}")
    public ResponseEntity<?> mailInitial(@PathVariable("uid") String uid){
        User user = userService.initial(uid);
        mailService.updateUserMailListDeleteInitial(user);
        return new ResponseEntity<>(mailService.getUserMailListExcludingDeleteMail(user), HttpStatus.OK);
    }
    */

}