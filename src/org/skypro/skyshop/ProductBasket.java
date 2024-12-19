package org.skypro.skyshop;


import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public void setProductInBasket(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                break;
            } else if (products.length - 1 == i && products[i] != null) {
                System.out.println("Невозможно добавить продукт");
            }
        }
    }


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
        if (counter == products.length) {
            System.out.println("в корзине пусто");
        } else {
            getAllCost();
        }
        if (specialCounter != 0) {
            System.out.println("Специальных товаров: " + specialCounter);
        }
    }

    public void getProductByName(String productName) {
        if (productName != null) {
            boolean searchStatus = false;
            for (int i = 0; i < products.length; i++) {
                if (productName.equalsIgnoreCase(products[i].getProductName())) {
                    searchStatus = true;
                }
            }
            if (searchStatus) {
                System.out.println("Продукт " + productName + " есть в корзине");
            } else {
                System.out.println("такого продукта нет в корзине");
            }
        }
    }

    public void getBasketCleaner() {
        Arrays.fill(products, null);
    }

    public void getDiscountedProduct(DiscountedProduct DiscountedProduct) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = DiscountedProduct;
                break;
            } else if (products.length - 1 == i && products[i] != null) {
                System.out.println("Невозможно добавить продукт");
            }
        }

    }


    public void getFixPriceProduct(FixPriceProduct FixPriceProduct) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = FixPriceProduct;
                break;
            } else if (products.length - 1 == i && products[i] != null) {
                System.out.println("Невозможно добавить продукт");
            }
        }
    }

//    public void getFixPriceProduct(FixPriceProduct FixPriceProduct) {
//        for (int i = 0; i < products.length; i++) {
//            if (products[i] == null) {
//                products[i] = FixPriceProduct;
//                break;
//            } else if (products.length - 1 == i && products[i] != null) {
//                System.out.println("Невозможно добавить продукт");
//            }
//        }
//    }

}