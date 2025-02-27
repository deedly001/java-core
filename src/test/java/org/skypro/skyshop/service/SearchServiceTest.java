package org.skypro.skyshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;


    @Test
    void testEmptyStorageService() {
        when(storageService.getAllSearchables()).thenReturn(Collections.emptyMap());
        List<SearchResult> results = searchService.search("...");
        assertTrue(results.isEmpty());
    }

    @Test
    void testNoMatchingProductExist() {
        Product apple = new SimpleProduct("Яблоко", 150, UUID.randomUUID());
        Product banana = new SimpleProduct("Банан", 200, UUID.randomUUID());
        Map<UUID, Searchable> searchables = new HashMap<>();
        searchables.put(apple.getId(), apple);
        searchables.put(banana.getId(), banana);
        when(storageService.getAllSearchables()).thenReturn(searchables);
        List<SearchResult> results = searchService.search("_");
        assertTrue(results.isEmpty());
    }

}
