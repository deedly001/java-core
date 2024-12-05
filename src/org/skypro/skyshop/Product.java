package org.skypro.skyshop;

public class Product {
    private String productName;
    private Integer productCost;

    public Product(String productName, Integer productCost) {
        this.productName = productName;
        this.productCost = productCost;
//        this.productCount = productCount;
    }

    public String getProductName() {
        return this.productName;
    }

    public Integer getProductCost() {
        return this.productCost;
    }


    public void setProductName(String name) {
        this.productName = name;
    }

    public void setProductCost(Integer cost) {
        this.productCost = cost;
    }

    public void setBasketNull() {
        this.productName = null;
        this.productCost = null;
    }
}