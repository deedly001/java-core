package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>(5);

    public void getAllCost() {
        Integer allCost = 0;
        for (Product product : products) {
            if (product != null) {
                if (product.getPrice() != null) {
                    allCost += product.getPrice();
                }
            }
        }
        System.out.println("Итого: " + allCost);
    }

    public void printAllBasket() {
        int counter = 0;
        int specialCounter = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCounter++;
                }
            } else {
                counter++;
            }
        }
        if (counter == products.size()) {
            System.out.println("в корзине пусто");
        } else {
            getAllCost();
        }
        if (specialCounter != 0) {
            System.out.println("Специальных товаров: " + specialCounter);
        }
    }

    public void getBasketCleaner() {
        products.clear();
    }

    public void setProductInBasket(Product product) {
        products.add(product);
    }

    public void removeProductFromBasket(String name) {
        List<String> deletedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        System.out.println("Удаляем продукт: " + name);
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (Objects.equals(element.getProductName(), name)) {
                deletedProducts.add(String.valueOf(element));
                iterator.remove();
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Продукты которые были удалены: " + deletedProducts);
        }
    }
}