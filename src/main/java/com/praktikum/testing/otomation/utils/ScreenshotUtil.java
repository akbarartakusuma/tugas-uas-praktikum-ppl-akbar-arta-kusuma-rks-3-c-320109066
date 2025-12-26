package com.praktikum.testing.otomation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Folder tujuan screenshot sesuai struktur project Anda
        String destination = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + "_" + timestamp + ".png";
        File finalDestination = new File(destination);

        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Mengembalikan path relatif untuk laporan
        return "screenshots/" + screenshotName + "_" + timestamp + ".png";
    }
}