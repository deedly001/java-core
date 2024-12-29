package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket products = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine();

        Product apple = new SimpleProduct("apple", 300);
        Product orange = new SimpleProduct("orange", 250);
        Product blueberry = new SimpleProduct("blueberry", 240);
        Product mango = new DiscountedProduct("mango", 360, 5);
        Product watermelon = new FixPriceProduct("watermelon");

        products.setProductInBasket(apple);
        products.setProductInBasket(orange);
        products.setProductInBasket(blueberry);
        products.setProductInBasket(mango);
        products.setProductInBasket(watermelon);

        products.printAllBasket();
//        System.out.println(" -> Получение стоимости корзины с несколькими товарами.");
//        products.getAllCost();
//        System.out.println(" -> Поиск товара, который есть в корзине.");
//        products.getProductByName("Apple");
//        products.getProductByName("opple");
//        System.out.println(" -> Очистка корзины");
//        products.getBasketCleaner();
//        System.out.println(" -> Печать содержимого пустой корзины.");
//        products.printAllBasket();
//        System.out.println(" -> Получение стоимости пустой корзины.");
//        products.getAllCost();
//        System.out.println(" -> Поиск товара по имени в пустой корзине.");
        searchEngine.addAll(apple, orange, blueberry, mango, watermelon);
        Article applesArticle = new Article(
                "Статья о яблоках",
                "Яблоки - это ... ."
        );
        Article mangosArticle = new Article(
                "Статья о Манго",
                "Манго - это ... ."
        );

        searchEngine.addAll(applesArticle, mangosArticle);

        String searchQuery1 = "Яблоки";
        System.out.println("Поиск " + searchQuery1 + " " + Arrays.toString(searchEngine.search(searchQuery1)));

        String searchQuery2 = "Личи";
        System.out.println("Поиск " + searchQuery2 + " " + Arrays.toString(searchEngine.search(searchQuery2)));

        String searchQuery3 = "Манго";
        System.out.println("Поиск " + searchQuery3 + " " + Arrays.toString(searchEngine.search(searchQuery3)));

        String searchQuery4 = "blueberry";
        System.out.println("Поиск " + searchQuery4 + " " + Arrays.toString(searchEngine.search(searchQuery4)));
        System.out.println("----------------------\n");
    }
}
