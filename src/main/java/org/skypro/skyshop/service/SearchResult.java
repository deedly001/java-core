package org.skypro.skyshop.service;


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
}