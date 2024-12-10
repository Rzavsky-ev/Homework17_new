package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int priceProduct;

    public SimpleProduct(String nameProduct, int priceProduct) {
        super(nameProduct);
        this.priceProduct = priceProduct;
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Имя товара:" + getNameProduct() + " стоимость:" + getPriceProduct();
    }
}
