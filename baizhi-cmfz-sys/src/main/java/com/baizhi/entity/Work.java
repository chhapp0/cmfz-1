package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Work {
    private String id;

    private String category;

    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date createdate;

    public Work() {
        super();
    }

    @Override
    public String toString() {
        return "Work{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", user=" + user +
                ", createdate=" + createdate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Work(String id, String category, User user, Date createdate) {

        this.id = id;
        this.category = category;
        this.user = user;
        this.createdate = createdate;
    }
}