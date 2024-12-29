package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class Product implements Searchable {
    private String productName;
    private Integer discountPrice;
    public boolean isSpecial;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public String getProductType() {
        return "PRODUCT";
    }

    public String getSearchTerm() {
        return "name: " + getProductName() + " type: " + getProductType();
    }

    @Override
    public String getSearchContentType() {
        return getProductType();
    }

    public Integer getPrice() {
        return null;
    }

    public void setPrice(Integer cost) {
    }

    public boolean isSpecial() {
        return false;
    }

    ;
}