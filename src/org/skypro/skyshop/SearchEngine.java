package org.skypro.skyshop;

public class SearchEngine {
    String name;
    String type;
    Integer arrLen = 5;

    public SearchEngine(String name, String type) {
        this.name = name;
        this.type = type;
    }

    Searchable[] searchables = new Searchable();

    // принимает в себя строку для поиска и возвращает 5 результатов поиска по массиву
    //
    //Searchable
    //
    //в виде массива из 5 элементов.

    public void setName(String word){
        this.name = word;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public String search(String word){
        String [] searchResult = new String[10];
        for (int i = 0; i < searchables.length; i++) {
            if (word.equalsIgnoreCase(searchables[i].toString())){
                for (int j = 0; j < searchResult.length; j++) {
                    if (searchResult[i] == null){
                        System.out.println(searchResult[i]);
                    }
                }
            }
        }
        return null;
    }

    public void add(Searchable searchable){
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null){
                searchables[i] = searchable;
            }
        }
    }
}
