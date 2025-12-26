package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProcessTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Selesaikan pembelian produk")
    public void testSuccessfulPurchase() {
        test = extent.createTest("Checkout - Positive Test");
        HomePage home = new HomePage(driver);
        ProductPage prod = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage check = new CheckoutPage(driver);

        home.selectFirstProduct();
        prod.addToCart();

        // Memberi waktu session cart terisi
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        home.goToCart();
        cart.clickPlaceOrder();

        check.completePurchase("Junior QA TechMart", "4555-1234-5678-0000");

        String confirmation = check.getConfirmation();
        Assert.assertTrue(confirmation.contains("Thank you"), "Pesan sukses tidak muncul!");
        test.pass("Pembelian selesai dengan konfirmasi: " + confirmation);
    }
}