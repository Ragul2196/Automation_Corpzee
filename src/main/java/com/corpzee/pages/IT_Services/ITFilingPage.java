package com.corpzee.pages.IT_Services;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class ITFilingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ITFilingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    // Download buttons
    private By salariedApplication =
            By.xpath("//button[contains(.,'Salaried Application')]");

    private By sampleSalariedApplication =
            By.xpath("//button[contains(.,'Sample Salaried Application')]");

    private By selfEmployedApplication =
            By.xpath("//button[contains(.,'Self Employed Application')]");

    private By sampleSelfEmployedApplication =
            By.xpath("//button[contains(.,'Sample Self Employed Application')]");

    // Employee Type
    private By employeeType =
            By.cssSelector("mat-select[formControlName='employeeType']");

    // File Upload
    private By filledApplication =
            By.cssSelector("input[formControlName='attachment']");

    // Applicant details
    private By applicantName =
            By.cssSelector("input[formControlName='name']");

    private By fatherName =
            By.cssSelector("input[formControlName='fatherName']");

    private By dateOfBirth =
            By.cssSelector("input[formControlName='dateofBirth']");

    private By panNumber =
            By.id("pan");

    private By applicantAddress =
            By.cssSelector("textarea[formControlName='address']");

    // State
    private By state =
            By.id("mat-select-1");

    // Pincode
    private By pinCode =
            By.cssSelector("input[formControlName='pinCode']");

    // Mobile
    private By mobileNumber =
            By.id("mobileNo");

    // Email
    private By email =
            By.id("emailId");

    // Assessment Year
    private By assessmentYear =
            By.id("assessmentYear");

    // TDS
    private By tdsYes = By.xpath(
    	    "//mat-radio-button[normalize-space()='Yes']"
    	);

    	private By tdsNo = By.xpath(
    	    "//mat-radio-button[normalize-space()='No']"
    	);

    // Aadhaar
    private By aadhaarNumber =
            By.cssSelector("input[formControlName='aadhaarNo']");

    // Bank Account
    private By bankAccountNumber =
            By.id("BankAcc");

    // IFSC
    private By ifscCode =
            By.id("ifsc");

    // TAN
    private By tanNumber =
            By.id("tan");

    // ITD Password
    private By itdPortalPassword =
            By.id("Itdpassword");

    // Upload Form
    private By uploadForm =
            By.cssSelector("input[formControlName='uploadform']");

    // Annual Income
    private By annualIncome =
           By.xpath("//*[@id=\"mat-select-2\"]/div/div[2]");

    // Submit / Cancel
    private By submitButton =
            By.xpath("//button[@type='submit' and contains(normalize-space(),'Submit')]");
    
    
    //Confirm Button
   
    private By Confirmbutton = 
    			By.xpath("/html/body/div[3]/div/div[6]/button[1]");

    private By cancelButton =
            By.xpath("//a[contains(normalize-space(),'Cancel')]");


    public void clickSalariedApplication() {
        wait.until(ExpectedConditions.elementToBeClickable(salariedApplication)).click();
    }

    public void clickSampleSalariedApplication() {
        wait.until(ExpectedConditions.elementToBeClickable(sampleSalariedApplication)).click();
    }

    public void clickSelfEmployedApplication() {
        wait.until(ExpectedConditions.elementToBeClickable(selfEmployedApplication)).click();
    }

    public void clickSampleSelfEmployedApplication() {
        wait.until(ExpectedConditions.elementToBeClickable(sampleSelfEmployedApplication)).click();
    }

    public void selectEmployeeType(String employeeTypeName) {
        wait.until(ExpectedConditions.elementToBeClickable(employeeType)).click();

        By option = By.xpath(
                "//mat-option//span[normalize-space()='" +
                employeeTypeName +
                "']/ancestor::mat-option"
        );

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void uploadFilledApplication(String filePath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(filledApplication))
                .sendKeys(filePath);
    }

    public void enterApplicantName(String name) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(applicantName));

        element.clear();
        element.sendKeys(name);
    }

    public void enterFatherName(String name) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(fatherName));

        element.clear();
        element.sendKeys(name);
    }

    

    public void selectDateOfBirth(String date) {

        String[] parts = date.split("-");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        // Open calendar
        wait.until(ExpectedConditions.elementToBeClickable(dateOfBirth)).click();

        // Select Year
        WebElement yearDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("ngb-datepicker select[aria-label='Select year']")
                ));

        new Select(yearDropdown).selectByVisibleText(year);

        // Select Month
        WebElement monthDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("ngb-datepicker select[aria-label='Select month']")
                ));

        new Select(monthDropdown).selectByValue(
                String.valueOf(Integer.parseInt(month))
        );

        // Select Day
        By dayLocator = By.xpath(
                "//ngb-datepicker//div[@role='gridcell' and normalize-space()='" + day + "']"
        );


        wait.until(ExpectedConditions.elementToBeClickable(dayLocator)).click();
    }

    public void enterPanNumber(String pan) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(panNumber));

        element.clear();
        element.sendKeys(pan);
    }

    public void enterAddress(String address) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(applicantAddress));

        element.clear();
        element.sendKeys(address);
    }

    public void selectState(String stateName) {
        wait.until(ExpectedConditions.elementToBeClickable(state)).click();

        By option = By.id("mat-option-14");

        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void enterPinCode(String pin) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(pinCode));

        element.clear();
        element.sendKeys(pin);
    }

    public void enterMobileNumber(String mobile) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber));

        element.clear();
        element.sendKeys(mobile);
    }

    public void enterEmail(String emailId) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(email));

        element.clear();
        element.sendKeys(emailId);
    }

    public String getAssessmentYear() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(assessmentYear))
                .getAttribute("value");
    }

    //Radio Button
    public void selectTDSYes() {

        WebElement yes = wait.until(
            ExpectedConditions.visibilityOfElementLocated(tdsYes)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", yes
        );
    }

    public void selectTDSNo() {

        WebElement no = wait.until(
            ExpectedConditions.visibilityOfElementLocated(tdsNo)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", no
        );
    }

    public void enterAadhaarNumber(String aadhaar) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(aadhaarNumber));

		/* element.clear(); */
        element.sendKeys(aadhaar);
    }

    public void enterBankAccountNumber(String accountNumber) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(bankAccountNumber));

        element.clear();
        element.sendKeys(accountNumber);
    }

    public void enterIFSC(String ifsc) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(ifscCode));

        element.clear();
        element.sendKeys(ifsc);
    }

    public void enterTAN(String tan) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(tanNumber));

        element.clear();
        element.sendKeys(tan);
    }

    public void enterITDPassword(String password) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(itdPortalPassword));

        element.clear();
        element.sendKeys(password);
    }

    public void uploadForm(String filePath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(uploadForm))
                .sendKeys(filePath);
    }

   
    public String selectAnnualIncome(int index) {

        // 1. Locate the dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.presenceOfElementLocated(annualIncome)
        );

        // 2. Scroll the dropdown into view to ensure visibility
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", dropdown
        );

        // 3. Click using JavaScript to avoid ElementClickInterceptedException
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", dropdown
        );

        // 4. Locate and fetch dropdown options
        By optionsLocator = By.cssSelector(".cdk-overlay-container mat-option");

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(optionsLocator)
        );

        // Print options for debugging
        System.out.println("Annual Income Options:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + " -> " + options.get(i).getText().trim());
        }

        // Validate provided index
        if (index < 0 || index >= options.size()) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        // 5. Select the targeted option using JavaScript click for safety
        WebElement option = options.get(index);
        String selectedIncome = option.getText().trim();
        
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", option
        );

        System.out.println("Selected Annual Income: " + selectedIncome);

        return selectedIncome;
    }
    
    
    
    
    
    
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public String clickConfirm() {

        // Click Confirm
        wait.until(
            ExpectedConditions.elementToBeClickable(Confirmbutton)
        ).click();

        WebElement messageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Confirmbutton)
            );

            // 2. Fetch the text from the modal box
            String message = messageElement.getText().trim();

            // 3. Click the "OK" button on the modal to dismiss it
            WebElement okBtn = wait.until(
                ExpectedConditions.elementToBeClickable(Confirmbutton)
            );
            okBtn.click();

            // 4. Return the captured message
            return message;
    }
    
    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }
}