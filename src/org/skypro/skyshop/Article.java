package org.skypro.skyshop;

public abstract class Article {
    private String article;
    private String articleText;

    @Override
    public String toString() {
        return article + "\n" + articleText;
    }
}

interface Searchable{
    public default String getSearchTerm(){
        return null;
    }

    public  default String getContentType(){
        return null;
    }

    public  default String getStringRepresentation(){
        return "«имя Searchable-объекта — тип Searchable-объекта»";
    }
}
