package com.wtw.catfriendsServer.api.user.entity;

public class Animal {
    private Long id;
    private int own; //보유여부
    private int level; //레벨

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOwn() {
        return own;
    }

    public void setOwn(int own) {
        this.own = own;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
