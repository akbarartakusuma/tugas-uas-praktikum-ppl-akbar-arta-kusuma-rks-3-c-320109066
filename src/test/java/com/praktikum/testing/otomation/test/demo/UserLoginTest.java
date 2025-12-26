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

        test.info("Membuka menu Login");
        home.clickLogin();

        test.info("Melakukan login dengan user admin_techmart");
        // Pastikan user admin_techmart sudah terdaftar di sistem DemoBlaze
        login.performLogin("admin_techmart", "admin123");

        // Memberikan waktu bagi sistem untuk memproses login dan menampilkan teks Welcome
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Verifikasi apakah nama user muncul di navbar (menggunakan method isUserLoggedIn dari HomePage)
        Assert.assertTrue(home.isUserLoggedIn(), "Login Gagal! Teks Welcome tidak muncul di navbar.");
        test.pass("Login berhasil, status user terverifikasi di navbar.");
    }

    @Test(priority = 2, description = "Negatif: Login dengan password salah")
    public void testInvalidPassword() {
        test = extent.createTest("Login - Negative Test (Wrong Pass)");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        test.info("Membuka menu Login");
        home.clickLogin();

        test.info("Mencoba login dengan password yang salah");
        login.performLogin("admin_techmart", "password_salah_123");

        // DemoBlaze akan memunculkan alert browser "Wrong password."
        test.info("Menangani alert error dari browser");
        login.acceptAlert();
        test.pass("Sistem berhasil menolak akses dengan password salah.");
    }

    @Test(priority = 3, description = "Negatif: Login dengan kolom kredensial kosong")
    public void testEmptyLogin() {
        test = extent.createTest("Login - Empty Credentials Test");
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        test.info("Membuka menu Login");
        home.clickLogin();

        test.info("Klik login tanpa mengisi username dan password");
        login.performLogin("", "");

        // DemoBlaze memunculkan alert "Please fill out Username and Password."
        test.info("Menangani alert peringatan kolom kosong");
        login.acceptAlert();
        test.pass("Sistem berhasil memberikan alert peringatan untuk kolom kosong.");
    }
}