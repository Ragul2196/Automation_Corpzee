package com.corpzee.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadUtils {

    private WebDriver driver;

    public FileUploadUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Upload using WebElement
    public void upload(WebElement element, String filePath) {

        element.sendKeys(filePath);

    }

    // Upload by Locator
    public void upload(By locator, String filePath) {

        driver.findElement(locator).sendKeys(filePath);

    }

    // Upload by Index (Useful when all file inputs have same id)
    public void uploadByIndex(By locator, int index, String filePath) {

        List<WebElement> files = driver.findElements(locator);

        if (index < files.size()) {

            files.get(index).sendKeys(filePath);

        } else {

            throw new RuntimeException("Invalid upload index : " + index);

        }

    }

}