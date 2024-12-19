package org.skypro.skyshop;

public class SearchEngine {
    public SearchEngine(Searchable[] searchables) {
        this.searchables = searchables;
    }

    // массив всех элементов, по которым можно искать. Размерность массива нужно передавать через конструктор класса
    //
    //SearchEngine
    //
    //.
    Searchable[] searchables = new Searchable[5];
    // принимает в себя строку для поиска и возвращает 5 результатов поиска по массиву
    //
    //Searchable
    //
    //в виде массива из 5 элементов.
    public String search(String word){
        return null;
    }
    // добавляет новый объект типа
    //
    //Searchable
    //
    //в массив поискового движка.
    public void add(){
        return ;
    }
}
