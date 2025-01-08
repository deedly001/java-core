package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();

    String getSearchContentType();

    default String getStringRepresentation() {
        return getSearchTerm() + "-" + getSearchContentType();
    }

}
