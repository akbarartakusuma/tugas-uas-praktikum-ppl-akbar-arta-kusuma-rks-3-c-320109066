package com.praktikum.testing.otomation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Kita tingkatkan waktu tunggu menjadi 30 detik untuk mengantisipasi lag internet
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    protected void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void enterText(WebElement element, String text) {
        waitForVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        // Menunggu elemen benar-benar bisa diklik
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean isUserLoggedIn(WebElement welcomeElement) {
        try {
            // Menunggu hingga teks "Welcome" muncul di navbar
            wait.until(ExpectedConditions.visibilityOf(welcomeElement));
            return welcomeElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void acceptAlert() {
        // Menunggu alert browser muncul sebelum diklik
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}