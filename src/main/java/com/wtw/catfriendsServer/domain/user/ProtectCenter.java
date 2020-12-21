package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.dto.ProtectCenterDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PROTECT_CENTER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProtectCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PC_ID")
    private Long id;

    @Column(name = "CURRENT_PC_INDEX")
    private int currentPCIndex;

    @Column(name = "MAX_FRIEND")
    private int maxFriendCount;

    @Column(name = "CUR_FRIEND")
    private int curFriendCount;

    @Column(name = "MAX_TEMPCARE")
    private int maxTempCareCount;

    @Column(name = "CUR_TEMPCARE")
    private int curTempCareCount;

    @Column(name = "COUNT_ADS")
    private int countOfAds;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    public ProtectCenter(User user){
        this.user = user;
        this.currentPCIndex = 0;
        this.maxFriendCount = 20;
        this.curFriendCount = 0;
        this.maxTempCareCount = 50;
        this.curTempCareCount = 0;
        this.countOfAds = 10;
    }

    @Builder
    public ProtectCenter(User user, ProtectCenterDto dto){
        this.user = user;
        this.currentPCIndex = dto.getCurrentPCIndex();
        this.maxFriendCount = dto.getMaxFriendCount();
        this.curFriendCount = dto.getCurFriendCount();
        this.maxTempCareCount = dto.getMaxTempCareCount();
        this.curTempCareCount = dto.getCurTempCareCount();
        this.countOfAds = dto.getCountOfAds();
    }

    public void update(ProtectCenterDto dto){
        this.currentPCIndex = dto.getCurrentPCIndex();
        this.maxFriendCount = dto.getMaxFriendCount();
        this.curFriendCount = dto.getCurFriendCount();
        this.maxTempCareCount = dto.getMaxTempCareCount();
        this.curTempCareCount = dto.getCurTempCareCount();
        this.countOfAds = dto.getCountOfAds();
    }
}
