package com.wtw.catfriendsServer.config;

import com.wtw.catfriendsServer.repository.MailRepository;
//import com.wtw.catfriendsServer.service.RewardInfoService;
//import com.wtw.catfriendsServer.service.impl.RewardInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.wtw.catfriendsServer.repository"})
public class SpringConfig {

//    private final RewardInfoRepository rewardInfoRepository;
//
//    @Autowired
//    public SpringConfig(RewardInfoRepository rewardInfoRepository) {
//        this.rewardInfoRepository = rewardInfoRepository;
//        this.mailRepository = mailRepository;
//    }

//    @Bean
//    public MailService mailService(){
//        return new MailServiceImpl(mailRepository);
//    }
//    @Bean
//    public RewardInfoService rewardInfoService(){
//        return new RewardInfoServiceImpl(rewardInfoRepository);
//    }
}
