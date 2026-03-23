package com.example.week8_classsession;

public class Discount {
    // this class is used for unit testing purpose
    private final double discountPercentage;
    Discount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    double discountedPrice(double price) {
        return price * (100.0-discountPercentage) / 1000;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
