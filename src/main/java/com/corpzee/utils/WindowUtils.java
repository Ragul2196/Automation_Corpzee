package com.corpzee.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowUtils {

    private WebDriver driver;

    public WindowUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewWindow() {

        String parent = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parent)) {

                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void switchToParentWindow() {

        String parent = driver.getWindowHandles().iterator().next();

        driver.switchTo().window(parent);
    }

    public void closeCurrentWindow() {

        driver.close();

    }

    public void switchToWindowByTitle(String title) {

        for (String window : driver.getWindowHandles()) {

            driver.switchTo().window(window);

            if (driver.getTitle().contains(title)) {

                break;
            }
        }
    }

}