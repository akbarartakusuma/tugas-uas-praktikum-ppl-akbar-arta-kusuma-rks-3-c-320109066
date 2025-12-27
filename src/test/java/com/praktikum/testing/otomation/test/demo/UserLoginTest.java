package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import com.praktikum.testing.otomation.utils.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Login dengan user yang baru didaftarkan")
    public void testValidLogin() {
        test = extent.createTest("Login - Positive Test");
        HomePage home = new HomePage(driver);
        RegistrationPage reg = new RegistrationPage(driver);
        LoginPage login = new LoginPage(driver);

        // LANGKAH PENTING: Daftar dulu agar user PASTI ada di database
        String user = TestDataGenerator.generateRandomUsername();
        String pass = "Pass123!";

        test.info("Mendaftarkan user baru: " + user);
        home.clickRegister();
        reg.registerUser(user, pass);

        // Melakukan Login
        test.info("Melakukan login dengan user baru tersebut");
        home.clickLogin();
        login.performLogin(user, pass);

        test.info("Menunggu sinkronisasi login di navbar...");
        // Memanggil isUserLoggedIn yang sudah memiliki wait dinamis di HomePage
        Assert.assertTrue(home.isUserLoggedIn(), "Login Gagal! Teks Welcome tidak muncul untuk user: " + user);
        test.pass("Login berhasil, username '" + user + "' terverifikasi di navbar.");
    }

    @Test(priority = 2, description = "Negatif: Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Negative Test (Wrong Pass)");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        login.performLogin("admin_techmart", "salah_password_123");

        login.acceptAlert();
        test.pass("Sistem berhasil menolak login dengan password salah.");
    }
}