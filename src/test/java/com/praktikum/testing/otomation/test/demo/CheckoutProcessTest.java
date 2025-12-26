package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProcessTest extends BaseTest {

    @Test(description = "Checkout pembelian produk secara lengkap")
    public void testCompleteCheckout() {
        test = extent.createTest("Checkout - End to End");
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        home.selectFirstProduct();
        new ProductPage(driver).addToCart();
        home.goToCart();
        cart.clickPlaceOrder();
        checkout.completePurchase("TechMart QA Team", "4555-8888-9999-0000");

        Assert.assertTrue(checkout.getConfirmation().contains("Thank you"), "Gagal checkout!");
        test.pass("Pembelian selesai dengan konfirmasi sukses.");
    }
}