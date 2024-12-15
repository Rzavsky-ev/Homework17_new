package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class Basket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product.getNameProduct())) {
            products.get(product.getNameProduct()).add(product);
        } else {
            List<Product> productsList = new ArrayList<>(List.of(product));
            products.put(product.getNameProduct(), productsList);
        }
    }

    public Map<String, List<Product>> removeProduct(String name) {
        Map<String, List<Product>> deletedProducts = new HashMap<>();
        deletedProducts.put(name, products.get(name));
        products.remove(name);
        return deletedProducts;
    }

    public int calculateBasketAmount() {
        return products.entrySet().stream().flatMap(entry -> entry.getValue().stream()).
                mapToInt(Product::getPriceProduct).sum();
    }

    public void printBasket() {
        if (!products.isEmpty()) {

            products.entrySet().stream().flatMap(entry -> entry.getValue().stream()).forEach(entry -> {
                System.out.println(entry.toString());
            });
            System.out.println("Итого:" + calculateBasketAmount());
            System.out.println("Специальных товаров:" + getSpecialCount());
        } else {
            System.out.println("Корзина пуста");
        }
    }

    private long getSpecialCount() {
        return products.entrySet().stream().flatMap(entry -> entry.getValue().stream()).
                filter(Product::isSpecial).count();
    }

    public boolean checkAvailability(String name) {
        return products.containsKey(name);
    }

    public void clearingBasket() {
        products.clear();
    }
}
