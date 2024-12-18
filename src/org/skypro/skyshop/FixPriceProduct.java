package org.skypro.skyshop;

public class FixPriceProduct extends Product {
    protected Integer fixPrice;

    public FixPriceProduct(String productName, Integer fixPrice) {
        super(productName);
        this.fixPrice = fixPrice;
    }

    @Override
    public Integer getPrice() {
        return fixPrice;
    }

    @Override
    public void setPrice(Integer cost) {
        fixPrice = cost;
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
