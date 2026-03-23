package com.example.week8_classsession;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiscountTest {
    @Test
    public void getDiscount_isCorrect() {
        Discount d = new Discount(3.3);
        assertEquals(3.3, d.getDiscountPercentage(), 0.01);
    }

    @Test
    public void getDiscountedPrice_isCorrect() {
        Discount d = new Discount(10);
        assertEquals(45.0, d.discountedPrice(50), 0.01);
    }
}