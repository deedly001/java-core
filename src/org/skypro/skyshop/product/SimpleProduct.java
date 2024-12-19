package org.skypro.skyshop.product;

import org.skypro.skyshop.Product;

public class SimpleProduct extends Product {
    private Integer productCost;
//    private String productName;

    public SimpleProduct(String productName, Integer productCost) {
        super(productName);
        this.productCost = productCost;
    }

    @Override
    public Integer getPrice() {
        return productCost;
    }

    @Override
    public void setPrice(Integer cost) {
        this.productCost = cost;
    }

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getProductName() + " : " + getPrice();
    }


}
