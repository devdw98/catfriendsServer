package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.Mail;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.domain.user.UserMail;
import com.wtw.catfriendsServer.dto.MailDto;
import com.wtw.catfriendsServer.dto.UserMailDto;
import com.wtw.catfriendsServer.repository.MailRepository;
import com.wtw.catfriendsServer.repository.UserMailRepository;
import com.wtw.catfriendsServer.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final MailRepository mailRepository;
    private final UserMailRepository userMailRepository;

    @Override
    public List<UserMail> getUserMail(User user){
        return userMailRepository.findAllByUser(user);
    }

    @Override
    public List<UserMailDto> getUserMailList(User user) {
        List<UserMail> list = userMailRepository.findAllByUser(user);
        List<UserMailDto> result = new ArrayList<>();
        for(UserMail m : list)
            result.add(m.toDto());
        return result;
    }

    @Override
    public List<UserMailDto> getUserMailListExcludingDeleteMail(User user) {
        List<UserMail> list = userMailRepository.findAllByUserAndIsDelete(user, false);
        List<UserMailDto> result = new ArrayList<>();
        for(UserMail m : list)
            result.add(m.toDto());
        return result;
    }

    @Override
    @Transactional
    public boolean storeUserMailData(User user, List<UserMailDto> req) {
        List<UserMail> entity = userMailRepository.findAllByUser(user);
        for(UserMailDto d : req){
            for(UserMail m : entity){
                if(d.getId().equals(m.getMail().getId()))
                    System.out.println(); //고치기
                //    m.update(d);
            }
        }
        if(userMailRepository.saveAll(entity).isEmpty())
            return false;
        return true;
    }

    @Override
    public List<MailDto> getMailList() {
        List<MailDto> result = new ArrayList<>();
        List<Mail> mails = mailRepository.findAll();
        for(Mail m : mails)
            result.add(m.toDto());
        return result;
    }

    @Override
    public List<UserMailDto> updateUserMailListDeleteInitial(User user) {
        List<UserMail> list = userMailRepository.findAllByUserAndIsDelete(user, true);
        List<UserMailDto> result = new ArrayList<>();
    /*    for(UserMail m : list){
            m.updateInitial();
            userMailRepository.save(m);
            result.add(m.toDto());
        }*/
        return result;
    }
}
