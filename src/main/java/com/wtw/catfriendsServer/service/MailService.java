package com.wtw.catfriendsServer.service;

import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.domain.user.UserMail;
import com.wtw.catfriendsServer.dto.MailDto;
import com.wtw.catfriendsServer.dto.UserMailDto;

import java.util.List;

public interface MailService {
    //유저 초기화 - 처음 메일

    //유저 불러오기 - 메일 전체
    public List<UserMailDto> getUserMailList(User user);

    //유저 불러오기 - 삭제처리 메일 제외한 모든 메일
    public List<UserMailDto> getUserMailListExcludingDeleteMail(User user);

    //데이터 저장
    public void storeUserMailData(List<UserMailDto> dto, User user);

    public List<UserMail> getUserMail(User user);

    public List<MailDto> getMailList();

    public List<UserMailDto> updateUserMailListDeleteInitial(User user);
}
