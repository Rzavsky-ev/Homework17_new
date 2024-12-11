package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
        if (basePrice < 1) {
            throw new IllegalArgumentException("Неправильная цена товара");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Неправильная величина скидки");
        }

        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPriceProduct() {
        return basePrice - basePrice * discount / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Имя товара с скидкой:" + getNameProduct() + " стоимость:" + getPriceProduct();
    }
}
