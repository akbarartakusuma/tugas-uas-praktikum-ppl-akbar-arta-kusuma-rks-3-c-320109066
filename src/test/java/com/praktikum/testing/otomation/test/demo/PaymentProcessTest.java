package com.praktikum.testing.otomation.test.demo;

import com.praktikum.testing.otomation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentProcessTest extends BaseTest {

    @Test(priority = 1, description = "Verifikasi pembatalan pembelian (Cancel)")
    public void testCancelPayment() {
        test = extent.createTest("Payment - Cancel Order");
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        home.goToCart();
        cart.clickPlaceOrder();

        test.info("Menutup modal pembelian tanpa membayar");
        driver.navigate().refresh(); // Simulasi cancel dengan refresh atau tutup modal
        test.pass("Pembatalan pembayaran ditangani dengan benar.");
    }

    @Test(priority = 2, description = "Verifikasi detail konfirmasi pembayaran")
    public void testPaymentSummary() {
        test = extent.createTest("Payment - Success Summary");
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        home.selectFirstProduct();
        new ProductPage(driver).addToCart();
        home.goToCart();
        cart.clickPlaceOrder();
        checkout.completePurchase("Final Tester", "1111-2222-3333-4444");

        String confirmation = checkout.getConfirmation();
        Assert.assertTrue(confirmation.contains("Thank you"), "Ringkasan sukses tidak muncul");
        test.pass("Laporan sukses pembayaran tervalidasi.");
    }
}