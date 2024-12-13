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
        int total = 0;
        for (Map.Entry<String, List<Product>> product : products.entrySet()) {
            for (Product productList : product.getValue()) {
                total += productList.getPriceProduct();
            }
        }
        return total;
    }

    public void printBasket() {
        if (!products.isEmpty()) {
            int counter = 0;
            for (Map.Entry<String, List<Product>> product : products.entrySet()) {
                for (Product productList : product.getValue()) {
                    if (productList.isSpecial()) {
                        counter++;
                    }
                    System.out.println(productList.toString());
                }
            }
            System.out.println("Итого:" + calculateBasketAmount());
            System.out.println("Специальных товаров:" + counter);
        } else {
            System.out.println("Корзина пуста");
        }
    }

    public boolean checkAvailability(String name) {
        return products.containsKey(name);
    }

    public void clearingBasket() {
        products.clear();
    }
}
