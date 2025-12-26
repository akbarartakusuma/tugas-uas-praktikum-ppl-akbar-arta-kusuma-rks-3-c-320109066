package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Login dengan kredensial valid")
    public void testValidLogin() {
        test = extent.createTest("Login - Positive Test");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("admin_techmart", "admin123");

        // Menggunakan Explicit Wait langsung di test case untuk kepastian
        test.info("Menunggu teks Welcome muncul di navbar...");
        try {
            // Memberi waktu maksimal 10 detik agar sistem memproses login
            Thread.sleep(3000);
            Assert.assertTrue(home.isUserLoggedIn(), "Login Gagal! Teks Welcome tidak ditemukan.");
            test.pass("Login Berhasil: Username admin_techmart terdeteksi.");
        } catch (Exception e) {
            test.fail("Verifikasi login gagal setelah menunggu: " + e.getMessage());
            Assert.fail("Login verification failed.");
        }
    }
}