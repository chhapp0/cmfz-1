package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 专辑类
 */


public class Album {
    private String id;

    private String thumbnail;//头像路径

    private String title;//标题

    private Double score;//评分

    private String author;//作者

    private String broadcast;//播音员
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date createdate;//发布日期

    private String brief;//内容介绍

    private List<Chapter> chapters;//专辑所包含的章节

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", createdate=" + createdate +
                ", brief='" + brief + '\'' +
                ", chapters=" + chapters +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public Album() {

    }

    public Album(String id, String thumbnail, String title, Double score, String author, String broadcast, Date createdate, String brief, List<Chapter> chapters) {

        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.createdate = createdate;
        this.brief = brief;
        this.chapters = chapters;
    }
}