package com.corpzee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.corpzee.base.BaseTest;
import com.corpzee.utils.WaitUtils;

public class DashboardPage extends BaseTest {

    // Tax Package
    public By taxPackage = By.id("package-Tax");

    // GST Services
    public By gstRegistration = By.id("service-Registration");
    
    public By gstCancellation = By.id("service-Cancellation");
    

    // Flight
    public By travelPackage = By.id("package-Travel");
    public By flightService = By.id("direct-service-Flight Ticket Booking");
    
    //IT Filing
	public By ClickIT = By.id("subcategory-IT");
	public By ITFilingService = By.id("service-IT Filing");
	
    //IT Notice
	public By ITNotice = By.id("service-Notice & Compliance");

    /**
     * Open GST Registration
     */
    public void openGSTRegistration() {

        WebElement tax = wait.until(
                ExpectedConditions.visibilityOfElementLocated(taxPackage));

        scrollIntoView(tax);
        jsClick(tax);

        WebElement registration = wait.until(
                ExpectedConditions.elementToBeClickable(gstRegistration));

        scrollIntoView(registration);
        jsClick(registration);
    }
    
    
    
    public void openGSTCancellation() {

        WebElement tax = wait.until(
                ExpectedConditions.visibilityOfElementLocated(taxPackage));

        scrollIntoView(tax);
        jsClick(tax);

        WebElement registration = wait.until(
                ExpectedConditions.elementToBeClickable(gstCancellation));

        scrollIntoView(registration);
        jsClick(registration);
    }

    
    
    
    /**
     * Open Flight Booking
     */
    public void openFlightBooking() {

        WebElement travel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(travelPackage));

        scrollIntoView(travel);
        jsClick(travel);

        WebElement flight = wait.until(
                ExpectedConditions.elementToBeClickable(flightService));

        scrollIntoView(flight);
        jsClick(flight);
    }
    
/*
 * IT Fliling
 * */
    
	public void OpenTaxITFliling() {
		
		WebElement tax = wait.until(
            ExpectedConditions.visibilityOfElementLocated(taxPackage));

    scrollIntoView(tax);
    jsClick(tax);
    
    WebElement IT = wait.until(
            ExpectedConditions.elementToBeClickable(ClickIT));

    scrollIntoView(IT);
    jsClick(IT);
    
    
    WebElement ITFiling = wait.until(
            ExpectedConditions.elementToBeClickable(ITFilingService));

    scrollIntoView(ITFiling);
    jsClick(ITFiling);
	
	
	}
	
/*
 * IT Notice
 * */
	
public void OpenTaxITNotice() {
		
		WebElement tax = wait.until(
            ExpectedConditions.visibilityOfElementLocated(taxPackage));

    scrollIntoView(tax);
    jsClick(tax);
    
    WebElement IT = wait.until(
            ExpectedConditions.elementToBeClickable(ClickIT));

    scrollIntoView(IT);
    jsClick(IT);
    
    
    WebElement ITFiling = wait.until(
            ExpectedConditions.elementToBeClickable(ITNotice));

    scrollIntoView(ITFiling);
    jsClick(ITFiling);
	
	
	}
    
    
}