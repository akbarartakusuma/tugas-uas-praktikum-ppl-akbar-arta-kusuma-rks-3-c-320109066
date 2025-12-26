package com.praktikum.testing.otomation.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutUsTest extends BaseTest {

    @Test(description = "Verifikasi pemutar video pada menu About Us")
    public void testAboutUsVideoModal() {
        test = extent.createTest("About Us - Video Modal Test");

        test.info("Membuka menu About Us");
        driver.findElement(By.linkText("About us")).click();

        test.info("Memeriksa keberadaan elemen video");
        WebElement videoElement = driver.findElement(By.id("example-video_html5_api"));

        Assert.assertTrue(videoElement.isDisplayed(), "Elemen video tidak muncul!");

        test.info("Menutup modal video");
        driver.findElement(By.xpath("//div[@id='videoModal']//button[text()='Close']")).click();

        test.pass("Modal About Us dan video berfungsi dengan baik.");
    }
}