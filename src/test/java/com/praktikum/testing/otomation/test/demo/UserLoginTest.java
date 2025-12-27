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
        // Pastikan akun admin_techmart sudah terdaftar secara manual di web DemoBlaze
        login.performLogin("admin_techmart", "admin123");

        test.info("Menunggu sinkronisasi status login di navbar...");
        // Gunakan jeda 5 detik agar server sempat memberikan respon 'Welcome'
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Memanggil isUserLoggedIn yang sudah menggunakan Explicit Wait di BasePage
        Assert.assertTrue(home.isUserLoggedIn(), "Login Gagal! Teks Welcome tidak muncul.");
        test.pass("Login berhasil, username terdeteksi di navbar.");
    }

    @Test(priority = 2, description = "Negatif: Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Negative Test (Wrong Pass)");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("admin_techmart", "salah_total_123");

        test.info("Menutup alert error...");
        login.acceptAlert();
        test.pass("Sistem menolak login dengan password salah.");
    }
}