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

    @Override
    public boolean equals(Object obj) {
        // Проверка на null
        if (obj == null) {
            return false;
        }
        // Проверка на тип
        if (!(obj instanceof Article)) {
            return false;
        }
        // Приведение к типу Person
        Article other = (Article) obj;
        return this.articleTitle.equals(other.articleTitle);
    }

    @Override
    public int hashCode() {
        if (articleTitle == null) {
            return 0;
        }
        return articleTitle.hashCode();
    }
}
