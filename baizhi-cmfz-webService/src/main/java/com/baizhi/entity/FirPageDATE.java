package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lenovo on 2017/6/16.
 */


public class FirPageDATE implements Serializable  {

    private List<BannerDATA> header;
    private List<AlbumDATA> body;

    public FirPageDATE(List<BannerDATA> header, List<AlbumDATA> body) {
        this.header = header;
        this.body = body;
    }

    public List<BannerDATA> getHeader() {
        return header;
    }

    public void setHeader(List<BannerDATA> header) {
        this.header = header;
    }

    public List<AlbumDATA> getBody() {
        return body;
    }

    public void setBody(List<AlbumDATA> body) {
        this.body = body;
    }

    public FirPageDATE() {
    }

    @Override
    public String toString() {
        return "All{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
