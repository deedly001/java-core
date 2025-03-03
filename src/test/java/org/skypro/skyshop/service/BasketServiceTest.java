package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    ProductBasket productBasket;

    @Mock
    StorageService storageService;

    @InjectMocks
    BasketService basketService;

    @Test
    void testAddNoExistProduct() {
        UUID noProduct = UUID.randomUUID();
        when(storageService.getProductById(noProduct)).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchProductException.class, () -> basketService.addProductToBasket(noProduct));
    }

    @Test
    void testAddExistProduct() {
        UUID ProductId = UUID.randomUUID();
        Product product = Mockito.mock(Product.class);
        when(storageService.getProductById(ProductId)).thenReturn(Optional.of(product));
        basketService.addProductToBasket(ProductId);
        Mockito.verify(productBasket).addProduct(ProductId);
    }

    @Test
    void testIfProductBasketIsEmpty() {
        when(productBasket.getAllProducts()).thenReturn(Collections.emptyMap());
        UserBasket result = basketService.getUserBasket();
        Assertions.assertTrue(result.getBasketItems().isEmpty());
    }

    @Test
    void testIfProductBasketHaveProducts() {
        Product apple = new SimpleProduct("Яблоко", 150, UUID.randomUUID());
        int quantity = 1;
        Map<UUID, Integer> productMap = new HashMap<>();
        productMap.put(apple.getId(), quantity);
        when(productBasket.getAllProducts()).thenReturn(productMap);
        when(storageService.getProductById(apple.getId())).thenReturn(Optional.of(apple));
        UserBasket result = basketService.getUserBasket();
        Assertions.assertEquals(1, result);

    }

}