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

        // Pastikan akun admin_techmart sudah terdaftar secara manual di web
        test.info("Input kredensial login");
        login.performLogin("admin_techmart", "admin123");

        test.info("Menunggu sinkronisasi login di navbar...");

        // Memanggil isUserLoggedIn yang sudah memiliki fungsi wait otomatis
        Assert.assertTrue(home.isUserLoggedIn(), "Login Gagal! Teks Welcome tidak muncul.");
        test.pass("Login berhasil, status user terverifikasi.");
    }

    @Test(priority = 2, description = "Negatif: Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Negative Test (Wrong Pass)");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("admin_techmart", "salah_total_123");

        login.acceptAlert();
        test.pass("Sistem menolak login dengan password salah.");
    }
}