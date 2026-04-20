package com.redbus.testing.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    private static final String SCREENSHOT_DIR = "target/screenshots/";

    public static String takeScreenshot(WebDriver driver, String screenshotName) {

        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm:ss").format(new Date());
        String fileName  = "Failure Screenshot" + screenshotName;
        String filePath  = SCREENSHOT_DIR + fileName;

        try {
            File srcFile  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(filePath);
            destFile.getParentFile().mkdirs();
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }

        return new File(filePath).getAbsolutePath();
    }

    public static String takeScreenshotAsBase64(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}