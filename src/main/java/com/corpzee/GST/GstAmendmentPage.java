package com.corpzee.GST;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GstAmendmentPage {
	
	
	
	WebDriver driver;
    WebDriverWait wait;

    public GstAmendmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ==============================
    // LOCATORS
    // ==============================

    // Application Download
    public By applicationDownload =
            By.xpath("//a[normalize-space()='Application']");

    // Amendment Letter Upload
    public By amendmentLetter =
            By.cssSelector("input[type='file'][formControlName='attachment']");

    // Mobile Number
    public By mobileNumber =
            By.id("mobileNo");

    // Taxpayer Name
    public By taxpayer =
            By.cssSelector("input[formControlName='taxpayer']");

    // Email
    public By email =
            By.id("emailId");

    // Trade Name
    public By tradeName =
            By.cssSelector("input[formControlName='tradename']");

    // GST User ID
    public By gstUser =
            By.cssSelector("input[formControlName='gstUser']");

    // GST Password
    public By gstPassword =
            By.cssSelector("input[formControlName='gstPassword']");

    // Amendment Type
    public By amendmentType =
            By.cssSelector("mat-select[formControlName='Reason']");

    // Other Reason
    public By otherReason =
            By.cssSelector("textarea[formControlName='description']");

    // Proof for Amendment
    public By amendmentProof =
            By.cssSelector("input[type='file'][formControlName='attachments']");

    // Reason for Amendment
    public By reasonForAmendment =
            By.cssSelector("textarea[formControlName='ReasonAmendment']");

    // Service Charge / Amount
    public By serviceCharge =
            By.cssSelector("input[formControlName='tbdeduct']");

    // Submit
    public By submitButton =
            By.xpath("//button[@type='submit' and normalize-space()='Submit']");

    // Cancel
    public By cancelButton =
            By.xpath("//a[normalize-space()='Cancel']");
    
    
    public By confirmButton = 
    			By.xpath("/html/body/div[3]/div/div[6]/button[1]");


    // ==============================
    // APPLICATION DOWNLOAD
    // ==============================

    public void downloadApplication() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(applicationDownload));

        element.click();
    }


    // ==============================
    // AMENDMENT LETTER UPLOAD
    // ==============================

    public void uploadAmendmentLetter(String filePath) {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(amendmentLetter));

        element.sendKeys(filePath);
    }


    // ==============================
    // MOBILE NUMBER
    // ==============================

    public void enterMobileNumber(String mobile) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(mobileNumber));

        element.clear();
        element.sendKeys(mobile);
    }


    // ==============================
    // TAXPAYER NAME
    // ==============================

    public void enterTaxpayer(String name) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(taxpayer));

        element.clear();
        element.sendKeys(name);
    }


    // ==============================
    // EMAIL
    // ==============================

    public void enterEmail(String emailValue) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(email));

        element.clear();
        element.sendKeys(emailValue);
    }


    // ==============================
    // TRADE NAME
    // ==============================

    public void enterTradeName(String tradeNameValue) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(tradeName));

        element.clear();
        element.sendKeys(tradeNameValue);
    }


    // ==============================
    // GST USER ID
    // ==============================

    public void enterGstUser(String userId) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(gstUser));

        element.clear();
        element.sendKeys(userId);
    }


    // ==============================
    // GST PASSWORD
    // ==============================

    public void enterGstPassword(String password) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(gstPassword));

        element.clear();
        element.sendKeys(password);
    }


    // ==============================
    // AMENDMENT TYPE
    // ==============================

    public void selectAmendmentType(String amendmentName) {

        WebElement select = wait.until(
                ExpectedConditions.elementToBeClickable(amendmentType));

        select.click();

        By option = By.xpath(
                "//mat-option[normalize-space()='" + amendmentName + "']");

        wait.until(
                ExpectedConditions.elementToBeClickable(option)).click();
    }


    // ==============================
    // OTHER REASON
    // ==============================

    public void enterOtherReason(String reason) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(otherReason));

        element.clear();
        element.sendKeys(reason);
    }


    // ==============================
    // AMENDMENT PROOF UPLOAD
    // ==============================

    public void uploadAmendmentProof(String filePath) {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(amendmentProof));

        element.sendKeys(filePath);
    }


    // ==============================
    // REASON FOR AMENDMENT
    // ==============================

    public void enterReasonForAmendment(String reason) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(reasonForAmendment));

        element.clear();
        element.sendKeys(reason);
    }


    // ==============================
    // GET SERVICE CHARGE
    // ==============================

    public String getServiceCharge() {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(serviceCharge));

        return element.getAttribute("value");
    }


    // ==============================
    // SUBMIT
    // ==============================

    public void clickSubmit() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(submitButton));

        try {

            element.click();

        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }


    // ==============================
    // CANCEL
    // ==============================

    public void clickCancel() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(cancelButton));

        element.click();
        
       
    }
    
    
    
    public void ClickConfirm() {
    	
    	 WebElement element = wait.until(
                 ExpectedConditions.elementToBeClickable(confirmButton));

         try {

             element.click();

         } catch (Exception e) {

             ((JavascriptExecutor) driver)
                     .executeScript("arguments[0].click();", element);
         }
    }
    
    
    public String handleSuccessMessage() {

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".swal2-html-container")
                )
        );

        String text = message.getText();

        System.out.println("Success Message: " + text);

        WebElement confirmButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".swal2-confirm")
                )
        );

        confirmButton.click();

        return text;
    }
}




