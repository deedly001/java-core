package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        ProductBasket products = new ProductBasket();
        products.setProductInCart(new Product("apple", 300));
        products.setProductInCart(new Product("orange", 250));
        products.setProductInCart(new Product("pineapple", 240));
        products.setProductInCart(new Product("watermelon", 400));
        products.setProductInCart(new Product("mango", 360));
//        products.getAllCost();
        products.printAllCart();
//        products.setProductInCart(new Product("apples", 300));
//        products.printAllCart();
        products.getCartCleaner();
        products.printAll();


    }
}
