package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private Integer basePrice;
    private final Integer discountPrice;

    public DiscountedProduct(String productName, Integer productCost, Integer discountPrice) {
        super(productName);
        this.basePrice = productCost;
        checkBasePrice(basePrice);
        this.discountPrice = discountPrice;
        checkDiscountPrice(discountPrice);

    }

    private void checkDiscountPrice(Integer discountPrice) throws IllegalArgumentException {
        if (basePrice != null) {
            if (discountPrice < 0 || discountPrice > 100) {
                throw new IllegalArgumentException(("Скидка на продукт: " + this.getProductName() + " не может быть менее 0% и более 100%"));
            }
        } else {
            throw new NullPointerException(("Скидка не может быть = 'Null'"));
        }
    }

    private void checkBasePrice(Integer basePrice) throws IllegalArgumentException {
        if (basePrice != null) {
            if (basePrice < 1) {
                throw new IllegalArgumentException(("Цена продукта: \"" + basePrice + "\"" + " должна быть больше чем = 0"));
            }
        } else {
            throw new NullPointerException(("Цена продукта не может быть = 'Null'"));
        }
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
