package com.aismall.idea_sport.bean;

import java.util.List;

public class MainMenu {
    private int id;
    private String title;
    private String path;
    List<SubMenu> slist;//外键的一对多

    public MainMenu() {
    }

    public MainMenu(String title, String path, List<SubMenu> slist) {
        this.title = title;
        this.path = path;
        this.slist = slist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SubMenu> getSlist() {
        return slist;
    }

    public void setSlist(List<SubMenu> slist) {
        this.slist = slist;
    }

    @Override
    public String toString() {
        return "MainMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", slist=" + slist +
                '}';
    }
}
