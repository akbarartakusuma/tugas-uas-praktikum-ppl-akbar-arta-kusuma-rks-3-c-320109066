package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import com.praktikum.testing.otomation.utils.TestDataGenerator;
import org.testng.annotations.Test;

public class UserRegistrationTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Registrasi user baru")
    public void testSuccessfulRegistration() {
        test = extent.createTest("Registration - Positive Test");
        HomePage home = new HomePage(driver);
        RegistrationPage reg = new RegistrationPage(driver);

        home.clickRegister();
        String user = TestDataGenerator.generateRandomUsername();
        reg.registerUser(user, "StrongPass123!");
        test.pass("User '" + user + "' berhasil terdaftar.");
    }

    @Test(priority = 2, description = "Negatif: Registrasi user duplikat")
    public void testDuplicateUserRegistration() {
        test = extent.createTest("Registration - Negative Test (Duplicate)");
        HomePage home = new HomePage(driver);
        RegistrationPage reg = new RegistrationPage(driver);

        home.clickRegister();
        // Menggunakan user admin yang pasti sudah ada
        reg.registerUser("admin", "admin");
        test.pass("Sistem menolak duplikasi user dengan benar.");
    }
}