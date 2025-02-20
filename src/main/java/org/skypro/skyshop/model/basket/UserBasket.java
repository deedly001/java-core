package org.skypro.skyshop.model.basket;

import java.util.List;


public class UserBasket {
    private final List<BasketItem> itemsInBasket;
    private final int totalSumm;

    public UserBasket(List<BasketItem> items) {
        this.itemsInBasket = items;
        this.totalSumm = calculateTotalCost();
    }

    private int calculateTotalCost() {
        return itemsInBasket.stream()
                .mapToInt(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public int getTotal() {
        return totalSumm;
    }

    public List<BasketItem> getBasketItems() {
        return itemsInBasket;
    }

    @Override
    public String toString() {
        return "UserBasket{" +
                "basketItems=" + itemsInBasket +
                ", total=" + totalSumm +
                '}';
    }
}
