package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchService.SearchEngine;
import org.skypro.skyshop.searchService.Searchable;

public class App {
    public static void main(String[] args) {

        Product apple = new SimpleProduct("Яблоко", 10);
        Product pear = new SimpleProduct("Груша", 100);
        Product banana = new DiscountedProduct("Банан", 30, 10);
        Product plum = new FixPriceProduct("Слива");
        Article article = new Article();


        SearchEngine searchEngine = new SearchEngine(10);
        //добавление
        searchEngine.add(apple);
        searchEngine.add(article);
        searchEngine.add(pear);
        searchEngine.add(article);
        searchEngine.add(banana);
        searchEngine.add(plum);
        searchEngine.add(apple);
        searchEngine.add(article);
        searchEngine.add(apple);

        //проверка поиска
        for (Searchable searchable : searchEngine.search("ARTICLE")) {
            if (searchable == null) {
                break;
            }
            System.out.println(searchable.getSearchTerm());
        }
        System.out.println();
        for (Searchable searchable : searchEngine.search("PRODUCT")) {
            if (searchable == null) {
                break;
            }
            System.out.println(searchable.getSearchTerm());
        }
    }
}