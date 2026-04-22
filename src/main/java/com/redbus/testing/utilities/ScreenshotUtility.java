package com.redbus.testing.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    // Capture screenshot and save in Screenshots folder
    public static String captureScreenshot(WebDriver driver, String name) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create unique file path using timestamp
            String path = "./Screenshots/" + name + "_" + System.currentTimeMillis() + ".png";

            Files.createDirectories(Paths.get("./Screenshots/"));
            Files.copy(src.toPath(), Paths.get(path));

            return path;

        } catch (IOException e) {

            // Print error if screenshot fails
            e.printStackTrace();
            return null;
        }
    }
}