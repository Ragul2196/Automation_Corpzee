package com.corpzee.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.corpzee.base.BaseTest;

public class LoginPage extends BaseTest {

    // Constructor
    public LoginPage() {

        this.driver = BaseTest.driver;
        this.wait = BaseTest.wait;
    }

    public void login(String username, String password) {

        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@class,'nav-login-btn')]")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", loginBtn);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("kc-login")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("username")));
    }
}