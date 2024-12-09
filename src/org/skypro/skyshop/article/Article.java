package org.skypro.skyshop.article;

import org.skypro.skyshop.searchService.Searchable;

public final class Article implements Searchable {

    private String articleTitle = "Статья";
    private String textOfArticle = "Текст";

    @Override
    public String toString() {
        return "Название статьи: " + articleTitle + " Текст статьи " + textOfArticle;
    }

    @Override
    public String getSearchTerm() {
        return this.toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }
}
