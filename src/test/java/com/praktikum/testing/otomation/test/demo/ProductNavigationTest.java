package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductNavigationTest extends BaseTest {

    @Test(priority = 1, description = "Verifikasi navigasi detail produk")
    public void testViewProductDetail() {
        test = extent.createTest("Navigation - Product Detail");
        HomePage home = new HomePage(driver);
        home.selectFirstProduct();
        Assert.assertTrue(driver.getCurrentUrl().contains("prod.html"), "URL tidak sesuai!");
        test.pass("Berhasil masuk ke halaman detail produk.");
    }

    @Test(priority = 2, description = "Verifikasi fungsionalitas tombol Home")
    public void testBackToHome() {
        test = extent.createTest("Navigation - Back to Home");
        HomePage home = new HomePage(driver);
        home.selectFirstProduct();
        home.goToHomePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("index.html"));
        test.pass("Berhasil kembali ke halaman utama.");
    }
}