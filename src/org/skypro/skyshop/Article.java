package org.skypro.skyshop;

public final class Article {
    private String article;
    private String articleText;

    @Override
    public String toString() {
        return article + "\n" + articleText;
    }

    public String getArticleName(){
        return this.article;
    }

    public String getArticleText(){
        return "ARTICLE";
    }

    public String getSearchTerm(){
        return "name: "+ getArticleName() + " type: " + getArticleText();
    }
}

interface Searchable{
//    public default String getSearchTerm(String text){
//        return text;
//    }
//
//    public default String getContentType(){
//        return null;
//    }
//
//    public default void getStringRepresentation(){
//        System.out.println("«имя: "+ getSearchTerm() +" — тип: " + getContentType());
//    }

}
