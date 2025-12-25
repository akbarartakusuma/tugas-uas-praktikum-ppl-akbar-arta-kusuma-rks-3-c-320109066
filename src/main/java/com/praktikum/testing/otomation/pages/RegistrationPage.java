package com.praktikum.testing.otomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(id = "sign-username")
    private WebElement usernameInput;

    @FindBy(id = "sign-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    private WebElement signUpButton;

    @FindBy(id = "signInModal")
    private WebElement signUpModal;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser(String username, String password) {
        waitForVisible(signUpModal);
        enterText(usernameInput, username);
        enterText(passwordInput, password);
        click(signUpButton);
        acceptAlert(); // Menangani alert "Sign up successful"
    }
}