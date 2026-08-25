package com.corpzee.GST;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GstCancellationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators

    private By attachment = By.id("attachment");

    private By mobileNo = By.id("mobileNo");

    private By taxpayerName = By.id("taxpayerName");

    private By emailId = By.id("emailId");

    private By tradeName = By.id("tradeName");

    private By gstUserId = By.id("gstUserId");

    private By gstPassword = By.id("gstPassword");

    private By reasonDropdown = By.id("gstCancellationReason");

    private By reasonSearch = By.id("gstCancellationReasonSearch");

    private By otherReason = By.id("otherReason");

    private By submitButton = By.id("gstCancellationSubmit");

    private By cancelButton = By.id("gstCancellationCancel");
    
    private By successMessage =
            By.xpath("//*[contains(normalize-space(), 'Your details have been submitted successfully')]");
    

    public GstCancellationPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }



    // Upload Cancellation Letter


    public void uploadCancellationLetter(String filePath) {

        WebElement file =
                wait.until(ExpectedConditions.presenceOfElementLocated(attachment));

        file.sendKeys(filePath);
    }

    // Mobile Number


    public void enterMobileNo(String mobile) {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(mobileNo));

        element.clear();
        element.sendKeys(mobile);
    }


    // Taxpayer Name

    public void enterTaxpayerName(String name) {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(taxpayerName));

        element.clear();
        element.sendKeys(name);
    }


    // Email

    public void enterEmail(String email) {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(emailId));

        element.clear();
        element.sendKeys(email);
    }


    // Trade Name

    public void enterTradeName(String tradeNameValue) {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(tradeName));

        element.clear();
        element.sendKeys(tradeNameValue);
    }

    // GST User ID


    public void enterGstUserId(String userId) {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(gstUserId));

        element.clear();
        element.sendKeys(userId);
    }


    // GST Password

    public void enterGstPassword(String password) {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(gstPassword));

        element.clear();
        element.sendKeys(password);
    }

    
    // Select Reason
    // Search and Select Reason

   public void searchAndSelectReason(String reasonId) {

    WebElement dropdown = wait.until(
            ExpectedConditions.presenceOfElementLocated(reasonDropdown)
    );

    // Scroll dropdown into view
    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
            dropdown
    );

    // Open dropdown
    try {
        wait.until(
                ExpectedConditions.elementToBeClickable(dropdown)
        ).click();

    } catch (ElementClickInterceptedException e) {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                dropdown
        );
    }

    // Select option by ID
    By option = By.id(reasonId);

    wait.until(
            ExpectedConditions.elementToBeClickable(option)
    ).click();
}


    // Other Reason

    public void enterOtherReason(String reason) {

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(otherReason));

        element.clear();
        element.sendKeys(reason);
    }

    
    
    // Submit
  
    public void clickSubmit() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(submitButton)
        );

        clickWithJS(element);
    }

   
    public void clickCancel() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(cancelButton)
        );

        clickWithJS(element);
    }
    

    private void clickWithJS(WebElement element) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );

        js.executeScript(
                "arguments[0].click();",
                element
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
        System.out.println("Service Charge: ₹" + serviceCharge);

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

        // Wait for success popup message
    			By successMessage = By.xpath(
    		        "//*[text()[contains(., 'Your details have been submitted successfully') " +
    		        "and contains(., 'GST Cancellation history list page')]]"
    		    );

        WebElement message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(successMessage)
        );

        String successText = message.getText().trim();


        // Click OK
        By okButton = By.xpath(
            "//button[normalize-space()='OK']"
        );
        
        
        WebElement ok = wait.until(
                ExpectedConditions.elementToBeClickable(okButton)
            );

            ok.click();

            return successText;
    }
    

}