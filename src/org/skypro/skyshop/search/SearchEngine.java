package org.skypro.skyshop.search;


public final class SearchEngine {
    private final Searchable[] searchables;
    private static final int MAX_SEARCH_RES = 5;
    private static final int NOT_FOUND = -1;
    private static final int DEFAULT_SIZE = 50;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable getMostSimilarElement(String query) throws Exception{
        int maxScore = 0;
        Searchable result = null;
        for (Searchable searchable : searchables) {
            if (searchable != null && query != null) {
                int score = countOccurrence(searchable.getSearchTerm(), query);
                if (score > maxScore && searchable.getSearchTerm() != null) {
                    maxScore = score;
                    result = searchable;
                }
            }
        }
        return result;
    }

    public int countOccurrence(String str, String substr) {
        int count = 0;
        if (str != null && substr != null) {
            for (int i = 0; (i = str.indexOf(substr, i)) != -1; i += substr.length()) {
                count++;
            }
        }
        return count;
    }

    public SearchEngine() {
        this.searchables = new Searchable[DEFAULT_SIZE];
    }

    public Searchable[] search(String query) {
        Searchable[] res = new Searchable[MAX_SEARCH_RES];
        int i = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                res[i++] = searchable;
                if (i >= MAX_SEARCH_RES) {
                    break;
                }
            }
        }
        return res;
    }

    public void add(Searchable searchable) {
        int freeIndex = getFreeIndex();
        if (freeIndex == NOT_FOUND) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        searchables[freeIndex] = searchable;
    }

    public void addAll(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            add(searchable);
        }
    }

    private int getFreeIndex() {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
