package org.skypro.skyshop.search;

import java.util.*;


public final class SearchEngine {
    private final HashMap<String, Set<Searchable>> searchItems = new HashMap<>();

    public Searchable getMostSimilarElement(String query) {
        int maxScore = 0;
        Searchable result = null;
        for (Set<Searchable> searchablesList : searchItems.values()) {
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

    public Set<Searchable> search(String query) {
        Set<Searchable> res = new TreeSet<>(new mostLongestNameComparator());
        for (Set<Searchable> searchablesList : searchItems.values()) {
            for (Searchable searchable : searchablesList) {
                if (searchable.getSearchTerm().contains(query)) {
                    res.add(searchable);
                }
            }
        }
        return res;
    }
    public static class mostLongestNameComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            return CharSequence.compare(s1.getSearchTerm(), s2.getSearchTerm());
        }
    }


    public void addSearchable(Searchable searchable) {
        searchItems.computeIfAbsent(searchable.getSearchTerm(), _ -> new HashSet<>()).add(searchable);
    }

    public void addAll(Searchable... searchables) {
        for (Searchable searchable : searchables) {
            searchItems.computeIfAbsent(searchable.getSearchTerm(), _ -> new HashSet<>()).add(searchable);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(searchItems, that.searchItems);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(searchItems);
    }

    }