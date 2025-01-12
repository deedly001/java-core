package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SearchEngine {
    private final List<Searchable> searchItems = new ArrayList<>();


    public Searchable getMostSimilarElement(String query) throws Exception {
        int maxScore = 0;
        Searchable result = null;
        for (Searchable searchable : searchItems) {
            int score = countOccurrence(searchable.getSearchTerm(), query);
            if (score > maxScore && searchable.getSearchTerm() != null) {
                maxScore = score;
                result = searchable;
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

    public List<Searchable> search(String query) {
        List<Searchable> res = new ArrayList<>();
        Iterator<Searchable> iterator = searchItems.iterator();
        while (iterator.hasNext()) {
            Searchable element = iterator.next();
            if (element.getSearchTerm().contains(query)) {
                res.add(element);
            }
        }
        return res;
    }

    public void addSearchable(Searchable searchable) {
        searchItems.add(searchable);
    }

    public void addAll(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            searchItems.add(searchable);
        }
    }

}