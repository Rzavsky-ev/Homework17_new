package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Basket {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> removeProduct(String name) {
        List<Product> deletedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getNameProduct().equals(name)) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        return deletedProducts;
    }

    public int calculateBasketAmount() {
        int total = 0;
        for (Product product : products) {
            total += product.getPriceProduct();
        }
        return total;
    }

    public void printBasket() {
        if (!products.isEmpty()) {
            int counter = 0;
            for (Product product : products) {
                if (product.isSpecial()) {
                    counter++;
                }
                System.out.println(product.toString());
            }
            System.out.println("Итого:" + calculateBasketAmount());
            System.out.println("Специальных товаров:" + counter);
        } else {
            System.out.println("Корзина пуста");
        }
    }

    public boolean checkAvailability(String name) {
        boolean flag = false;
        for (Product product : products) {
            if (product.getNameProduct().equals(name)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void clearingBasket() {
        products.clear();
    }
}
