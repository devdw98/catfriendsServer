package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.Mail;
import com.wtw.catfriendsServer.domain.RewardInfo;
import com.wtw.catfriendsServer.domain.enums.RewardType;
import com.wtw.catfriendsServer.dto.RewardDto;
import com.wtw.catfriendsServer.dto.UserMailDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USER_MAIL")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_MAIL_ID")
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "MAIL_ID")
    private Mail mail;

    @Column(name = "IS_READ",columnDefinition = "BIT(1) default false")
    private Boolean isRead; //읽었는 지

    @Column(name = "IS_DELETE",columnDefinition = "BIT(1) default false")
    private Boolean isDelete; // 삭제요청 여부

    @Column(name = "RECEIVED_TIME",columnDefinition = "DATETIME default now()")
  //  @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime receivedTime; //메일 준 시간

    @Column(name = "READ_TIME", columnDefinition = "DATETIME default now()")
  //  @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime readTime; //메일 읽은 시간

    public UserMailDto toDto(){
        List<RewardDto> rewardDtoList = new ArrayList<>();
        boolean isNotice = false;
        int count = 0;
        for(RewardInfo d : getMail().getRewards()){
            rewardDtoList.add(d.toDto());
            if(d.getType().equals(RewardType.NOTICE) || d.getType().equals(RewardType.DRAW) || d.getType().equals(RewardType.PACK))
                isNotice = true;
        }
        if(isNotice)
            count = 0;
        else count = rewardDtoList.size();

        UserMailDto dto = UserMailDto.builder()
                .id(getMail().getId())
                .title(getMail().getTitle())
                .content(getMail().getContent())
                .rewards(rewardDtoList)
                .rewardCount(count)
                .receivedTime(getReceivedTime())
                .readTime(getReadTime())
                .read(getIsRead())
                .delete(getIsDelete())
                .build();
        return dto;
    }
}
