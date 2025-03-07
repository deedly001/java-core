package org.skypro.skyshop.model.search;

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
        return new SearchResult(searchable.getId(), searchable.getSearchTerm(), searchable.getSearchContentType());
    }

    public String getItemName() {
        return this.name;
    }

    public String getItemType() {
        return this.contentType;
    }
}