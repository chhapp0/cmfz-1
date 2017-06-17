package com.baizhi.entity;

/**
 * 轮播图
 */
public class Banner {
    private String id;

    private String name;

    private String href;

    private String status;

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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Banner() {
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Banner(String id, String name, String href, String status) {

        this.id = id;
        this.name = name;
        this.href = href;
        this.status = status;
    }
}