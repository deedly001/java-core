package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public final class SearchEngine {
    private final HashMap<String, List<Searchable>> searchItems = new HashMap<>();


    public Searchable getMostSimilarElement(String query) {
        int maxScore = 0;
        Searchable result = null;
        for (List<Searchable> searchablesList : searchItems.values()) {
            for (Searchable searchable : searchablesList) {
                int score = countOccurrences(searchable, query);
                if (score > maxScore && searchable.getSearchTerm() != null) {
                    maxScore = score;
                    result = searchable;
                }
            }
        }
        return result;
    }

    public int countOccurrences(Searchable searchable, String substr) {
        String searchableText = searchable.getSearchTerm();
        int count = 0;
        if (searchableText == null || searchableText.isEmpty() || substr == null || substr.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; (i = searchableText.indexOf(substr, i)) != -1; i += substr.length()) {
                count++;
            }
        }
        return count;
    }

    public List<Searchable> search(String query) {
        List<Searchable> res = new ArrayList<>();
        for (List<Searchable> searchablesList : searchItems.values()) {
            for (Searchable searchable : searchablesList) {
                if (searchable.getSearchTerm().contains(query)) {
                    res.add(searchable);
                }
            }
        }
        return res;
    }

    public void addSearchable(Searchable searchable) {
        searchItems.computeIfAbsent(searchable.getSearchTerm(), _ -> new ArrayList<>()).add(searchable);
    }

    public void addAll(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            searchItems.computeIfAbsent(searchable.getSearchTerm(), _ -> new ArrayList<>()).add(searchable);
        }
    }
}