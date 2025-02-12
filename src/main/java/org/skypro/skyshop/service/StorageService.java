package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        this.articleStorage = new HashMap<>();
        this.getAllItems();
    }

    private void getAllItems() {
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Яблоки", 300, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Апельсины", 250, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new SimpleProduct("Голубика", 2400, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new DiscountedProduct("Манго", 360, 50, UUID.randomUUID()));
        productStorage.put(UUID.randomUUID(), new FixPriceProduct("Абрикосы", UUID.randomUUID()));
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

    public Map<UUID, Searchable> getAllSearchables() {
        Map<UUID, Searchable> allSearchable = new HashMap<>();
        allSearchable.putAll(productStorage);
        allSearchable.putAll(articleStorage);
        return allSearchable;
    }

}
