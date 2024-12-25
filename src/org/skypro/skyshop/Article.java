package org.skypro.skyshop;

public final class Article implements Searchable {
    private String article;
    private String articleText;

    @Override
    public String toString() {
        return article + "\n" + articleText;
    }

    public String getArticleName() {
        return this.article;
    }

    public String getArticleText() {
        return "ARTICLE";
    }

    public String getSearchTerm() {
        return "name: " + getArticleName() + " type: " + getArticleText();
    }
}


