package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import com.praktikum.testing.otomation.utils.TestDataGenerator;
import org.testng.annotations.Test;

public class AlertHandlingDemoblazeTest extends BaseTest {

    @Test(priority = 1, description = "Verifikasi alert saat registrasi berhasil")
    public void testRegistrationAlert() {
        test = extent.createTest("Alert - Registration Success");
        HomePage home = new HomePage(driver);
        RegistrationPage reg = new RegistrationPage(driver);

        home.clickRegister();
        reg.registerUser(TestDataGenerator.generateRandomUsername(), "AlertPass123");
        test.pass("Alert registrasi berhasil ditangani.");
    }

    @Test(priority = 2, description = "Verifikasi alert saat menambah produk")
    public void testAddToCartAlert() {
        test = extent.createTest("Alert - Add to Cart Success");
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);

        home.selectFirstProduct();
        product.addToCart();
        test.pass("Alert 'Product added' berhasil ditangani.");
    }
}