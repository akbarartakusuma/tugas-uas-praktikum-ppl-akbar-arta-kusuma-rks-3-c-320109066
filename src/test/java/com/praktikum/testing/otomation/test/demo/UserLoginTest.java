package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Login dengan kredensial valid")
    public void testValidLogin() {
        test = extent.createTest("Login - Positive Test");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        // Pastikan akun admin_techmart sudah ada.
        // Jika belum, gunakan akun yang Anda buat di testSuccessfulRegistration
        login.performLogin("admin_techmart", "admin123");

        test.info("Menunggu sinkronisasi status login di navbar...");
        // Tambahkan delay lebih lama karena server DemoBlaze sering lambat memuat session
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        boolean loggedIn = home.isUserLoggedIn();
        Assert.assertTrue(loggedIn, "Login Gagal! Teks Welcome tidak ditemukan di navbar.");
        test.pass("Login berhasil, status user terverifikasi.");
    }

    @Test(priority = 2, description = "Negatif: Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Negative Test (Wrong Pass)");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("admin_techmart", "salah_password_total");

        test.info("Menangani alert 'Wrong password.'");
        login.acceptAlert();
        test.pass("Sistem berhasil menolak login dengan password salah.");
    }
}