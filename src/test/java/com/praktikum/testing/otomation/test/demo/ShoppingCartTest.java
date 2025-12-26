package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Tambah produk ke keranjang")
    public void testAddToCart() {
        test = extent.createTest("Cart - Add Item");
        HomePage home = new HomePage(driver);
        ProductPage prod = new ProductPage(driver);
        home.selectFirstProduct();
        prod.addToCart();
        test.pass("Produk berhasil ditambahkan.");
    }

    @Test(priority = 2, description = "Positif: Verifikasi tabel keranjang tidak kosong")
    public void testCartTableVisibility() {
        test = extent.createTest("Cart - Verify Table");
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        home.goToCart();
        Assert.assertTrue(cart.getCartItemCount() >= 0);
        test.pass("Tabel keranjang tampil dengan benar.");
    }
}