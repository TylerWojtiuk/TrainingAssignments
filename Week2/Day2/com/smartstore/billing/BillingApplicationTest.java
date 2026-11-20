package com.smartstore.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BillingApplicationTest {

    @Test
    void testCalculateDiscountBelow1000() {
        double actual = BillingApplication.calculateDiscount(800);
        double expected = 0.0;

        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testCalculateDiscountAt1000() {
        double actual = BillingApplication.calculateDiscount(1000);
        double expected = 50.0;

        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testCalculateDiscountAt4999() {
        double actual = BillingApplication.calculateDiscount(4999);
        double expected = 249.95;

        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testCalculateDiscountAt5000() {
        double actual = BillingApplication.calculateDiscount(5000);
        double expected = 500.0;

        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testCalculateDiscountAbove5000() {
        double actual = BillingApplication.calculateDiscount(7000);
        double expected = 700.0;

        assertEquals(expected, actual, 0.001);
    }
}
