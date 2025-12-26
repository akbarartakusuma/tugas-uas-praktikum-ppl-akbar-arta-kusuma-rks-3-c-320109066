package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProcessTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Pembelian produk hingga selesai")
    public void testSuccessfulPurchase() {
        test = extent.createTest("Checkout - Positive Test");
        HomePage home = new HomePage(driver);
        ProductPage prod = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage check = new CheckoutPage(driver);

        test.info("Menambah produk ke keranjang");
        home.selectFirstProduct();
        prod.addToCart();

        test.info("Navigasi ke halaman Cart");
        home.goToCart();

        test.info("Mengisi detail pembayaran");
        cart.clickPlaceOrder();
        check.completePurchase("TechMart Tester", "4555-1234-5678-0000");

        test.info("Verifikasi pesan sukses");
        String confirmation = check.getConfirmation();
        Assert.assertTrue(confirmation.contains("Thank you"), "Gagal checkout!");
        test.pass("Pembelian Berhasil: " + confirmation);
    }
}