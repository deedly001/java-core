package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Repository
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> productsInBasket;


    public ProductBasket() {
        this.productsInBasket = new HashMap<>();
    }

    public void addProduct(UUID id) {
        productsInBasket.put(id, productsInBasket.getOrDefault(id, 0) + 1);
    }

    public Map<UUID, Integer> getAllProducts() {
        return Collections.unmodifiableMap(productsInBasket);
    }

}