package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public final class Article implements Searchable {
    private final String title;
    private final String content;
    private final UUID id;

    public Article(String title, String content, UUID id) {
        this.title = title;
        this.content = content;
        this.id = UUID.randomUUID();

    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + "\n" + content;
    }

    public String getArticleName() {
        return this.title;
    }

    public String getArticleType() {
        return "ARTICLE";
    }

    @JsonIgnore
    public String getSearchTerm() {
        return toString();
    }

    @JsonIgnore
    @Override
    public String getSearchContentType() {
        return getArticleType();
    }

    @Override
    public UUID getId() {
        return id;
    }
}


