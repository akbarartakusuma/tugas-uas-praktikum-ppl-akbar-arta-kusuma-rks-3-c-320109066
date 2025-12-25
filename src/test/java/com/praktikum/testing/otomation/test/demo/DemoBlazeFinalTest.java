package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoBlazeFinalTest extends BaseTest {

    @Test
    public void testEndToEndPurchase() {
        test = extent.createTest("End to End Purchase Test");

        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        test.info("Navigasi ke Home dan memilih produk");
        home.selectFirstProduct();

        test.info("Menambahkan produk ke keranjang");
        product.addToCart();

        test.info("Membuka halaman keranjang");
        home.goToCart();

        test.info("Mengklik Place Order untuk memunculkan form pembayaran");
        // PERBAIKAN: Langkah ini wajib ada agar elemen 'id: name' muncul
        cart.clickPlaceOrder();

        test.info("Mengisi form pembelian dan konfirmasi");
        checkout.completePurchase("Junior QA TechMart", "1234567890");

        String confirmationText = checkout.getConfirmation();
        test.info("Pesan konfirmasi: " + confirmationText);

        Assert.assertTrue(confirmationText.contains("Thank you"), "Pembelian gagal dilakukan!");
        test.pass("Pengujian End-to-End Berhasil!");
    }
}