package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private Integer productCost;
//    private String productName;

    public SimpleProduct(String productName, Integer productCost) {
        super(productName);
        this.productCost = productCost;
        checkCost(productCost);
    }

    private void checkCost(Integer productCost) throws IllegalArgumentException {
        if (productCost != null) {
            if (productCost < 1) {
                throw new IllegalArgumentException(("Цена продукта: \"" + productCost + "\"" + " должна быть больше чем = 0"));
            }
        } else {
            throw new NullPointerException(("Цена продукта не может быть = 'Null'"));
        }
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
