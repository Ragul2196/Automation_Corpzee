package com.corpzee.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.corpzee.GST.GstCancellationPage;
import com.corpzee.base.BaseTest;
import com.corpzee.pages.DashboardPage;
import com.corpzee.pages.LoginPage;

public class GSTCancellationTest extends BaseTest{
		 
		 @BeforeTest
			public void setup() {
				launchBrowser();
			}
	
	     @Test
	     public void gstCancellationTest() {
	    	 
	    	 
	    	    // Login
		     LoginPage login = new LoginPage();
		     login.login("tec0003", "Admin@123");
		     
		     
		     DashboardPage dashboard = new DashboardPage();
		     dashboard.openGSTCancellation();
		     
		     GstCancellationPage gst = new GstCancellationPage(driver);
	   
		     gst.uploadCancellationLetter("C:\\Users\\ragulsacariya\\Downloads\\sample-local-pdf.pdf");
		     
		     gst.enterMobileNo("9876543210");
		     
		     gst.enterTaxpayerName("Rahul Enterprises");
		     
		     gst.enterEmail("rahul@gmail.com");
		     
		     gst.enterTradeName("Rahul Enterprises");
		     
		     gst.enterGstUserId("33ABCDE1234F1Z5");
		     
		     gst.enterGstPassword("Test@12345");
		     
		     gst.searchAndSelectReason("gstCancellationReason_6");
		     
		     gst.enterOtherReason("YOUR SCRIPT WORKS FINE");
		     
		    gst	.clickSubmit();

		    String serviceCharge = gst.confirmServiceCharge();

		    System.out.println("Service Charge: ₹" + serviceCharge);
	         
	         
	         
	         String successMessage = gst.handleSuccessMessage();

	         System.out.println("Success Message: " + successMessage);
}
}
