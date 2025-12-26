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
        // Gunakan Explicit Wait yang lebih lama (30 detik) untuk mengatasi lag internet
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
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Metode yang tadi hilang (Penyebab error di HomePage)
    protected boolean isDisplayed(WebElement element) {
        try {
            waitForVisible(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Metode navigasi yang tadi hilang
    protected void navigateTo(String url) {
        driver.get(url);
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}