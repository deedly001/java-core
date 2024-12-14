package org.skypro.skyshop;

public abstract class Product {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

//    public void setPrice(Integer cost) {
//        this.productCost = cost;
//    }

    public void setBasketNull() {
        this.productName = null;
//        this.productCost = null;
    }

    private Integer getDiscount(){
        return DiscountedProduct.discountPrice;
    }


    public abstract Integer getPrice();
    public  abstract  boolean isSpecial();
}