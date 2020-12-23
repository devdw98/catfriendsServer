package com.wtw.catfriendsServer.domain.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wtw.catfriendsServer.domain.user.pc.ProtectCenter;
import com.wtw.catfriendsServer.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "User")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "UID", nullable = false, unique = true)
    private String uid; //firebase UID 추출

    @Column(name = "MONEY", columnDefinition = "double default 0")
    private double money;

    @Column(name = "DIA", columnDefinition = "double default 0")
    private int dia;

    @Column(name = "HEART", columnDefinition = "bigint default 0")
    private int heart;

    @Column(name = "CUR_ADD_MONEY", columnDefinition = "double default 0")
    private double curAddMoney;

    @Column(name = "CUR_TIME")
    private LocalDateTime curTime; //최근 접속 시간

    @Column(name = "SAVE_TIME")
    private LocalDateTime saveTime; //최근 저장 시간

    @OneToOne(mappedBy = "user", cascade={CascadeType.ALL})
    @JsonManagedReference
    private Chunbae chunbae;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private Setting setting;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserCoupon> coupons;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Store> stores;

    @OneToOne(mappedBy = "user", cascade={CascadeType.ALL})
    @JsonManagedReference
    private NyanNyaLand rsp;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private Quest quest;

    @OneToOne(mappedBy = "user")
    @JsonManagedReference
    private ProtectCenter protectionCentor;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<CatDog> catDogs;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Animal> animals;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserMail> mails;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserRequest> userRequests;

    public User(String uid) {
        this.uid = uid;
        this.money = 0;
        this.dia = 0;
        this.heart = 0;
        this.curAddMoney = 1;
        this.curTime = LocalDateTime.now();
        this.saveTime = LocalDateTime.now();
    }

    public User(String uid, UserDto dto){
        this.uid = uid;
        this.money = dto.getMoney();
        this.dia = dto.getDia();
        this.heart = dto.getHeart();
        this.curAddMoney = dto.getCurAddMoney();
        this.curTime = dto.getCurTime();
        this.saveTime = dto.getSaveTime();
    }

    public UserDto toDto(){
        UserDto dto = UserDto.builder()
                .money(getMoney())
                .dia(getDia())
                .heart(getHeart())
                .curAddMoney(getCurAddMoney())
                .curTime(getCurTime())
                .saveTime(getSaveTime())
                .build();
        return dto;
    }

    @Builder
    public User(String uid, double money, int dia, int heart, double curAddMoney,
                LocalDateTime curTime, LocalDateTime saveTime) {
        this.uid = uid;
        this.money = money;
        this.dia = dia;
        this.heart = heart;
        this.curAddMoney = curAddMoney;
        this.curTime = curTime;
        this.saveTime = saveTime;
    }

    public void update(UserDto dto){
        this.money = dto.getMoney();
        this.dia = dto.getDia();
        this.heart = dto.getHeart();
        this.curAddMoney = dto.getCurAddMoney();
        this.curTime = dto.getCurTime();
        this.saveTime = LocalDateTime.now();
//        this.chunbae = dto.chunbaeEntity(this);
//        this.setting = dto.settingEntity(this);
    }
}
