package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProcessTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Selesaikan alur pembelian")
    public void testCompletePurchase() {
        test = extent.createTest("Checkout - Positive Test");
        HomePage home = new HomePage(driver);
        ProductPage prod = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        home.selectFirstProduct();
        prod.addToCart();

        // Jeda singkat agar data produk tersimpan di session web
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        home.goToCart();
        cart.clickPlaceOrder();

        checkout.completePurchase("TechMart Quality", "4555-0000-1111-2222");

        String confirmation = checkout.getConfirmation();
        Assert.assertTrue(confirmation.contains("Thank you"), "Pesan konfirmasi tidak muncul.");
        test.pass("Transaksi berhasil diselesaikan: " + confirmation);
    }
}