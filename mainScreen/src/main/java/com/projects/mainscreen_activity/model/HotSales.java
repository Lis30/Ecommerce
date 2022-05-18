package com.projects.mainscreen_activity.model;

public class HotSales {

    int id;
    boolean is_new = false;
    String title;
    String subtitle;
    String picture;
    boolean is_buy;

    public HotSales(int id, String title, String subtitle, String picture, boolean is_buy) {
        this.id = id;
        this.is_new = false;
        this.title = title;
        this.subtitle = subtitle;
        this.picture = picture;
        this.is_buy = is_buy;
    }


    public HotSales(int id, boolean is_new, String title, String subtitle, String picture, boolean is_buy) {
        this.id = id;
        this.is_new = is_new;
        this.title = title;
        this.subtitle = subtitle;
        this.picture = picture;
        this.is_buy = is_buy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean get_is_new() {
        return is_new;
    }

    public void set_new(boolean is_new) {
        this.is_new = is_new;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean get_is_buy() {
        return is_buy;
    }

    public void set_Is_buy(boolean is_buy) {
        this.is_buy = is_buy;
    }

  }
