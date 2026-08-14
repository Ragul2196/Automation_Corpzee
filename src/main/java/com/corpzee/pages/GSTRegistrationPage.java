package com.corpzee.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.corpzee.base.BaseTest;

public class GSTRegistrationPage extends BaseTest {

    // Registration Type

    private By registrationType =
            By.cssSelector("select.form-select");

    // All textboxes

    private By inputBoxes =
            By.cssSelector("input.form-control");

    // Textareas

    private By textAreas =
            By.tagName("textarea");

    // File Uploads

    private By uploadFiles =
            By.cssSelector("input[type='file']");

    // Select Dropdown

    private By addressProofDropdown =
            By.xpath("//select[@aria-label='select example']");
    
    
 	private By businessType =
	        By.xpath("/html/body/app-root/app-base/div/div/div/div/app-gst-registration/div/div/div[2]/div/div/div/div/div/div/div[2]/div[10]/div/span/select");
	



    /*
     * Registration Type
     */

    public void selectRegistrationType() {

        Select select =
                new Select(driver.findElement(registrationType));

        select.selectByValue("1");

    }



    /*
     * Basic Details
     */

    public void fillBasicDetails() {

        List<WebElement> inputs =
                driver.findElements(inputBoxes);

        inputs.get(0).sendKeys("Rahul Testing");

        inputs.get(1).sendKeys("7878787878");

        inputs.get(2).sendKeys("ragulsacariya@inetcsc.com");

        inputs.get(3).sendKeys("Product Service");



        List<WebElement> text =
                driver.findElements(textAreas);

        text.get(0).sendKeys(
                "9th Floor, Olympia Platina, Guindy, Chennai");

        text.get(1).sendKeys(
                "GST Registration Automation Testing");



        inputs.get(4).sendKeys("Testing");

    }



    /*
     * Upload Partner Documents
     */

    public void uploadPartnerDocuments() {

        List<WebElement> uploads =
                driver.findElements(uploadFiles);

        uploads.get(0).sendKeys(
                "C:\\Users\\ragulsacariya\\Downloads\\PP20260710085604191.jpg");

        uploads.get(1).sendKeys(
                "C:\\Users\\ragulsacariya\\Downloads\\PP20260710085604410.jpg");

        uploads.get(2).sendKeys(
                "C:\\Users\\ragulsacariya\\Downloads\\PP000000001616-06232026131318.jpg");

    }



    /*
     * Address Proof Dropdown
     */

    public void selectAddressProof() {

        Select select =
                new Select(driver.findElement(addressProofDropdown));

        select.selectByValue("1");

    }



    /*
     * Upload Address Proof
     */

    public void uploadAddressProof() {

        List<WebElement> uploads =
                driver.findElements(uploadFiles);

        uploads.get(3).sendKeys(
                "C:\\Users\\ragulsacariya\\Downloads\\PP000000001616-06232026131318.jpg");

    }



    /*
     * Partner Mobile
     */

    public void enterPartnerMobile() {

        driver.findElement(By.xpath(
                "/html/body/app-root/app-base/div/div/div/div/app-gst-registration/div/div/div[2]/div/div/div/div/div/div/div[2]/div[9]/div/span/table/tbody/tr/td[6]/span/input"))
                .sendKeys("9090909090");

    }



    /*
     * Partner Email
     */

    public void enterPartnerEmail() {

        driver.findElement(By.xpath(
                "/html/body/app-root/app-base/div/div/div/div/app-gst-registration/div/div/div[2]/div/div/div/div/div/div/div[2]/div[9]/div/span/table/tbody/tr/td[7]/span/input"))
                .sendKeys("test@gmail.com");

    }
    
    
    //Address or Business Dropdown-1
    public void selectBusinessDropdown() {

    	  WebElement dropdown =
    	            wait.until(ExpectedConditions.visibilityOfElementLocated(businessType));

    	    ((JavascriptExecutor)driver)
    	            .executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);

    	    wait.until(ExpectedConditions.elementToBeClickable(dropdown));

    	    Select select = new Select(dropdown);

    	    select.selectByValue("1");
    }
    
    //Upload NOC proof
    public void uploadNOC() {
    	
    	driver.findElement(By.xpath("//*[@id=\"9validatedCustomFile\"]"))
        .sendKeys("C:\\Users\\ragulsacariya\\Downloads\\INV8654321234567.pdf");
    }
    
    //Upload EB Proof
    public void UploadEB() {
    	
    	driver.findElement(By.id("10validatedCustomFile"))
        .sendKeys("C:\\Users\\ragulsacariya\\Downloads\\INV8654321234567.pdf");
    }
    
    
    public void uploadTINCertificate() {
    	driver.findElement(By.xpath("//*[@id=\"12validatedCustomFile\"]"))
        .sendKeys("C:\\Users\\ragulsacariya\\Downloads\\INV8654321234567.pdf");
    }
    
    public void radioButton() {
    	
    	WebElement yesRadio = driver.findElement(By.id("inlineRadio1"));

        if (!yesRadio.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesRadio);
        }else {
      	  
      	  	System.out.println("Radio Button Not selected");
        }
        driver.findElement(By.xpath("//label[@for='flexCheckDefault']")).click();
    }
    
    public void checkBox() throws InterruptedException {
    	
    	 WebElement checkbox = wait.until(
       		  ExpectedConditions.presenceOfElementLocated(By.id("flexCheckDefault"))
       		  );
        
         	((JavascriptExecutor)driver).executeScript(
         			"arguments[0].ScrollIntoView({block:'center'})", checkbox);
         	
         	Thread.sleep(500);
         	
         	((JavascriptExecutor)driver).executeScript("arguments[0].Click();", checkbox);
    }
    
    
    
}