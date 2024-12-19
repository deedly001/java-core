package org.skypro.skyshop;

public abstract class Product implements Searchable {
    private String productName;
    private Integer discountPrice;
    public boolean isSpecial;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public String getSearchTerm(){
        return "name: "+ getProductName() + " type: " +  "PRODUCT";
    }

    public abstract Integer getPrice();

    public abstract void setPrice(Integer cost);

    public abstract boolean isSpecial();
}