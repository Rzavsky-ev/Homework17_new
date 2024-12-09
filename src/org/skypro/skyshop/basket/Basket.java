package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class Basket {
    private final int QUANTITY_PRODUCTS = 5;
    private Product[] products = new Product[QUANTITY_PRODUCTS];

    public void addProduct(Product product) {
        boolean flag = false;
        for (int i = 0; i < QUANTITY_PRODUCTS; i++) {
            if (products[i] == null) {
                products[i] = product;
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int calculateBasketAmount() {
        int total = 0;
        for (Product product : products) {
            if (product == null) {
                break;
            }
            total += product.getPriceProduct();
        }
        return total;
    }

    public void printBasket() {
        if (products.length != 0) {
            int counter = 0;
            for (Product product : products) {
                if (product == null) {
                    break;
                }
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
            if (product == null) {
                break;
            }
            if (product.getNameProduct().equals(name)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void clearingBasket() {
        Arrays.fill(products, null);
    }
}
