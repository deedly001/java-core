package org.skypro.skyshop;

public class FixPriceProduct extends Product {
    private final Integer fixPrice = getPrice();
    private String productName;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    public Integer getPrice() {
        return fixPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }


//    @Override
//    public String toString() {
//        return "<" + productName + "> : <Фиксированная цена: " + fixPrice + ">" ;
//    }
}
