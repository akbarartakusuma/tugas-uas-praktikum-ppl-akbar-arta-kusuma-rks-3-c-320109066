package com.praktikum.testing.otomation.test.demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.praktikum.testing.otomation.utils.ExtentReportManager; // Sesuaikan package
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent = ExtentReportManager.getInstance();
    protected ExtentTest test;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}