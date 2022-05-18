package com.projects.activity_basket.model;

public class ProdInBasket {
//"id": 2,
//        "images": "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-13-pro-silver-select?wid=470&hei=556&fmt=jpeg&qlt=95&.v=1631652954000",
//        "price": 1800,
//        "title": "iPhone 13"

int id;
String images;
String price;
String title;
int quantity; //поставила количество равное одному, т.к. по ссылке для парсинга не было указания на количество
    //данный атрибут нужно будет дописать после добавления в ссылку строки "количество"

    public ProdInBasket(int id, String images, String price, String title) {
        this.id = id;
        this.images = images;
        this.price = price;
        this.title = title;
        this.quantity = 1;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getImages() {
        return images;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}
