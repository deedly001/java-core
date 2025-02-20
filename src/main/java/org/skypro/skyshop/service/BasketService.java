package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }


    public void addProductToBasket(UUID productId) {
        Optional<Product> productOptional = storageService.getProductById(productId);
        if (productOptional.isPresent()) {
            productBasket.addProduct(productId);
        } else {
            throw new IllegalArgumentException("Продукт с ID " + productId + " не найден");
        }
    }

    public UserBasket getUserBasket() {
        Map<UUID, Product> productMap = storageService.getStorageOfProducts().stream().
                collect(Collectors.toMap(Product::getId, p -> p));

        return new UserBasket(productBasket.getAllProducts().entrySet().stream().
                filter(entry -> productMap.containsKey(entry.getKey())).
                map(entry -> new BasketItem
                        (productMap.get(entry.getKey()), entry.getValue())).collect(Collectors.toList()));
    }

}
