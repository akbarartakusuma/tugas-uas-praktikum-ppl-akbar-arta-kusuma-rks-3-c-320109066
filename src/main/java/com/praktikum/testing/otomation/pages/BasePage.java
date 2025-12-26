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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
        // Delay singkat agar transisi modal/halaman stabil
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            waitForVisible(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }
}