package com.praktikum.testing.otomation.test.demo;

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
            // REVISI: Selalu ambil screenshot untuk setiap test yang selesai
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());

            if (result.getStatus() == ITestResult.FAILURE) {
                // Lampiran screenshot untuk status FAIL
                test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                test.fail(result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                // REVISI: Tambahkan lampiran screenshot untuk status PASS
                test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}