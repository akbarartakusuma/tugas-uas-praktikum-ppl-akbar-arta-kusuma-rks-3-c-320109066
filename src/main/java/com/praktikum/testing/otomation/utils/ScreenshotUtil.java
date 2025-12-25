package com.praktikum.testing.otomation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destination = System.getProperty("user.dir") + "/src/test/resources/screenshots/" +
                    screenshotName + "_" + timestamp + ".png";

            File destFile = new File(destination);
            destFile.getParentFile().mkdirs();
            FileUtils.copyFile(source, destFile);

            return destination;
        } catch (Exception e) {
            System.out.println("Gagal mengambil screenshot: " + e.getMessage());
            return null;
        }
    }
}