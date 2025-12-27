package com.praktikum.testing.otomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(id = "login2")
    private WebElement loginMenu;

    @FindBy(id = "signin2")
    private WebElement registerMenu; // Elemen untuk Sign Up

    @FindBy(id = "cartur")
    private WebElement cartMenu;

    @FindBy(id = "nameofuser")
    private WebElement userWelcomeMsg;

    @FindBy(xpath = "//a[contains(text(),'Samsung galaxy s6')]")
    private WebElement firstProduct;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Metode untuk mengecek login dengan Explicit Wait
    public boolean isUserLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userWelcomeMsg));
            return userWelcomeMsg.isDisplayed() && userWelcomeMsg.getText().contains("Welcome");
        } catch (Exception e) {
            return false;
        }
    }

    // Metode navigasi yang dibutuhkan
    public void clickLogin() { click(loginMenu); }

    public void clickRegister() { click(registerMenu); } // Memperbaiki error 'cannot find symbol'

    public void goToCart() { click(cartMenu); }

    public void selectFirstProduct() { click(firstProduct); }

    public void goToHomePage() { navigateTo("https://www.demoblaze.com/index.html"); }
}