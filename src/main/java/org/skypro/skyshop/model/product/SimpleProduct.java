package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private Integer productCost;
    private final UUID id;


    public SimpleProduct(String productName, Integer productCost, UUID id) {
        super(productName, id);
        this.productCost = productCost;
        this.id = id;
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

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getProductName() + " : " + getPrice();
    }

}
