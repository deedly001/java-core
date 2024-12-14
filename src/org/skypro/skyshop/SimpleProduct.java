package org.skypro.skyshop;

public class SimpleProduct extends Product {
    private final Integer productCost;
    private String productName;
    private boolean isSpecial = false;

    public SimpleProduct(String productName, Integer productCost) {
        super(productName);
        this.productCost = productCost;
    }

    @Override
    public Integer getPrice() {
        return productCost;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "<" + productName + "> : <" + productCost + ">" ;
    }
}
