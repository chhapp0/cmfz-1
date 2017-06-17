package com.baizhi.entity;

import java.util.List;

public class Guru {
    private String id;

    private String name;

    private String head;

    private List<User> users;

    private List<Essay> essays;

    public Guru() {
        super();
    }

    public Guru(String id, String name, String head, List<User> users, List<Essay> essays) {
        this.id = id;
        this.name = name;
        this.head = head;
        this.users = users;
        this.essays = essays;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", head='" + head + '\'' +
                ", users=" + users +
                ", essays=" + essays +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Essay> getEssays() {
        return essays;
    }

    public void setEssays(List<Essay> essays) {
        this.essays = essays;
    }
}