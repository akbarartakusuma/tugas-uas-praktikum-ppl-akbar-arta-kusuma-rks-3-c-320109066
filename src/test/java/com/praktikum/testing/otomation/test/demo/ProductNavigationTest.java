package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductNavigationTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Verifikasi akses detail produk")
    public void testAccessProductDetail() {
        test = extent.createTest("Navigation - Product Detail");
        HomePage home = new HomePage(driver);

        home.selectFirstProduct();
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        Assert.assertTrue(driver.getCurrentUrl().contains("prod.html"), "Gagal masuk ke halaman produk.");
        test.pass("Halaman detail produk terbuka.");
    }

    @Test(priority = 2, description = "Positif: Verifikasi navigasi kembali ke Home")
    public void testVerifyHomeLink() {
        test = extent.createTest("Navigation - Home Link");
        HomePage home = new HomePage(driver);

        home.selectFirstProduct();
        home.goToHomePage(); // Memanggil navigateTo dari BasePage

        // Menunggu halaman index.html termuat sempurna
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        Assert.assertTrue(driver.getCurrentUrl().contains("index.html"), "Gagal kembali ke Home.");
        test.pass("Navigasi kembali ke halaman utama berhasil.");
    }
}