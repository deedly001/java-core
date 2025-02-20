package org.skypro.skyshop.model.product;
import java.util.UUID;

public class FixPriceProduct extends Product {
    private final Integer PRODUCT_FIX_PRICE = 400;


    public FixPriceProduct(String productName, UUID id) {
        super(productName, id);
    }


    @Override
    public Integer getPrice() {
        return PRODUCT_FIX_PRICE;
    }


    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена: " + getPrice();
    }

}
