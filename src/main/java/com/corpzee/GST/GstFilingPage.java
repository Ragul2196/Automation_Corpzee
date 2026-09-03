package com.corpzee.GST;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GstFilingPage {

     WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public GstFilingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ================= LOCATORS =================

    public By taxType = By.cssSelector(
            "mat-select[formControlName='taxtype']");

    public By state = By.cssSelector(
            "mat-select[formControlName='state']");

    public By gstFrequency = By.cssSelector(
            "mat-select[formControlName='gstfrequency']");

    public By taxPeriod = By.cssSelector(
            "mat-select[formControlName='taxperiod']");

    public By applicationFile = By.id("attachment");

    public By gstin = By.id("gstin");

    public By mobileNo = By.id("mobileNo");

    public By taxpayerName = By.id("name");

    public By email = By.id("emailId");

    public By tradeTaxpayer = By.id("tradeTaxpay");

    public By invoice = By.id("invoice");

    public By gstUserId = By.id("gstuserId");

    public By gstPassword = By.id("gstPassword");

    public By salesFile = By.id("uploadSale");

    public By purchaseFile = By.id("purchaseform");

    public By submitButton = By.xpath(
    	    "//button[normalize-space()='Submit']"
    	);

    	public By cancelButton = By.xpath(
    	    "//button[normalize-space()='Cancel']"
    	);
    
    
    public By ClickConfirm = By.xpath("/html/body/div[3]/div/div[6]/button[1]");


    // ================= DROPDOWN =================

    public void selectMatOption(By dropdown, String optionText) {

        wait.until(
                ExpectedConditions.elementToBeClickable(dropdown)
        ).click();

        By option = By.xpath(
                "//div[contains(@class,'cdk-overlay-container')]" +
                "//mat-option[normalize-space()='" +
                optionText + "']"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(option)
        ).click();
    }


    // ================= TAX TYPE =================

    public void selectTaxType(String taxTypeName) {
        selectMatOption(taxType, taxTypeName);
    }


    // ================= STATE =================

    public void selectState(String stateName) {
        selectMatOption(state, stateName);
    }


    // ================= GST FREQUENCY =================

    public void selectGstFrequency(String frequency) {
        selectMatOption(gstFrequency, frequency);
    }


    // ================= TAX PERIOD =================

    public void selectTaxPeriod(String period) {
        selectMatOption(taxPeriod, period);
    }


    // ================= TEXT FIELDS =================

    public void enterGSTIN(String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(gstin)
        );

        element.clear();
        element.sendKeys(value);
    }


    public void enterMobileNo(String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(mobileNo)
        );

        element.clear();
        element.sendKeys(value);
    }


    public void enterTaxpayerName(String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(taxpayerName)
        );

        element.clear();
        element.sendKeys(value);
    }


    public void enterEmail(String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(email)
        );

        element.clear();
        element.sendKeys(value);
    }


    public void enterTradeTaxpayer(String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(tradeTaxpayer)
        );

        element.clear();
        element.sendKeys(value);
    }


    public void enterInvoice(String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(invoice)
        );

        element.clear();
        element.sendKeys(value);
    }


    public void enterGstUserId(String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(gstUserId)
        );

        element.clear();
        element.sendKeys(value);
    }


    public void enterGstPassword(String value) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(gstPassword)
        );

        element.clear();
        element.sendKeys(value);
    }


    // ================= FILE UPLOAD =================

    public void uploadApplication(String filePath) {

        wait.until(
                ExpectedConditions.presenceOfElementLocated(applicationFile)
        ).sendKeys(filePath);
    }


    public void uploadSalesFile(String filePath) {

        wait.until(
                ExpectedConditions.presenceOfElementLocated(salesFile)
        ).sendKeys(filePath);
    }


    public void uploadPurchaseFile(String filePath) {

        wait.until(
                ExpectedConditions.presenceOfElementLocated(purchaseFile)
        ).sendKeys(filePath);
    }


    
    public void clicksubmit() {

        WebElement submit = wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", submit
        );
    }
    
    public String confirmServiceCharge() {

    	 By confirmationMessage = By.xpath(
 	            "//*[contains(normalize-space(), 'Service Charge:') " +
 	            "and contains(normalize-space(), 'will be deducted')]"
 	        );

 	        WebElement message = wait.until(
 	            ExpectedConditions.visibilityOfElementLocated(confirmationMessage)
 	        );

 	        String text = message.getText();

 	        // Extract Service Charge amount
 	        Pattern pattern = Pattern.compile(
 	            "Service Charge:\\s*₹\\s*([0-9]+(?:\\.[0-9]+)?)"
 	        );

 	        Matcher matcher = pattern.matcher(text);

 	        String serviceCharge = "";

 	        if (matcher.find()) {
 	            serviceCharge = matcher.group(1);
 	        }

 	        // Print ONLY required messages
			/* System.out.println("Service Charge: ₹" + serviceCharge); */

 	        // Click Confirm
 	        By confirmButton = By.xpath(
 	            "//button[normalize-space()='Confirm']"
 	        );

 	        wait.until(
 	            ExpectedConditions.elementToBeClickable(confirmButton)
 	        ).click();

 	        return serviceCharge;
    }
    
    public String handleSuccessMessage() {

        WebElement message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".swal2-html-container")
            )
        );

        String text = message.getText();

        System.out.println(text);

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(".swal2-confirm")
            )
        ).click();

        return text;
    }
    }
   

