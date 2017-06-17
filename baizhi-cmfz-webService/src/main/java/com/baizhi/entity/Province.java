package com.baizhi.entity;

import com.baizhi.entity.*;

import java.util.List;

public class Province {
    private String id;

    private String pname;

    private List<City> citys;

    public Province() {
        super();
    }

    @Override
    public String toString() {
        return "Province{" +
                "id='" + id + '\'' +
                ", pname='" + pname + '\'' +
                ", citys=" + citys +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }

    public Province(String id, String pname, List<City> citys) {

        this.id = id;
        this.pname = pname;
        this.citys = citys;
    }
}