package com.praktikum.testing.otomation.test.demo; // Package harus test.demo

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.praktikum.testing.otomation.utils.ExtentReportManager;
import com.praktikum.testing.otomation.utils.ScreenshotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
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
    public void tearDown(ITestResult result) {
        if (test != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                // Mengambil screenshot jika test Gagal
                String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
                test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                test.fail(result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test Passed");
            }
        }
        if (driver != null) driver.quit();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}