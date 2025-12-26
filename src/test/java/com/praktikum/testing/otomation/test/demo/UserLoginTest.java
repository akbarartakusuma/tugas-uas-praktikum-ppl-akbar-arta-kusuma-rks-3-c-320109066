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
        // Gunakan kredensial yang valid
        login.performLogin("admin_techmart", "admin123");

        // Memanggil fungsi verifikasi login yang sudah ada di HomePage (lewat BasePage)
        test.info("Memverifikasi keberhasilan login di navbar...");
        boolean isLoggedIn = home.isUserLoggedIn();

        Assert.assertTrue(isLoggedIn, "Login Gagal! Teks Welcome tidak ditemukan dalam waktu yang ditentukan.");
        test.pass("Login berhasil, username terdeteksi di navbar.");
    }

    @Test(priority = 2, description = "Negatif: Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Negative Test (Wrong Pass)");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("admin_techmart", "salah123");

        test.info("Menunggu dan menutup alert 'Wrong password.'");
        login.acceptAlert();
        test.pass("Sistem berhasil menolak login dengan password salah.");
    }
}