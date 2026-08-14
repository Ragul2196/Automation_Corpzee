package com.corpzee.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtils {

    private WebDriver driver;

    public ScrollUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(WebElement element) {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth',block:'center'});",
                element);

    }

    public void scrollToTop() {

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0,0);");

    }

    public void scrollToBottom() {

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0,document.body.scrollHeight);");

    }

    public void scrollBy(int x, int y) {

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(arguments[0],arguments[1]);", x, y);

    }

    public void jsClick(WebElement element) {

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);

    }

}