package com.wtw.catfriendsServer.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.domain.enums.RewardType;
import com.wtw.catfriendsServer.dto.RewardDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "REWARD_INFO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RewardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REWARD_INFO_ID")
    private Long id;

    @Column(name = "TYPE")
    @Enumerated
    private RewardType type; //보상 종류

    @Column(name = "DEGREE")
    private Long degree; //보상 정도

    public RewardDto toDto(){
        RewardDto dto = RewardDto.builder()
                .type(getType())
                .degree(getDegree())
                .build();
        return dto;
    }
}
