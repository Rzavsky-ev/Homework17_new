package org.skypro.skyshop.searchService;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return "имя объекта " + getSearchTerm() + "-тип объекта " + getContentType();
    }
}
