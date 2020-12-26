package com.wtw.catfriendsServer.service.impl;

import com.wtw.catfriendsServer.domain.Mail;
import com.wtw.catfriendsServer.domain.RewardInfo;
import com.wtw.catfriendsServer.domain.enums.RewardType;
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
        boolean isProduct = false;
        int breakPoint = 0;

        List<UserMail> list = userMailRepository.findAllByUserAndIsDelete(user, false);
        List<UserMailDto> result = new ArrayList<>();
        for(UserMail m : list) {
            List<RewardInfo> rewards = m.getMail().getRewards();
            for (RewardInfo r : rewards) {
                if (r.getType() == RewardType.DRAW || r.getType() == RewardType.PACK) {
                    isProduct = true;
                    break;
                }
                breakPoint++;
            }
            if(isProduct){
                result.add(m.toDto(m.getMail().getProductCode()));
            }else{
                result.add(m.toDto(" "));
            }
        }

        return result;
    }

    @Override
    @Transactional
    public void storeUserMailData(List<UserMailDto> dto, User user) {
        for(UserMailDto d : dto){
            for(UserMail m : user.getMails()){
                if(d.getId().equals(m.getMail().getId()))
                //    System.out.println("test!!!!!"); //고치기
                    m.update(d);
            }
        }
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

    public boolean getPaidProduct(User user, String productCode){
        Mail mail = mailRepository.findByProductCode(productCode);
        UserMail userMail = UserMail.builder()
                .mail(mail)
                .user(user)
                .build();
        if(userMailRepository.save(userMail)!=null){
            return true;
        }
        return false;
    }
}
