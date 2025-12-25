package com.praktikum.testing.otomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "name") private WebElement nameField;
    @FindBy(id = "card") private WebElement cardField;
    @FindBy(xpath = "//button[contains(text(),'Purchase')]") private WebElement purchaseBtn;
    @FindBy(css = ".sweet-alert h2") private WebElement successMsg;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void completePurchase(String name, String card) {
        enterText(nameField, name);
        enterText(cardField, card);
        click(purchaseBtn);
    }

    public String getConfirmation() {
        return successMsg.getText();
    }
}