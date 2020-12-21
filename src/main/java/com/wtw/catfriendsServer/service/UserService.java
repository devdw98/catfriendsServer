package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.dto.UserDto;

public interface UserService {
    public UserDto initial(String uid);
    public boolean initialClientData(String uid, UserDto dto);
    public boolean checkDuplicateUser(String uid);
    public UserDto getUser(String uid);
    public UserDto storeUser(String uid, UserDto dto);
}
