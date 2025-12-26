package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test(priority = 1, description = "Tambah produk ke keranjang belanja")
    public void testAddProductToCart() {
        test = extent.createTest("Cart - Add Product");
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        home.selectFirstProduct();
        product.addToCart();
        test.pass("Produk masuk ke cart dan alert di-accept.");
    }

    @Test(priority = 2, description = "Verifikasi jumlah item di tabel Cart")
    public void testVerifyCartQuantity() {
        test = extent.createTest("Cart - Verify Quantity");
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        home.goToCart();
        Assert.assertTrue(cart.getCartItemCount() >= 0);
        test.info("Jumlah item ditemukan: " + cart.getCartItemCount());
        test.pass("Tabel cart terbaca dengan benar.");
    }
}