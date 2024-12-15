package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchService.SearchEngine;
import org.skypro.skyshop.searchService.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
/*
        //Проверка класса SearchEngine
        SearchEngine searchEngine = new SearchEngine();
        //проверка конструкторов Product
        try {
            Product apple = new SimpleProduct("Яблоко", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        try {
            Product banana = new DiscountedProduct("Банан", 10, -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        try {
            Product plum = new FixPriceProduct("   ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
*/
        SearchEngine searchEngine = new SearchEngine();
        //проверка метода searchForMostSuitable
        Product apple = new SimpleProduct("Б", 10);
        Product pear = new SimpleProduct("Л", 100);
        Product banana = new DiscountedProduct("А", 30, 10);
        Product plum = new FixPriceProduct("Д");
        Article article = new Article();

        searchEngine.add(apple);
        searchEngine.add(article);
        searchEngine.add(apple);
        searchEngine.add(pear);
        searchEngine.add(article);
        searchEngine.add(banana);
        searchEngine.add(apple);
        searchEngine.add(article);
        searchEngine.add(plum);


        searchEngine.printSearch(searchEngine.search());

        /*
        //когда объект существует
        try {
            System.out.println(searchEngine.searchForMostSuitable("Гр").getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }

        //когда объекта нет
        try {
            searchEngine.searchForMostSuitable("LLL");
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Проверка корзины
        System.out.println();
        System.out.println("Проверка корзины");
        Basket basket = new Basket();

        //добавление в корзину
        basket.addProduct(apple);
        basket.addProduct(pear);
        basket.addProduct(banana);
        basket.addProduct(apple);
        basket.addProduct(apple);
        basket.addProduct(plum);

        //вывод содержимого корзины
        basket.printBasket();

//        //удаление продукта из корзины
//        basket.removeProduct("Яблоко");
//
//        //поиск существующего продукта
//        System.out.println(basket.checkAvailability("Банан"));
//
//        //поиск удаленного продукта
//        System.out.println(basket.checkAvailability("Яблоко"));
//
//        System.out.println();
//        //вывод корзины
//        basket.printBasket();

    }
}