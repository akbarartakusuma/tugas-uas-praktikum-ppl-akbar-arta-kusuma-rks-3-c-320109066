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

        test.info("Memilih produk");
        home.selectFirstProduct();

        test.info("Menambah ke keranjang");
        product.addToCart();

        test.info("Membuka keranjang dan checkout");
        home.goToCart();
        // (Tambahkan method clickPlaceOrder di CartPage jika perlu)

        test.info("Menyelesaikan pembayaran");
        // Contoh data dummy
        checkout.completePurchase("Junior QA", "123456789");

        Assert.assertTrue(checkout.getConfirmation().contains("Thank you"), "Pembelian gagal!");
        test.pass("Transaksi Berhasil!");
    }
}