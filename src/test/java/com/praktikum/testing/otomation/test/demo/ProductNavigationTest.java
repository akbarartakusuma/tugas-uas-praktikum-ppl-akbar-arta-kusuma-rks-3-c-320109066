package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductNavigationTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Verifikasi akses ke detail produk")
    public void testAccessProductDetail() {
        test = extent.createTest("Navigation - Product Detail");
        HomePage home = new HomePage(driver);
        home.selectFirstProduct();
        Assert.assertTrue(driver.getCurrentUrl().contains("prod.html"));
        test.pass("Berhasil masuk ke halaman produk.");
    }

    @Test(priority = 2, description = "Positif: Verifikasi tombol Home berfungsi")
    public void testVerifyHomeLink() {
        test = extent.createTest("Navigation - Home Link");
        HomePage home = new HomePage(driver);
        home.selectFirstProduct();
        home.goToHomePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("index.html"));
        test.pass("Tombol Home berfungsi dengan baik.");
    }
}