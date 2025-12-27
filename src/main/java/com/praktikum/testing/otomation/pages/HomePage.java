package com.praktikum.testing.otomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(id = "login2")
    private WebElement loginMenu;

    @FindBy(id = "nameofuser")
    private WebElement userWelcomeMsg;

    @FindBy(xpath = "//a[contains(text(),'Samsung galaxy s6')]")
    private WebElement firstProduct;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // REVISI: Menunggu elemen 'Welcome' muncul secara dinamis
    public boolean isUserLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userWelcomeMsg));
            return userWelcomeMsg.isDisplayed() && userWelcomeMsg.getText().contains("Welcome");
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogin() { click(loginMenu); }
    public void goToCart() { click(driver.findElement(org.openqa.selenium.By.id("cartur"))); }
    public void selectFirstProduct() { click(firstProduct); }
    public void goToHomePage() { navigateTo("https://www.demoblaze.com/index.html"); }
}