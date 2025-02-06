package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
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

    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getSearchContentType() {
        return getArticleType();
    }
}


