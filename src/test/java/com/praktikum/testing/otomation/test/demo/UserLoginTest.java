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
        // Gunakan user yang sudah terdaftar secara manual atau via registrasi test
        login.performLogin("admin_techmart", "admin123");

        // Menunggu sistem memproses login sepenuhnya
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        Assert.assertTrue(home.isUserLoggedIn(), "Login Gagal! Teks Welcome tidak muncul di navbar.");
        test.pass("Login berhasil, status user terverifikasi.");
    }

    @Test(priority = 2, description = "Negatif: Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Negative Test (Wrong Pass)");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("admin_techmart", "password_salah_total");

        login.acceptAlert();
        test.pass("Sistem berhasil menolak login dengan kredensial salah.");
    }
}