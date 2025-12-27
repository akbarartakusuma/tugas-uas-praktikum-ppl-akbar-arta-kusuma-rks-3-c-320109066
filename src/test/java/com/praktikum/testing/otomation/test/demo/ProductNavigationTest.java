package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

// Pastikan nama class SAMA dengan nama file: ProductNavigationTest
public class ProductNavigationTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Verifikasi akses ke detail produk")
    public void testAccessProductDetail() {
        test = extent.createTest("Navigation - Product Detail");
        HomePage home = new HomePage(driver);

        test.info("Memilih produk pertama di halaman utama");
        home.selectFirstProduct();

        // Menunggu perpindahan halaman
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        Assert.assertTrue(driver.getCurrentUrl().contains("prod.html"), "Gagal masuk ke detail produk!");
        test.pass("Halaman detail produk berhasil terbuka.");
    }

    @Test(priority = 2, description = "Positif: Verifikasi navigasi kembali ke Home")
    public void testVerifyHomeLink() {
        test = extent.createTest("Navigation - Home Link");
        HomePage home = new HomePage(driver);

        test.info("Masuk ke detail produk lalu klik menu Home");
        home.selectFirstProduct();
        home.goToHomePage(); // Memanggil navigateTo dari BasePage

        // Jeda untuk sinkronisasi pemuatan halaman utama
        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

        Assert.assertTrue(driver.getCurrentUrl().contains("index.html"), "Gagal kembali ke halaman utama!");
        test.pass("Navigasi kembali ke halaman utama berhasil.");
    }
}