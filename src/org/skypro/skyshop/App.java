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

import java.util.List;

public class App {
    public static void main(String[] args) {

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

        //проверка метода searchForMostSuitable
        Product apple = new SimpleProduct("Яблоко", 10);
        Product pear = new SimpleProduct("Груша", 100);
        Product banana = new DiscountedProduct("Банан", 30, 10);
        Product plum = new FixPriceProduct("Слива");

        searchEngine.add(apple);
        searchEngine.add(pear);
        searchEngine.add(banana);
        searchEngine.add(apple);
        searchEngine.add(plum);

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

////////////////////////////////////////////////////////////////////////
        //Проверка корзины
        Basket basket = new Basket();

        //добавление в корзину
        basket.addProduct(apple);
        basket.addProduct(pear);
        basket.addProduct(banana);
        basket.addProduct(apple);
        basket.addProduct(apple);

        //удаление продукта из корзины
        List<Product> deletedProducts = basket.removeProduct("Яблоко");

        //вывод удаленных продуктов
        for (Product product : deletedProducts) {
            System.out.println(product.getNameProduct());
        }
        System.out.println();
        //вывод содержимого корзины
        basket.printBasket();
        System.out.println();
        //удаление несуществующего продукта и проверка списка
        if (basket.removeProduct("Арбуз").isEmpty()) {
            System.out.println("Список пуст");
        }
        System.out.println();
        //вывод корзины
        basket.printBasket();


    }
}