package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {
        ProductBasket products = new ProductBasket();
        System.out.println(" -> Демонстрация классов");
        System.out.println(" -> Добавление продукта в корзину");
        products.setProductInBasket(new SimpleProduct("apple", 300));
        products.setProductInBasket(new DiscountedProduct("orange", 250, 5));
        products.setProductInBasket(new SimpleProduct("pineapple", 240));
        products.setProductInBasket(new SimpleProduct("watermelon", 400));
        products.setProductInBasket(new SimpleProduct("mango", 360));
        System.out.println(" -> Добавление продукта в заполненную корзину, в которой нет свободного места");
        products.setProductInBasket(new SimpleProduct("apples", 300));
        System.out.println(" -> Печать содержимого корзины с несколькими товарами.");
        products.printAllBasket();
//        System.out.println(" -> Получение стоимости корзины с несколькими товарами.");
//        products.getAllCost();
//        System.out.println(" -> Поиск товара, который есть в корзине.");
//        products.getProductByName("Apple");
//        products.getProductByName("opple");
//        System.out.println(" -> Очистка корзины");
//        products.getBasketCleaner();
//        System.out.println(" -> Печать содержимого пустой корзины.");
//        products.printAll();
//        System.out.println(" -> Получение стоимости пустой корзины.");
//        products.getAllCost();
//        System.out.println(" -> Поиск товара по имени в пустой корзине.");
//        products.getProductByName("Apple");

    }
}
