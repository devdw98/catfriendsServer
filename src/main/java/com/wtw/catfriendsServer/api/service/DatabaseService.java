package com.wtw.catfriendsServer.api.service;

import org.springframework.stereotype.Service;

@Service
public interface DatabaseService {
    public void createUserDB();
    public void updateUserDB();
    public void deleteUserDB();
    public void readUserDB();
}
