package com.wtw.catfriendsServer.api.user.entity;

public class CatDogPeople {
    private Long id;
    private String name; //냥멍인 이름
    private boolean own; //보유여부
    private int level; //레벨

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwn() {
        return own;
    }

    public void setOwn(boolean own) {
        this.own = own;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
