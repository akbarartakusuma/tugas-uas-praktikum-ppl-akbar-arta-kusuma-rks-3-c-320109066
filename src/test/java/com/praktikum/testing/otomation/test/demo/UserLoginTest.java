package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginTest extends BaseTest {

    @Test(priority = 1, description = "Login dengan kredensial valid")
    public void testValidLogin() {
        test = extent.createTest("Login - Valid Credentials");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        test.info("Melakukan login dengan user admin_techmart");
        login.performLogin("admin_techmart", "admin123");

        Assert.assertTrue(home.isUserLoggedIn(), "User gagal login!");
        test.pass("Login berhasil, username muncul di navbar.");
    }

    @Test(priority = 2, description = "Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Wrong Password");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.clickLogin();
        test.info("Mencoba login dengan password yang salah");
        login.performLogin("admin_techmart", "salah_password");

        test.info("Menangani alert error dari browser");
        login.acceptAlert();
        test.pass("Sistem berhasil menolak akses dengan password salah.");
    }
}