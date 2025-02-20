package org.skypro.skyshop.model.product;
import java.util.UUID;

public class DiscountedProduct extends Product {
    private Integer basePrice;
    private final Integer discountPrice;
    private final UUID id;

    public DiscountedProduct(String productName, Integer productCost, Integer discountPrice, UUID id) {
        super(productName, id);
        this.basePrice = productCost;
        checkBasePrice(basePrice);
        this.discountPrice = discountPrice;
        checkDiscountPrice(discountPrice);
        this.id = id;

    }

    private void checkDiscountPrice(Integer discountPrice) throws IllegalArgumentException {
        if (basePrice != null) {
            if (discountPrice == 0) {
                throw new NullPointerException(("Скидка не может быть = 'Null'"));
            } else if (discountPrice < 0 || discountPrice > 100) {
                throw new IllegalArgumentException(("Скидка на продукт: " + this.getProductName() + " не может быть менее 0% и более 100%"));
            }
        }
    }

    private void checkBasePrice(Integer basePrice) throws IllegalArgumentException {
        if (basePrice != null) {
            if (basePrice < 1) {
                throw new IllegalArgumentException(("Цена продукта: \"" + basePrice + "\"" + " должна быть больше чем = 0"));
            } else if (basePrice == 0) {
                throw new NullPointerException(("Цена продукта не может быть = 'Null'"));
            }
        }
    }


    @Override
    public Integer getPrice() {
        return (int) (basePrice * (1 - discountPrice / 100f));
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
        return getProductName() + " : " + getPrice() + " (скидка " + getDiscountPrice() + "%)";
    }

}
