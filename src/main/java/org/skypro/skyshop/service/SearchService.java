package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    @Autowired
    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search(String name) {
        return storageService.getAllSearchables().values().stream()
                .filter(searchable -> searchable.getSearchTerm().contains(name))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }


}