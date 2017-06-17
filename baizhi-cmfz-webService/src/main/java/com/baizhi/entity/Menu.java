package com.baizhi.entity;

import java.util.List;

/**
 * 菜单模块
 */

public class Menu {
    private String id;

    private String name;

    private String iconCls;

    private String href;

    private Integer level;

    private List<Menu> menus;

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", href='" + href + '\'' +
                ", level=" + level +
                ", menus=" + menus +
                '}';
    }

    public Menu() {
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

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu(String id, String name, String iconCls, String href, Integer level, List<Menu> menus) {

        this.id = id;
        this.name = name;
        this.iconCls = iconCls;
        this.href = href;
        this.level = level;
        this.menus = menus;
    }
}