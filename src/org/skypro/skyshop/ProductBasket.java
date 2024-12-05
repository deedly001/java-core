package org.skypro.skyshop;


public class ProductBasket {
    private static final Product[] products = new Product[5];

    public void setProductInCart(Product product) {
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
                if (product.getProductCost() != null) {
                    allCost += product.getProductCost();
                }
            }
        }
        System.out.println("Сумма товаров в корзине: " + allCost + " руб.");
    }

    public void printAll() {
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getProductName() + " : " + product.getProductCost());
            }
        }
    }

    public void printAllCart() {
        int counter = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getProductName() + " : " + product.getProductCost());
            } else {
                counter++;
            }
        }
        if (counter == products.length) {
            System.out.println("в корзине пусто");
        } else {
            getAllCost();
        }
    }


    public void getCartCleaner() {
        for (Product product : products) {
            if (product != null) {
                product.setBasketNull();
            }
        }

    }
}