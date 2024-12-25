package org.skypro.skyshop;

import java.util.Arrays;

public class SearchEngine {
    String name;
    String type;
    Integer arrLen = 5;

    public void Searchable(String name, String type) {
        this.name = name;
        this.type = type;
    }

    Searchable [] searchables = new Searchable[arrLen];

    public void setName(String word){
        this.name = word;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void search(String word){
        String [] searchResult = new String[10];
        for (int i = 0; i < searchables.length; i++) {
            if (word.equalsIgnoreCase(searchables[i].toString())){
                for (int j = 0; j < searchResult.length; j++) {
                    if (searchResult[i] == null){
                        searchResult[i] = searchables[i].toString();
                    }
                }
            }
        }
        Arrays.toString(searchResult);
    }

    public void add(Searchable searchable){
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null){
                searchables[i] = searchable;
            }
        }
    }


}
