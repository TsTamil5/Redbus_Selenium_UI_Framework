package com.redbus.testing.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String takeScreenshotAsBase64(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public static byte[] takeScreenshotAsBytes(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static String saveScreenshot(WebDriver driver, String name) throws IOException {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String time =
            new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String path =
            "target/screenshots/" + name + "_" + time + ".png";

        File dest = new File(path);
        dest.getParentFile().mkdirs();

        Files.copy(src.toPath(), dest.toPath());

        return dest.getAbsolutePath();
    }
}