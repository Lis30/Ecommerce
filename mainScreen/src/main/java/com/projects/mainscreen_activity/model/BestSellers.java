package com.projects.mainscreen_activity.model;

public class BestSellers {

    int id;
    boolean is_favorites;
    String title;
    String price_without_discount;
    String discount_price;
    String picture;

    public BestSellers(int id, boolean is_favorites, String title, String price_without_discount, String discount_price, String picture) {
        this.id = id;
        this.is_favorites = is_favorites;
        this.title = title;
        this.price_without_discount = price_without_discount;
        this.discount_price = discount_price;
        this.picture = picture;
    }

    public BestSellers(int id,  String title, String price_without_discount, String discount_price, String picture) {
        this.id = id;
        this.is_favorites = false;
        this.title = title;
        this.price_without_discount = price_without_discount;
        this.discount_price = discount_price;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean get_favorites() {
        return is_favorites;
    }

    public void set_favorites(boolean is_favorites) {
        this.is_favorites = is_favorites;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice_without_discount() {
        return price_without_discount;
    }

    public void setPrice_without_discount(String price_without_discount) {
        this.price_without_discount = price_without_discount;
    }

    public String getDiscount_price() {
        return discount_price;
    }

    public String getPicture() {
        return picture;
    }

}
