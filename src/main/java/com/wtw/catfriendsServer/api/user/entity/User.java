package com.wtw.catfriendsServer.api.user.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

//@Entity
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column
    private String userInfo; //사용자 고유값
//    @Column
    private int level; //춘배 레벨
//    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccessTime; //마지막 접속 시간
    private Long moneyPerHour; //기본 시간 당 매출
    private Long money; //매출(돈)
    private Long dia; //다이아
    private Long leadingPoint; //선행포인트
    private Long catDogPeopleId;
    private Long animalId;
    private Long furniture;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Long getMoneyPerHour() {
        return moneyPerHour;
    }

    public void setMoneyPerHour(Long moneyPerHour) {
        this.moneyPerHour = moneyPerHour;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getDia() {
        return dia;
    }

    public void setDia(Long dia) {
        this.dia = dia;
    }

    public Long getLeadingPoint() {
        return leadingPoint;
    }

    public void setLeadingPoint(Long leadingPoint) {
        this.leadingPoint = leadingPoint;
    }
    public Long getCatDogPeopleId() {
        return catDogPeopleId;
    }

    public void setCatDogPeopleId(Long catDogPeopleId) {
        this.catDogPeopleId = catDogPeopleId;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public Long getFurniture() {
        return furniture;
    }

    public void setFurniture(Long furniture) {
        this.furniture = furniture;
    }
}
