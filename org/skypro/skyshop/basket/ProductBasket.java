package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private final HashMap<String, Product> products = new HashMap<>();

    public double getAllCost() {
        return products.values().stream()
                .mapToInt(Product::getPrice)
                .sum();
    }

    public long getSpecialCount() {
        return products.values().stream()
                .filter(Product::isSpecial)
                .count();
    }

    public void printAllBasket() {
        long specialCounter = getSpecialCount();
        double allCoast = getAllCost();
        if (!products.isEmpty()) {
            products.forEach((product, quantity) -> System.out.println(quantity));
            System.out.println("Итого: " + allCoast);
            if (specialCounter != 0) {
                System.out.println("Специальных товаров: " + specialCounter);
            }
        } else{
            System.out.println("Корзина пуста!");
        }
    }

    public void getBasketCleaner() {
        products.clear();
    }

    public void removeProductFromBasket(String name) {
        List<String> deletedProducts = new ArrayList<>();
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