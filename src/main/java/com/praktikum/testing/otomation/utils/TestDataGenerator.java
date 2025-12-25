package com.praktikum.testing.otomation.utils;

import java.util.Random;

public class TestDataGenerator {
    private static final Random random = new Random();

    public static String generateRandomUsername() {
        return "techmart_user_" + System.currentTimeMillis();
    }

    public static String generateRandomPassword() {
        return "Pass@" + (1000 + random.nextInt(9000));
    }

    public static String generateRandomName() {
        String[] names = {"Budi Santoso", "Siti Aminah", "Andi Wijaya", "Dewi Lestari"};
        return names[random.nextInt(names.length)];
    }
}