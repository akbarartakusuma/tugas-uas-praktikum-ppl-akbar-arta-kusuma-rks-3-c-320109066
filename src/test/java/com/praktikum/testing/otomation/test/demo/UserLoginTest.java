package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class UserLoginTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Login dengan kredensial valid")
    public void testValidLogin() {
        test = extent.createTest("Login - Positive Test");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        // Pastikan akun ini sudah terdaftar. Jika belum, ganti dengan yang sudah ada.
        login.performLogin("admin_techmart", "admin123");

        // Menunggu hingga proses login selesai dan teks Welcome muncul
        test.info("Menunggu sinkronisasi status login di navbar");
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Verifikasi login berhasil
            Assert.assertTrue(home.isUserLoggedIn(), "Login Gagal! Teks Welcome tidak ditemukan.");
            test.pass("Login berhasil, status user terverifikasi.");
        } catch (Exception e) {
            test.fail("Gagal verifikasi login: " + e.getMessage());
            Assert.fail("Login verification failed.");
        }
    }

    @Test(priority = 2, description = "Negatif: Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Negative Test (Wrong Pass)");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("admin_techmart", "password_salah_123");

        test.info("Menangani alert 'Wrong password.'");
        login.acceptAlert();
        test.pass("Sistem berhasil menolak login dengan password salah.");
    }

    @Test(priority = 3, description = "Negatif: Login dengan kolom kredensial kosong")
    public void testEmptyLogin() {
        test = extent.createTest("Login - Empty Credentials Test");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("", "");

        test.info("Menangani alert 'Please fill out Username and Password.'");
        login.acceptAlert();
        test.pass("Sistem berhasil memberikan alert peringatan untuk kolom kosong.");
    }
}