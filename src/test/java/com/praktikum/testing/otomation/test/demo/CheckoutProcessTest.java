package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProcessTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Selesaikan pembelian produk")
    public void testSuccessfulPurchase() {
        test = extent.createTest("Checkout - Positive Test");
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage check = new CheckoutPage(driver);

        home.selectFirstProduct();
        new ProductPage(driver).addToCart();
        home.goToCart();
        cart.clickPlaceOrder();
        check.completePurchase("QA Tester", "4555-1234-5678-9999");

        Assert.assertTrue(check.getConfirmation().contains("Thank you"), "Gagal Checkout!");
        test.pass("Pembelian berhasil dilakukan.");
    }
}