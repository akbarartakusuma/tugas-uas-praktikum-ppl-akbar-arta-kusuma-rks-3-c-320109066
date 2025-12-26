package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import com.praktikum.testing.otomation.utils.TestDataGenerator;
import org.testng.annotations.Test;

public class UserRegistrationTest extends BaseTest {

    @Test(priority = 1, description = "Registrasi dengan data valid")
    public void testSuccessfulRegistration() {
        test = extent.createTest("Registration - Valid Data");
        HomePage home = new HomePage(driver);
        RegistrationPage reg = new RegistrationPage(driver);
        home.clickRegister();
        reg.registerUser(TestDataGenerator.generateRandomUsername(), "Password123");
        test.pass("User berhasil mendaftar dan alert ditutup.");
    }

    @Test(priority = 2, description = "Registrasi dengan user yang sudah ada")
    public void testDuplicateRegistration() {
        test = extent.createTest("Registration - Duplicate User");
        HomePage home = new HomePage(driver);
        RegistrationPage reg = new RegistrationPage(driver);
        home.clickRegister();
        // Menggunakan user statis yang kemungkinan sudah ada
        reg.registerUser("admin", "admin");
        test.info("Alert muncul: This user already exists.");
        test.pass("Sistem berhasil menolak user duplikat.");
    }
}