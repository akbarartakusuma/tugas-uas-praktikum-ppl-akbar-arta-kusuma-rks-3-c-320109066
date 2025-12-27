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
        // Pastikan user admin_techmart sudah terdaftar secara manual atau di test sebelumnya
        login.performLogin("admin_techmart", "admin123");

        // Memberikan jeda waktu agar teks 'Welcome' muncul sepenuhnya di navbar
        try { Thread.sleep(4000); } catch (InterruptedException e) { e.printStackTrace(); }

        Assert.assertTrue(home.isUserLoggedIn(), "Login Gagal! Teks Welcome tidak ditemukan.");
        test.pass("Login berhasil, username terverifikasi di navbar.");
    }

    @Test(priority = 2, description = "Negatif: Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Negative Test (Wrong Pass)");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("admin_techmart", "salah_pass123");

        login.acceptAlert();
        test.pass("Sistem berhasil menolak login dengan password salah.");
    }
}