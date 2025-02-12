package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.Searchable;
import java.util.UUID;

public final class SearchResult {
    private final UUID id;
    private final String name;
    private final String contentType;

    public SearchResult(UUID id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(UUID.randomUUID(), searchable.getSearchTerm(), searchable.getSearchContentType());
    }
}