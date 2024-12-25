package org.skypro.skyshop;

interface Searchable{
    public default String getSearchTerm(String text){
        return text;
    }

    public default String getContentType(String type){
        return type;
    }

    public default void getStringRepresentation(String text, String type){
        System.out.println("«имя: "+ getSearchTerm(text) +" — тип: " + getContentType(type));
    }

}
