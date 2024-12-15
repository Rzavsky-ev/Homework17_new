package org.skypro.skyshop.product;

import org.skypro.skyshop.searchService.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;

    public Product(String nameProduct) {
        if (nameProduct == null || nameProduct.isBlank()) {
            throw new IllegalArgumentException("Неправильное название товара");
        }
        this.nameProduct = nameProduct;
    }

    @Override
    public String getSearchTerm() {
        return nameProduct;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    public String getNameProduct() {
        return nameProduct;
    }

    @Override
    public abstract String toString();

    public abstract int getPriceProduct();

    public abstract boolean isSpecial();

    @Override
    public boolean equals(Object obj) {
        // Проверка на null
        if (obj == null) {
            return false;
        }
        // Проверка на тип
        if (!(obj instanceof Product)) {
            return false;
        }
        // Приведение к типу Person
        Product other = (Product) obj;
        return this.getNameProduct().equals(other.getNameProduct());
    }

    @Override
    public int hashCode() {
        if (nameProduct == null) {
            return 0;
        }
        return nameProduct.hashCode();
    }

}
