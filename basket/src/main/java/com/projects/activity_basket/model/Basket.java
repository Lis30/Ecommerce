package com.projects.activity_basket.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Basket {


    @SerializedName("basket")
    @Expose
    ArrayList<ProdInBasket> basket;

    String delivery;
    int id;
    String total;

    public ArrayList<ProdInBasket> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<ProdInBasket> basket) {
        this.basket = basket;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
