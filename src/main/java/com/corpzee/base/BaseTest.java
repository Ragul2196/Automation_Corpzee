package com.corpzee.base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait wait;

    public void launchBrowser() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ragulsacariya\\Automation\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://uat-corphub.inetcsc.com");
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public void type(WebElement element, String value) {

        wait.until(ExpectedConditions.visibilityOf(element));

        element.clear();

        element.sendKeys(value);
    }

    public void scrollIntoView(WebElement element) {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element);

    }

    public void closeBrowser() {

        if (driver != null)

            driver.quit();

    }

}