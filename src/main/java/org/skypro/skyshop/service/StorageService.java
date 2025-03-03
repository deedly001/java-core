package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public abstract class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        this.articleStorage = new HashMap<>();
        this.getAllItems();
    }

    private void getAllItems() {
        Product apple = new SimpleProduct("Яблоко", 300, UUID.randomUUID());
        productStorage.put(apple.getId(), apple);
        Product orange = new SimpleProduct("Апельсины", 250, UUID.randomUUID());
        productStorage.put(orange.getId(), orange);
        Product blueberry = new SimpleProduct("Голубика", 2400, UUID.randomUUID());
        productStorage.put(blueberry.getId(), blueberry);
        Product mango = new DiscountedProduct("Манго", 360, 5, UUID.randomUUID());
        productStorage.put(mango.getId(), mango);
        Product apricots = new FixPriceProduct("Абрикосы", UUID.randomUUID());
        productStorage.put(apricots.getId(), apricots);
        Article appleArticle = new Article("Яблоки", "это яблоки", UUID.randomUUID());
        articleStorage.put(appleArticle.getId(), appleArticle);
        Article mangoArticle = new Article("Манго", "это манго", UUID.randomUUID());
        articleStorage.put(mangoArticle.getId(), mangoArticle);
        Article apricotsArticle = new Article("Абрикосы", "это оно", UUID.randomUUID());
        articleStorage.put(apricotsArticle.getId(), apricotsArticle);
    }

    public Collection<Product> getStorageOfProducts() {
        return productStorage.values();
    }

    public Collection<Article> getStorageOfArticle() {
        return articleStorage.values();
    }

    public Map<UUID, Searchable> getAllSearchables() {
        Map<UUID, Searchable> allSearchable = new HashMap<>();
        allSearchable.putAll(productStorage);
        allSearchable.putAll(articleStorage);
        return allSearchable;
    }

    public Optional<Product> getProductById(UUID id) throws NoSuchProductException {
        return Optional.ofNullable(productStorage.get(id));
    }
}
