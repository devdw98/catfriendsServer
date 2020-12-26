package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wtw.catfriendsServer.dto.ShopDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "USER_SHOP")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SHOP_ID")
    private Long id;

    @Column(name = "IS_BUY_LP1")
    private Boolean isBuyLp1;
    @Column(name = "IS_BUY_LP2")
    private Boolean isBuyLp2;

    @Column(name = "ADS_1")
    private String ads1;
    @Column(name = "ADS_2")
    private String ads2;
    @Column(name = "ADS_3")
    private String ads3;

    @Column(name = "PERIOD_1")
    private String period1;
    @Column(name = "PERIOD_2")
    private String period2;
    @Column(name = "PERIOD_3")
    private String period3;

    @Column(name = "DAILY_1")
    private String daily1;
    @Column(name = "DAILY_2")
    private String daily2;
    @Column(name = "DAILY_3")
    private String daily3;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;

    @Builder
    public UserShop(Boolean isBuyLp1, Boolean isBuyLp2, String ads1, String ads2, String ads3, String period1, String period2, String period3, String daily1, String daily2, String daily3, User user) {
        this.isBuyLp1 = isBuyLp1;
        this.isBuyLp2 = isBuyLp2;
        this.ads1 = ads1;
        this.ads2 = ads2;
        this.ads3 = ads3;
        this.period1 = period1;
        this.period2 = period2;
        this.period3 = period3;
        this.daily1 = daily1;
        this.daily2 = daily2;
        this.daily3 = daily3;
        this.user = user;
    }

    public ShopDto toDto(){
        Boolean[] isBuyLps = {getIsBuyLp1(), getIsBuyLp2()};
        String[] ads = {getAds1(), getAds2(), getAds3()};
        String[] periods = {getPeriod1(), getPeriod2(), getPeriod3()};
        String[] dailys = {getDaily1(), getDaily2(), getDaily3()};
        ShopDto dto = ShopDto.builder()
                .isBuyLP(Arrays.asList(isBuyLps))
                .ads(Arrays.asList(ads))
                .period(Arrays.asList(periods))
                .daily(Arrays.asList(dailys))
                .build();
        return dto;
    }

    public void update(ShopDto dto){
        this.isBuyLp1 = dto.getIsBuyLP().get(0);
        this.isBuyLp2 = dto.getIsBuyLP().get(1);
        this.ads1 = dto.getAds().get(0);
        this.ads2 = dto.getAds().get(1);
        this.ads3 = dto.getAds().get(2);
        this.period1 = dto.getPeriod().get(0);
        this.period2 = dto.getPeriod().get(1);
        this.period3 = dto.getPeriod().get(2);
        this.daily1 = dto.getDaily().get(0);
        this.daily2 = dto.getDaily().get(1);
        this.daily3 = dto.getDaily().get(2);
    }
}
