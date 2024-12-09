package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPriceProduct() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Имя товара с фиксированной ценой:" + getNameProduct() + " стоимость:" + getPriceProduct();
    }
}
