package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import com.praktikum.testing.otomation.utils.TestDataGenerator;
import org.testng.annotations.Test;

public class UserRegistrationTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Registrasi user baru dengan data unik")
    public void testSuccessfulRegistration() {
        test = extent.createTest("Registration - Positive Test");
        HomePage home = new HomePage(driver);
        RegistrationPage reg = new RegistrationPage(driver);

        home.clickRegister();
        String user = TestDataGenerator.generateRandomUsername();
        test.info("Mendaftar dengan username: " + user);
        reg.registerUser(user, "Pass123!");
        test.pass("Registrasi berhasil.");
    }

    @Test(priority = 2, description = "Negatif: Registrasi dengan username yang sudah terdaftar")
    public void testDuplicateUserRegistration() {
        test = extent.createTest("Registration - Negative Test (Duplicate)");
        HomePage home = new HomePage(driver);
        RegistrationPage reg = new RegistrationPage(driver);

        home.clickRegister();
        test.info("Mencoba mendaftar dengan user 'admin'");
        reg.registerUser("admin", "admin123");
        test.pass("Sistem memberikan alert error 'This user already exists'.");
    }
}