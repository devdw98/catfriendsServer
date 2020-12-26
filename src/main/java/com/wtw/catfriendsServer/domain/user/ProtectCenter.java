package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wtw.catfriendsServer.domain.user.User;
import com.wtw.catfriendsServer.dto.ProtectCenterDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

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

    @Column(name = "IS_PC")
    private Boolean isPC;

    @Column(name = "IS_DONA_CLEAR_1")
    private Boolean donaClear1;

    @Column(name = "IS_DONA_CLEAR_2")
    private Boolean donaClear2;

    @Column(name = "IS_DONA_CLEAR_3")
    private Boolean donaClear3;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

//    @OneToOne(mappedBy = "pc")
//    @JsonManagedReference
//    private PcClickTime clickTime;

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
        this.isPC = dto.getIsProtectionCenter();
        this.donaClear1 = dto.getIsDonationClear().get(0);
        this.donaClear2 = dto.getIsDonationClear().get(1);
        this.donaClear3 = dto.getIsDonationClear().get(2);
    }

    public void update(ProtectCenterDto dto){
        this.currentPCIndex = dto.getCurrentPCIndex();
        this.maxFriendCount = dto.getMaxFriendCount();
        this.curFriendCount = dto.getCurFriendCount();
        this.maxTempCareCount = dto.getMaxTempCareCount();
        this.curTempCareCount = dto.getCurTempCareCount();
        this.countOfAds = dto.getCountOfAds();
        this.isPC = dto.getIsProtectionCenter();
        this.donaClear1 = dto.getIsDonationClear().get(0);
        this.donaClear2 = dto.getIsDonationClear().get(1);
        this.donaClear3 = dto.getIsDonationClear().get(2);
    }

    public List<Boolean> getDonationClear(){
        Boolean[] result = {getDonaClear1(), getDonaClear2(), getDonaClear3()};
        return Arrays.asList(result);
    }
}
