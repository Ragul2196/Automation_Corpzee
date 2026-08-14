package com.corpzee.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    private WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {

        this.driver = driver;

    }

    public String capture(String fileName) {

        String time =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String path =
                "screenshots/"
                        + fileName
                        + "_"
                        + time
                        + ".png";

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        File destination =
                new File(path);

        destination.getParentFile().mkdirs();

        try {

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return destination.getAbsolutePath();

    }

}