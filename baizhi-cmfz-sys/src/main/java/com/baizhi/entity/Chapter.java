package com.baizhi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Chapter {
    private String id;

    private String title;

    private String url;

    private String csize;

    private Album album;

    private String duration;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdate;

    public Chapter() {
        super();
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", csize='" + csize + '\'' +
                ", album=" + album +
                ", duration='" + duration + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCsize() {
        return csize;
    }

    public void setCsize(String csize) {
        this.csize = csize;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Chapter(String id, String title, String url, String csize, Album album, String duration, Date createdate) {

        this.id = id;
        this.title = title;
        this.url = url;
        this.csize = csize;
        this.album = album;
        this.duration = duration;
        this.createdate = createdate;
    }
}