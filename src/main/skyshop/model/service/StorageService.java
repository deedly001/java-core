package main.skyshop.model.service;

import main.skyshop.model.article.Article;
import main.skyshop.model.product.DiscountedProduct;
import main.skyshop.model.product.FixPriceProduct;
import main.skyshop.model.product.Product;
import main.skyshop.model.product.SimpleProduct;
import main.skyshop.model.search.Searchable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;


    public StorageService(Map<UUID, Product> productStorage, Map<UUID, Article> articleStorage) {
        this.productStorage = new HashMap<>();
        addProducts();
        this.articleStorage = new HashMap<>();
        addArticle();
    }

    private void addProducts() {
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Яблоки", 300, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Апельсины", 250, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Голубика", 2400, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new DiscountedProduct("Манго", 360, 50, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new FixPriceProduct("Абрикосы", UUID.randomUUID()));

    }

    private void addArticle() {
        articleStorage.put(UUID.randomUUID(), new Article("Яблоки", "это яблоки", UUID.randomUUID()));
        articleStorage.put(UUID.randomUUID(), new Article("Манго", "это манго", UUID.randomUUID()));
        articleStorage.put(UUID.randomUUID(), new Article("Абрикосы", "это оно", UUID.randomUUID()));
    }

    public Collection<Product> getStorageOfProducts() {
        return productStorage.values();
    }

    public Collection<Article> getStorageOfArticle() {
        return articleStorage.values();
    }

    public Map<UUID, Searchable> getSearchables() {
        Map<UUID, Searchable> collectionOfSearchables = new HashMap<>();
        collectionOfSearchables.putAll(productStorage);
        collectionOfSearchables.putAll(articleStorage);
        return collectionOfSearchables;
    }

}
