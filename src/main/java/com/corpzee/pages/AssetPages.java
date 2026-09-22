package com.corpzee.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Add;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class AssetPages {

	
	WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public AssetPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
    }
    
    public By Sidemenu = By.className("asset-sidebar");    
    
    public By AddCatagory = By.xpath("/html/body/app-root/app-base/div/div/div/div/app-asset-base/div/div[2]/app-asset-category/div/app-dynamic-report-page/div/app-dynamic-report-page-header/div/div/div[2]/button");
	
 // Category Name
    public By categoryName = By.cssSelector("input[formControlName='name']");

    // Code
    public By categoryCode = By.cssSelector("input[formControlName='code']");

    // Status
    public By status = By.cssSelector("p-select[formControlName='status']");

    // Submit Categories button
    public By submitButton = By.xpath("//button[contains(.,'Submit Categories')]");

    
    // Alert message - change text if your actual message is different
    public By successAlert = By.xpath(
        "//*[contains(@class,'alert') or contains(@class,'toast') or contains(@role,'alert')]"
    );
    
    // Parent Category
    public By parentCategory = By.cssSelector(
        "p-select[formControlName='parentCategory']"
    );

    // Sub-Category Name
    public By subCategoryName = By.cssSelector(
        "input[formControlName='name']"
    );

    // Auto-generated Code
    public By subCategoryCode = By.cssSelector(
        "input[formControlName='code']"
    );

    // Status
    public By substatus = By.cssSelector(
        "p-select[formControlName='status']"
    );

    // Submit Sub-Categories button
    public By subsubmitButton = By.xpath(
        "//button[contains(.,'Submit Sub-Categories')]"
    );

    // Success / Alert message
    public By subsuccessAlert = By.xpath(
        "//*[contains(@role,'alert') or contains(@class,'alert') or contains(@class,'toast')]"
    );
    
    
    public By AddSubButton = By.xpath("/html/body/app-root/app-base/div/div/div/div/app-asset-base/div/div[2]/app-asset-subcategory/div/app-dynamic-report-page/div/app-dynamic-report-page-header/div/div/div[2]/button");
    
    
    public By AddPurchase = By.xpath("//button[contains(normalize-space(), 'Add Purchase Entry')]");
   
    
 // Vendor Details
    public By vendorName = By.xpath(
        "//input[@placeholder='Enter Vendor Name']"
    );

    public By vendorMobile = By.xpath(
        "//input[@placeholder='Enter 10-digit Mobile']"
    );

    public By vendorEmail = By.xpath(
        "//input[@placeholder='Enter Email']"
    );

    public By vendorState = By.xpath(
        "//input[@placeholder='Enter State']"
    );

    public By vendorCity = By.xpath(
        "//input[@placeholder='Enter City']"
    );

    public By invoiceNumber = By.xpath(
        "//input[@placeholder='Enter Invoice Number']"
    );

    // Invoice Date
    public By invoiceDate = By.xpath(
    	    "//p-datepicker//input[@placeholder='Select Invoice Date']"
    	);


    // Purchase Value
    public By purchaseValue = By.id(
        "currency-inr-purchase"
    );

    // GST Type
    public By gstType = By.cssSelector(
        "p-select"
    );

    // GST Percentage
    public By gstPercentage = By.xpath(
        "//input[@placeholder='e.g. 18']"
    );

    // GST Amount
    public By gstAmount = By.id(
        "currency-inr-gst"
    );

    // Total Amount
    public By totalAmount = By.id(
        "currency-inr-total"
    );

    // Total Quantity
    public By totalQuantity = By.id(
        "totalQuantity"
    );

    // Invoice File
    public By invoiceFile = By.cssSelector(
        "input[type='file']"
    );

    // Save Entry
    public By saveEntryButton = By.xpath(
        "/html/body/app-root/app-base/div/div/div/div/app-asset-base/div/div[2]/app-asset-purchase-details/div/div/div/div/div[2]/button[2]"
    );
    

    
    //Create Assets
    
    
 // Purchase Invoice
    private By purchaseInvoice = By.cssSelector(
        "p-select[formControlName='purchaseInvoiceId']"
    );

    // Add Another Asset
    private By addAnotherAssetButton = By.xpath(
        "//button[.//span[normalize-space()='Add Another Asset']]"
    );

    // Asset accordion panels
    private By assetPanels = By.cssSelector(
        "p-accordion-panel"
    );

    // Category
    private By category = By.cssSelector(
        "p-select[formControlName='category']"
    );

    // Sub Category
    private By subCategory = By.cssSelector(
        "p-select[formControlName='subCategory']"
    );

    // Asset Name
    private By assetName = By.cssSelector(
        "input[formControlName='assetName']"
    );

    // Brand / Model
    private By brandModel = By.cssSelector(
        "input[formControlName='brandModel']"
    );

    // Serial Number
    private By serialNumber = By.cssSelector(
        "input[formControlName='serialNumber']"
    );

    // Warranty Start Date
    private By warrantyStartDate = By.cssSelector(
        "p-datepicker[formControlName='warrantyStartDate'] input"
    );

    // Warranty End Date
    private By warrantyEndDate = By.cssSelector(
        "p-datepicker[formControlName='warrantyEndDate'] input"
    );

    // AMC Applicable
    private By amcApplicable = By.cssSelector(
        "p-select[formControlName='amcApplicable']"
    );

    // Submit
    private By submitForVerification = By.xpath(
        "//button[.//span[normalize-space()='Submit for Verification']]"
    );

    
    
    
    
    //Side Menu
    public void SideMenu() {
    		

        WebElement menu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Sidemenu)
        );

        actions.moveToElement(menu).perform();
    }
    
    
    
    public void clickSideMenu(String menuName) {

        // Hover over sidebar first
        SideMenu();

        // Find and click required menu
        WebElement menuItem = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'asset-sidebar')]//a[.//span[normalize-space()='" 
                                + menuName + "']]")
                )
        );

        menuItem.click();
    }


    
    //Add Catagory
	public void clickCatagory() {
			
		WebElement AddButton = wait.until(
                ExpectedConditions.elementToBeClickable(AddCatagory));
		
		AddButton.click();
	}
	
	
	 // Enter Category Name
    public void enterCategoryName(String name) {
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(categoryName)
        );

        element.clear();
        element.sendKeys(name);
    }


    // Get Category Code
    public String getCategoryCode() {
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(categoryCode)
        );

        return element.getAttribute("value");
    }


    // Get Status
    public String getStatus() {
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(status)
        );

        return element.getText();
    }


    // Click Submit Categories
    public void clickSubmitCategories() {
        WebElement button = wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
        );

        button.click();
    }
    
    // Get submitted/success message
    public String getSubmittedMessage() {
        WebElement alert = wait.until(
            ExpectedConditions.visibilityOfElementLocated(successAlert)
        );

        return alert.getText().trim();
    }
    
    
    public void clickSubcatagoryButton() {
    	
    	WebElement AddButton = wait.until(
                ExpectedConditions.elementToBeClickable(AddSubButton));
		
    	AddButton.click();
    }
    
    
    // Select Parent Category
    public void selectParentCategory(String categoryName) {

        WebElement dropdown = wait.until(
            ExpectedConditions.elementToBeClickable(parentCategory)
        );

        dropdown.click();

        By option = By.xpath(
            "//*[contains(@class,'p-select-option') and normalize-space()='" 
            + categoryName + "']"
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(option)
        ).click();
    }
    
    // Enter Sub-Category Name
    public void enterSubCategoryName(String name) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(subCategoryName)
        );

        element.clear();
        element.sendKeys(name);
    }
    
    // Get Auto-generated Code
    public String getSubCategoryCode() {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(subCategoryCode)
        );

        return element.getAttribute("value");
    }
    
    // Get Status
    public String getSubStatus() {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(substatus)
        );

        return element.getText();
    }
    
 // Submit Sub-Category
    public void clickSubmitSubCategory() {

        WebElement button = wait.until(
            ExpectedConditions.elementToBeClickable(subsubmitButton)
        );

        button.click();
    }


    // Get Submitted Message
    public String getSubSubmittedMessage() {

        WebElement alert = wait.until(
            ExpectedConditions.visibilityOfElementLocated(subsuccessAlert)
        );

        return alert.getText().trim();
    }
	
    
    //Purchase Details
    
    
    public void clickAddPurchase() {
    	
    	WebElement purchase = wait.until(
                ExpectedConditions.elementToBeClickable(AddPurchase)
            );

    	purchase.click();
    
    	
    }
    
    
    public void enterVendorName(String name) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(vendorName)
        );

        element.clear();
        element.sendKeys(name);
    }
    
    
    
    public void enterVendorMobile(String mobile) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(vendorMobile)
        );

        element.clear();
        element.sendKeys(mobile);
    }
    
    public void enterVendorEmail(String email) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(vendorEmail)
        );

        element.clear();
        element.sendKeys(email);
    }
    
    
    public void enterVendorState(String state) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(vendorState)
        );

        element.clear();
        element.sendKeys(state);
    }
    
    
    
    public void enterVendorCity(String city) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(vendorCity)
        );

        element.clear();
        element.sendKeys(city);
    }
    
      
    public void enterInvoiceNumber(String invoice) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(invoiceNumber)
        );

        element.clear();
        element.sendKeys(invoice);
    }
    
    public void enterInvoiceDate(String date) {

        WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(invoiceDate)
        );

        element.click();
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(date);
        element.sendKeys(Keys.TAB);
    }
    
    
    public void enterPurchaseValue(String value) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(purchaseValue)
        );

        element.clear();
        element.sendKeys(value);
    }
    
    public void selectGstType(String gst) {

        WebElement dropdown = wait.until(
            ExpectedConditions.elementToBeClickable(gstType)
        );

        dropdown.click();

        By option = By.xpath(
            "//*[contains(@class,'p-select-option') and normalize-space()='" 
            + gst + "']"
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(option)
        ).click();
    }
    
    
    public void enterGstPercentage(String percentage) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(gstPercentage)
        );

        element.clear();
        element.sendKeys(percentage);
    }
    
    
    public void enterTotalQuantity(String quantity) {

        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(totalQuantity)
        );

        element.clear();
        element.sendKeys(quantity);
    }
    
    
    public void uploadInvoice(String filePath) {

        WebElement file = wait.until(
            ExpectedConditions.presenceOfElementLocated(invoiceFile)
        );

        file.sendKeys(filePath);
    }
    
    public void clickSaveEntry() {

        WebElement button = wait.until(
            ExpectedConditions.presenceOfElementLocated(saveEntryButton)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});",
            button
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(button)
        ).click();
    }
    
    
    
////////////////////////////////////    
    //CREATE Asset's
////////////////////////////////////
    
 // Get Asset Panel
    public WebElement getAssetPanel(int index) {

        wait.until(driver ->
            driver.findElements(assetPanels).size() > index
        );

        List<WebElement> panels = driver.findElements(assetPanels);

        return panels.get(index);
    }

    // Select Purchase Invoice
    public void selectPurchaseInvoice(String invoiceName) {

        WebElement dropdown = wait.until(
            ExpectedConditions.elementToBeClickable(purchaseInvoice)
        );

        dropdown.click();

        By option = By.xpath(
            "//li[contains(@class,'p-select-option') and normalize-space()='"
            + invoiceName + "']"
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(option)
        ).click();
    }


    // Select Category
    public void selectAssetCategory(int index, String categoryName) {

        WebElement panel = getAssetPanel(index);

        WebElement dropdown = panel.findElement(category);

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            dropdown
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(dropdown)
        );

        dropdown.click();

        By option = By.xpath(
            "//li[contains(@class,'p-select-option') and normalize-space()='"
            + categoryName + "']"
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(option)
        ).click();
    }


    // Select Random Sub Category
    public void selectRandomSubCategory(int index) {

        WebElement panel = getAssetPanel(index);

        WebElement dropdown = panel.findElement(subCategory);

        dropdown.click();

        List<WebElement> options = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("li.p-select-option")
            )
        );

        if (options.isEmpty()) {
            throw new RuntimeException(
                "No Sub-Categories available"
            );
        }

        Random random = new Random();

        WebElement randomOption = options.get(
            random.nextInt(options.size())
        );

        randomOption.click();
    }


    // Enter Asset Name
    public void enterAssetName(int index, String name) {

        WebElement panel = getAssetPanel(index);

        WebElement element = panel.findElement(assetName);

        element.clear();
        element.sendKeys(name);
    }


    // Enter Brand / Model
    public void enterBrandModel(int index, String model) {

        WebElement panel = getAssetPanel(index);

        WebElement element = panel.findElement(brandModel);

        element.clear();
        element.sendKeys(model);
    }


    // Enter Serial Number
    public void enterSerialNumber(int index, String serial) {

        WebElement panel = getAssetPanel(index);

        WebElement element = panel.findElement(serialNumber);

        element.clear();
        element.sendKeys(serial);
    }


    // Warranty Start Date
    public void enterWarrantyStartDate(int index, String date) {

        WebElement panel = getAssetPanel(index);

        WebElement element = panel.findElement(warrantyStartDate);

        element.click();

        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(date);
        element.sendKeys(Keys.TAB);
    }


    // Warranty End Date
    public void enterWarrantyEndDate(int index, String date) {

        WebElement panel = getAssetPanel(index);

        WebElement element = panel.findElement(warrantyEndDate);

        element.click();

        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(date);
        element.sendKeys(Keys.TAB);
    }


    // Select AMC
    public void selectAMC(int index, String value) {

        WebElement panel = getAssetPanel(index);

        WebElement dropdown = panel.findElement(amcApplicable);

        dropdown.click();

        By option = By.xpath(
            "//li[contains(@class,'p-select-option') and normalize-space()='"
            + value + "']"
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(option)
        ).click();
    }


    // Add Another Asset
    public void clickAddAnotherAsset() {

        WebElement button = wait.until(
            ExpectedConditions.elementToBeClickable(
                addAnotherAssetButton
            )
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            button
        );

        button.click();
    }

    // Open Asset Accordion
    public void openAsset(int index) {

        WebElement panel = getAssetPanel(index);

        WebElement header = panel.findElement(
            By.cssSelector("p-accordion-header")
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            header
        );

        String expanded = header.getAttribute("aria-expanded");

        if (!"true".equals(expanded)) {
            header.click();
        }
    }


    // Submit For Verification
    public void clickSubmitForVerification() {

        WebElement button = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                submitForVerification
            )
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            button
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(button)
        ).click();
    }    
}
