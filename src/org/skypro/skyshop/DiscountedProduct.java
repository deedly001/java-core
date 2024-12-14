package org.skypro.skyshop;

public class DiscountedProduct extends Product {
    private final Integer basePrice;
    public static Integer discountPrice;
    private final String productName;

    public DiscountedProduct(String productName, Integer productCost, Integer discountPrice) {
        super(productName);
        this.basePrice = productCost;
        this.discountPrice = discountPrice;
        this.productName = productName;
    }

    @Override
    public Integer getPrice() {
        return (basePrice - (discountPrice * basePrice) / 100);
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "<" + productName + "> : <" + basePrice + "(" + discountPrice + "%)" + ">" ;
    }
}
