package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();

    String getSearchContentType();

    UUID getId();

    default String getStringRepresentation() {
        return getSearchTerm() + "-" + getSearchContentType();
    }

}
