package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;


    public StorageService(Map<UUID, Product> products, Map<UUID, Article> articles) {
        this.productStorage = products;
        this.articleStorage = articles;
        getAllProducts();
        getAllArticles();
        testerPr();
    }


    private void getAllProducts() {
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Яблоки", 300, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Апельсины", 250, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Голубика", 2400, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new DiscountedProduct("Манго", 360, 50, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new FixPriceProduct("Абрикосы", UUID.randomUUID()));
        System.out.println(productStorage.values());
    }

    private void getAllArticles() {
        articleStorage.put(UUID.randomUUID(), new Article("Яблоки", "это яблоки", UUID.randomUUID()));
        articleStorage.put(UUID.randomUUID(), new Article("Манго", "это манго", UUID.randomUUID()));
        articleStorage.put(UUID.randomUUID(), new Article("Абрикосы", "это оно", UUID.randomUUID()));
    }

    public void testerPr(){
        System.out.println(" tester" + productStorage.values());
        System.out.println(" tester" + articleStorage.values());
    }

    public Collection<Product> getStorageOfProducts() {
        return productStorage.values();
    }

    public Collection<Article> getStorageOfArticle() {
        return new ArrayList<>(articleStorage.values());
    }

    public Map<UUID, Searchable> getAllSearchables() {
        Map<UUID, Searchable> collectionOfSearchables = new HashMap<>();
        collectionOfSearchables.putAll(productStorage);
        collectionOfSearchables.putAll(articleStorage);
        return collectionOfSearchables;
    }



}
