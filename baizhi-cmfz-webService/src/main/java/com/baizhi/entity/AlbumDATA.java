package com.baizhi.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * 专辑表
 * id                   varchar(40)                    not null,
 thumbnail            varchar(40),
 title                varchar(40),
 score                double,
 author               varcahr(40),
 broadcast            varchar(40),
 createDate           date,
 brief                varchar(1000),
 */
@XmlRootElement(name="/albums")
public class AlbumDATA {
   private String id;

    //album.setXo(page.getTotal)
    //图片连接
    private String thumbnail;
    //标题
    private String title;
    //类型
    private Integer type;
    //描述
    private String author;
    //private String broadcast;
    //集数
    private Integer set_count;
    //创建时间
    private Date create_date;

    //private List<Chapter> chapter;

    //private String brief;


    public AlbumDATA() {
    }

    public AlbumDATA(String id, String thumbnail, String title, Integer type, String author, Integer set_count, Date create_date) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.type = type;
        this.author = author;
        this.set_count = set_count;
        this.create_date = create_date;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSet_count() {
        return set_count;
    }

    public void setSet_count(Integer set_count) {
        this.set_count = set_count;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "AlbumDATA{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", author='" + author + '\'' +
                ", set_count=" + set_count +
                ", create_date=" + create_date +
                '}';
    }
}