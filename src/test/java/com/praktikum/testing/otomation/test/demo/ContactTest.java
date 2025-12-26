package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    @Test(priority = 1, description = "Positif: Mengirim pesan melalui menu Contact")
    public void testSendMessage() {
        test = extent.createTest("Contact - Send Message Positive");

        test.info("Membuka menu Contact");
        driver.findElement(By.linkText("Contact")).click();

        test.info("Mengisi data kontak");
        driver.findElement(By.id("recipient-email")).sendKeys("qa_tester@techmart.com");
        driver.findElement(By.id("recipient-name")).sendKeys("TechMart QA Team");
        driver.findElement(By.id("message-text")).sendKeys("Ini adalah pesan testing otomasi.");

        test.info("Klik tombol Send Message");
        driver.findElement(By.xpath("//button[contains(text(),'Send message')]")).click();

        // Handle alert "Thanks for the message!!"
        test.info("Menangani alert konfirmasi");
        handleBrowserAlert();
        test.pass("Pesan berhasil dikirim.");
    }

    private void handleBrowserAlert() {
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}