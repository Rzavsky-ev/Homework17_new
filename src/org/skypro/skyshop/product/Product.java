package org.skypro.skyshop.product;

import org.skypro.skyshop.searchService.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;

    public Product(String nameProduct) {
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

    public abstract int getPriceProduct();

    public abstract boolean isSpecial();

}