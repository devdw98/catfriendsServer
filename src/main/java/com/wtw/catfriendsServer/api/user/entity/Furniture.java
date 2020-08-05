package com.wtw.catfriendsServer.api.user.entity;

public class Furniture {
    private Long id;
    private String name; //가구 이름
    private Part part; //소속 가게
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

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
