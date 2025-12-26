package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoblazeNavigationAndFlowTest extends BaseTest {

    @Test(priority = 1, description = "Navigasi antar kategori produk")
    public void testCategoryNavigation() {
        test = extent.createTest("Flow - Category Switching");
        HomePage home = new HomePage(driver);

        test.info("Membuka halaman Home");
        home.goToHomePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("index.html"));

        test.info("Membuka menu Cart via navigasi");
        home.goToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
        test.pass("Navigasi antar menu utama lancar.");
    }

    @Test(priority = 2, description = "Verifikasi logo kembali ke halaman utama")
    public void testLogoRedirection() {
        test = extent.createTest("Flow - Logo Redirect");
        HomePage home = new HomePage(driver);
        home.goToCart();
        home.goToHomePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("index.html"));
        test.pass("Klik Logo berhasil mengarahkan kembali ke Home.");
    }
}