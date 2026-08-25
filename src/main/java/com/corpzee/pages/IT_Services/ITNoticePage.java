package com.corpzee.pages.IT_Services;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ITNoticePage {
	
	

	    private WebDriver driver;
	    private WebDriverWait wait;

	    public ITNoticePage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    }

	    // Download Buttons
	    private By applicationDownloadBtn = By.xpath("//a[contains(text(),'Application')]");
	    private By sampleApplicationDownloadBtn = By.xpath("//a[contains(text(),'Sample Application')]");

	    // File Upload
	    private By uploadAttachmentInput = By.id("attachment");

	    // Form Inputs
	    private By applicantNameInput = By.cssSelector("input[formControlName='ApplicantName']");
	    private By panNumberInput = By.id("pan");
	    private By dobInput = By.cssSelector("input[formControlName='dob']");
	    private By mobileNoInput = By.id("mobileNo");
	    private By emailInput = By.id("emailId");
	    private By itPasswordInput = By.cssSelector("input[formControlName='itPassword']");

	    //State & Assessment
	    private By stateSelectDropdown = By.id("stateDropdown");
	    private By matSearchInput = By.cssSelector("input[placeholder='Search']");

	    private By assessmentYearDropdown = By.id("assessmentYearDropdown");

	    // Buttons
	    private By submitButton = By.xpath("//button[@type='submit' and contains(text(),'Submit')]");
	    private By cancelButton = By.xpath("//a[contains(text(),'Cancel')]");

	    // --- Actions ---

	    public void downloadApplication() {
	        wait.until(ExpectedConditions.elementToBeClickable(applicationDownloadBtn)).click();
	    }

	    public void downloadSampleApplication() {
	        wait.until(ExpectedConditions.elementToBeClickable(sampleApplicationDownloadBtn)).click();
	    }

	    public void uploadFilledApplication(String filePath) {
	        wait.until(ExpectedConditions.presenceOfElementLocated(uploadAttachmentInput)).sendKeys(filePath);
	    }

	    public void enterApplicantName(String name) {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(applicantNameInput));
	        element.clear();
	        element.sendKeys(name);
	    }

	    public void enterPanNumber(String pan) {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(panNumberInput));
	        element.clear();
	        element.sendKeys(pan);
	    }

	    public void selectDateOfBirth(String date) {
	        // Date format: DD-MM-YYYY
	        String[] parts = date.split("-");
	        String day = parts[0];
	        String month = parts[1];
	        String year = parts[2];

	        wait.until(ExpectedConditions.elementToBeClickable(dobInput)).click();

	        WebElement yearDropdown = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ngb-datepicker select[aria-label='Select year']"))
	        );
	        new Select(yearDropdown).selectByVisibleText(year);

	        WebElement monthDropdown = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ngb-datepicker select[aria-label='Select month']"))
	        );
	        new Select(monthDropdown).selectByValue(String.valueOf(Integer.parseInt(month)));

	        By dayLocator = By.xpath("//ngb-datepicker//div[@role='gridcell' and normalize-space()='" + Integer.parseInt(day) + "']");
	        wait.until(ExpectedConditions.elementToBeClickable(dayLocator)).click();
	    }

	    public void enterMobileNumber(String mobile) {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNoInput));
	        element.clear();
	        element.sendKeys(mobile);
	    }

	    public void enterEmail(String email) {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
	        element.clear();
	        element.sendKeys(email);
	    }

	    public void selectState(String stateName) {

	        // Click State dropdown
	        wait.until(ExpectedConditions.elementToBeClickable(stateSelectDropdown)).click();

	        // Search State
	        WebElement searchBox = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//*[@id=\"stateDropdown-panel\"]/ngx-mat-select-search/div/div/input")
	            )
	        );

	        searchBox.clear();
	        searchBox.sendKeys(stateName);

	        // Select matching state
	        By stateOption = By.xpath(
	            "//mat-option[.//span[normalize-space()='" + stateName + "']]"
	        );

	        wait.until(ExpectedConditions.elementToBeClickable(stateOption)).click();
	    }
	    
	    
	    public void selectAssessmentYear(String year) {

	        wait.until(
	            ExpectedConditions.elementToBeClickable(assessmentYearDropdown)
	        ).click();

	        By yearOption = By.id("assessmentYearOption-2025 - 2026");

	        wait.until(
	            ExpectedConditions.elementToBeClickable(yearOption)
	        ).click();
	    }

	    public void enterITPassword(String password) {
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(itPasswordInput));
	        element.clear();
	        element.sendKeys(password);
	    }

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
	            "//*[contains(normalize-space(), 'Your details have been submitted successfully') " +
	            "and contains(normalize-space(), 'IT Notice Compliance history list page')]"
	        );

	        WebElement message = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(successMessage)
	        );

	        String successText = message.getText();

	        // Print only the success message
	        System.out.println("Success Message: " + successText);

	        // Click OK
	        By okButton = By.xpath(
	            "//button[normalize-space()='OK']"
	        );

	        wait.until(
	            ExpectedConditions.elementToBeClickable(okButton)
	        ).click();

	        return successText;
	    }
	    
	}
	
	
	

