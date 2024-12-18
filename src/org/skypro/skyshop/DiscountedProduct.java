package org.skypro.skyshop;

public class DiscountedProduct extends Product {
    private Integer basePrice;
    protected Integer discountPrice;

    public DiscountedProduct(String productName, Integer productCost, Integer discountPrice) {
        super(productName);
        this.basePrice = productCost;
        this.discountPrice = discountPrice;
    }

    @Override
    public Integer getPrice() {
        return (basePrice - (discountPrice * basePrice) / 100);
    }

    @Override
    public void setPrice(Integer cost) {
        this.basePrice = cost;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice() + " (скидка " + getDiscountPrice() + "%)";
    }
}
