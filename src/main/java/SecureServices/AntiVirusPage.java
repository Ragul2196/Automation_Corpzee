package SecureServices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AntiVirusPage {
	

	WebDriver driver;
    WebDriverWait wait;

    public AntiVirusPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
    }
    // LOCATORS
    // =====================================================

    private By paymentMode = By.cssSelector(
            "mat-select[formControlName='cashMode']"
    );

    private By productName = By.cssSelector(
            "mat-select[formControlName='productName']"
    );

    private By customerMobile = By.cssSelector(
            "input[formControlName='customerMobileNumber']"
    );

    private By customerName = By.cssSelector(
            "input[formControlName='customerName']"
    );

    private By emailId = By.cssSelector(
            "input[formControlName='emailId']"
    );

    private By generateButton = By.xpath(
            "//button[@type='submit' and contains(normalize-space(),'Generate K7')]"
    );

    private By clearButton = By.xpath(
            "//a[normalize-space()='Clear']"
    );
    
    
    private By customerPrice = By.cssSelector(
            "input[formControlName='customerPrice']"
    );

    private By agreeButton = By.xpath(
            "//button[contains(@class,'swal2-confirm') and normalize-space()='I Agree/Yes']"
    );
    
    private By deductionMessage = By.xpath(
            "//div[contains(@class,'swal2-popup')]//*[contains(normalize-space(),'will be deducted')]"
    );

    // =====================================================
    // PAYMENT MODE
    // =====================================================

    public void selectPaymentMode(String paymentModeName) {

        WebElement payment = wait.until(
                ExpectedConditions.elementToBeClickable(paymentMode)
        );

        payment.click();

        By option = By.xpath(
                "//mat-option[normalize-space()='" + paymentModeName + "']"
        );

        WebElement paymentOption = wait.until(
                ExpectedConditions.elementToBeClickable(option)
        );

        paymentOption.click();
    }

    // =====================================================
    // PRODUCT NAME
    // =====================================================

    public void selectProduct(String productNameValue) {

        WebElement product = wait.until(
                ExpectedConditions.elementToBeClickable(productName)
        );

        product.click();

        By option = By.xpath(
                "//mat-option[normalize-space()='" + productNameValue + "']"
        );

        WebElement productOption = wait.until(
                ExpectedConditions.elementToBeClickable(option)
        );

        productOption.click();
    }

    // =====================================================
    // CUSTOMER MOBILE
    // =====================================================

    public void enterCustomerMobile(String mobileNumber) {

        WebElement mobile = wait.until(
                ExpectedConditions.visibilityOfElementLocated(customerMobile)
        );

        mobile.clear();
        mobile.sendKeys(mobileNumber);
    }

    // =====================================================
    // CUSTOMER NAME
    // =====================================================

    public void enterCustomerName(String name) {

        WebElement nameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(customerName)
        );

        nameField.clear();
        nameField.sendKeys(name);
    }

    // =====================================================
    // EMAIL
    // =====================================================

    public void enterEmail(String email) {

        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailId)
        );

        emailField.clear();
        emailField.sendKeys(email);
    }

    // =====================================================
    // GENERATE LICENCE KEY
    // =====================================================

    public void clickGenerateLicenceKey() {

        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(generateButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                button
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                button
        );
    }

    // =====================================================
    // CLEAR FORM
    // =====================================================

    public void clearForm() {

        WebElement clear = wait.until(
                ExpectedConditions.elementToBeClickable(clearButton)
        );

        clear.click();
    }

    // =====================================================
    // COMPLETE FORM
    // =====================================================

    public void fillLicenceForm(
            String paymentModeName,
            String productNameValue,
            String mobileNumber,
            String customerNameValue,
            String email) {

        selectPaymentMode(paymentModeName);

        selectProduct(productNameValue);

        enterCustomerMobile(mobileNumber);

        enterCustomerName(customerNameValue);

        enterEmail(email);
    }
    
    public String getCustomerPrice() {

        WebElement priceField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(customerPrice)
        );

        String price = priceField.getAttribute("value");

        System.out.println("Customer Price: ₹" + price);

        return price;
    }
    
    public void clickAgreeYes() {

        WebElement agree = wait.until(
                ExpectedConditions.elementToBeClickable(agreeButton)
        );

        agree.click();
    }
    
    
    public String getDeductionMessage() {

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(deductionMessage)
        );

        String text = message.getText();

        System.out.println("Confirmation Message: " + text);

        return text;
    }
    
    
 // Locator for the red alert message
    private By licenseKeyAlert = By.xpath(
    	    "//div[contains(@class,'swal2-popup')]//*[contains(text(),'License Key not Available for the selected product')]"
    	);

   
    /**
     * Checks whether the License Key alert is displayed.
     */
    public boolean isLicenseKeyAlertDisplayed() {

        try {
            WebElement alert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(licenseKeyAlert)
            );

            return alert.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the alert message text.
     */
    public String getLicenseKeyAlertMessage() {

        WebElement alert = wait.until(
            ExpectedConditions.visibilityOfElementLocated(licenseKeyAlert)
        );

        return alert.getText().trim();
    }

    /**
     * Takes screenshot of the complete browser page.
     */
    public void takeScreenshot(String fileName) {

        try {
            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Path destination = Path.of(
                    "screenshots",
                    fileName + ".png"
            );

            Files.createDirectories(destination.getParent());

            Files.copy(
                    source.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot saved: " + destination.toAbsolutePath()
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes screenshot automatically when the License Key
     * alert is displayed.
     */
    public void captureLicenseKeyAlertScreenshot() {

        if (isLicenseKeyAlertDisplayed()) {

            System.out.println(
                "License Key alert detected: "
                + getLicenseKeyAlertMessage()
            );

            takeScreenshot("License_Key_Not_Available");

        } else {

            System.out.println(
                "License Key alert is not displayed."
            );
        }
    }
    
    
}
