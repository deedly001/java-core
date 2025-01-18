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
    public static void main(String[] args) throws Exception {
        ProductBasket products = new ProductBasket();
        SearchEngine searchEngine = new SearchEngine();

        Product apple = new SimpleProduct("Яблоки", 300);
        Product orange = new SimpleProduct("Апельсины", 250);
        Product blueberry = new SimpleProduct("Голубика", 2400);
        Product mango = new DiscountedProduct("Манго", 360, 50);
        Product watermelon = new FixPriceProduct("Абрикосы");

        products.setProductInBasket(apple);
        products.setProductInBasket(orange);
        products.setProductInBasket(blueberry);
        products.setProductInBasket(mango);
        products.setProductInBasket(watermelon);
//        products.printAllBasket();
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
//        searchEngine.addAll();
        Article applesArticle = new Article(
                "Статья о яблоках",
                "Яблоки - это ... ."
        );
        Article mangosArticle = new Article(
                "Статья о Манго",
                "Манго - это ... ."
        );
        searchEngine.addAll(apple, orange, blueberry, mango, watermelon, applesArticle, mangosArticle);
//        searchEngine.addSearchable(applesArticle);
//        searchEngine.addSearchable(mangosArticle);
//        searchEngine.addSearchable(apple);
//        searchEngine.addSearchable(orange);
//        searchEngine.addSearchable(mango);
//        searchEngine.addSearchable(watermelon);
//        searchEngine.addSearchable(blueberry);
//        System.out.println("----------------------\n");
//        String searchQuery1 = "Яблоки";
//        System.out.println("Поиск 1: " + searchQuery1 + " " + searchEngine.search(searchQuery1));
//        String searchQuery2 = "Личи";
//        System.out.println("Поиск 2: " + searchQuery2 + " " + searchEngine.search(searchQuery2));
        String searchQuery3 = "Манго";
        System.out.println("Поиск 3: " + searchQuery3 + " " + searchEngine.search(searchQuery3));
//        String searchQuery4 = "null";
//        System.out.println("Поиск 4: " + searchQuery4 + " " + searchEngine.search(searchQuery4));
        System.out.println("----------------------");
        System.out.println(searchEngine.getMostSimilarElement(searchQuery3));
//        System.out.println("----------------------\n");
//        if(searchEngine.getMostSimilarElement(searchQuery4) == null){
//            System.out.println("Для поискового запроса не нашлось подходящего товара/статьи");
//        }
        System.out.println("----------------------\n");
        products.removeProductFromBasket("Яблоки");
        System.out.println("----------------------\n");
        products.printAllBasket();
//        System.out.println("----------------------\n");
//        System.out.println("Поиск 1: " + searchQuery1 + " " + searchEngine.search(searchQuery1));
        System.out.println("----------------------\n");
    }
}
