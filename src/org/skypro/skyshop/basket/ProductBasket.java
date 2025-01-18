package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final HashMap<String, Product> products = new HashMap<>();

    public void getAllCost() {
        Integer allCost = 0;
        for (Map.Entry<String, Product> tempArray : products.entrySet()) {
            if (tempArray.getKey() != null && tempArray.getValue() != null) {
                allCost += tempArray.getValue().getPrice();
            }
        }
        System.out.println("Итого: " + allCost);
    }

    public void printAllBasket() {
        int counter = 0;
        int specialCounter = 0;
        for (Map.Entry<String, Product> tempArray : products.entrySet()) {
            if (tempArray.getKey() != null && tempArray.getValue() != null) {
                System.out.println(tempArray.getValue());
                if (tempArray.getValue().isSpecial()) {
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

    public void removeProductFromBasket(String name) {
        List<Object> deletedProducts = new ArrayList<>();
        System.out.println("Удаляем продукт: " + name);
        Iterator<Map.Entry<String, Product>> iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Product> entry = iterator.next();
            if (entry.getKey().equals(name)) {
                iterator.remove();
                deletedProducts.add(entry.getKey());
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.print("Список пуст \n");
        } else {
            System.out.println("Продукты которые были удалены: " + deletedProducts);
        }
    }


    public void setProductInBasket(Product product) {
        products.put(product.getProductName(), product);
    }

    public boolean checkProductInBasket(String name) {
        for (Product product : products.values()) {
            if (product != null && name.equals(product.getProductName())) {
                return true;
            }
        }
        return false;
    }

}