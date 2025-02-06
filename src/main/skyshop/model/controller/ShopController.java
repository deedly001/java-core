package main.skyshop.model.controller;

import main.skyshop.model.article.Article;
import main.skyshop.model.product.Product;
import main.skyshop.model.service.StorageService;
import org.springframework.*;


import java.util.Collection;

public class ShopController {

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles();
}
