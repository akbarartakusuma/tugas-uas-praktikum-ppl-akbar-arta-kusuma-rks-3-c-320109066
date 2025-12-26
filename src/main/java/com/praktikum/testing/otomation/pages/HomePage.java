package com.praktikum.testing.otomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "login2")
    private WebElement loginMenu;

    @FindBy(id = "signin2")
    private WebElement registerMenu;

    @FindBy(id = "cartur")
    private WebElement cartMenu;

    @FindBy(id = "nameofuser")
    private WebElement userWelcomeMsg;

    @FindBy(xpath = "//a[contains(text(),'Samsung galaxy s6')]")
    private WebElement firstProduct;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(userWelcomeMsg);
    }

    public void clickLogin() { click(loginMenu); }
    public void clickRegister() { click(registerMenu); }
    public void goToCart() { click(cartMenu); }
    public void selectFirstProduct() { click(firstProduct); }
    public void goToHomePage() { navigateTo("https://www.demoblaze.com/"); }
}