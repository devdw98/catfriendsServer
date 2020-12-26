package com.wtw.catfriendsServer.domain;

import com.wtw.catfriendsServer.dto.MailDto;
import com.wtw.catfriendsServer.dto.RewardDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MAILS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAIL_ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @ManyToMany
    @JoinTable(name = "MAIL_REWARDS",
            joinColumns = @JoinColumn(name = "MAIL_ID"),
            inverseJoinColumns = @JoinColumn(name = "REWARD_INFO_ID"))
    List<RewardInfo> rewards = new ArrayList<>();

    @Transient
    private int rewardCount;

    public MailDto toDto(){
        List<RewardDto> rewards = new ArrayList<>();
        for(RewardInfo i : getRewards())
            rewards.add(i.toDto());
        MailDto dto = MailDto.builder()
                .title(getTitle())
                .content(getContent())
                .rewards(rewards)
                .rewardCount(rewards.size())
                .build();
        return dto;
    }
}
