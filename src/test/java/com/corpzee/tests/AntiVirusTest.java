package com.corpzee.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.corpzee.base.BaseTest;
import com.corpzee.pages.DashboardPage;
import com.corpzee.pages.LoginPage;

import SecureServices.AntiVirusPage;

public class AntiVirusTest  extends BaseTest{

	AntiVirusPage  antivirus;
	
	  @BeforeTest
	    public void setup() {
		  
	        launchBrowser();
	        
	        LoginPage Login = new LoginPage();
			Login.login("TEC0003", "Admin@123");
			  
			DashboardPage dashboard = new DashboardPage();
			dashboard.openAntivirus();	  
			
			 antivirus = new AntiVirusPage(driver);
			 
	    }
	
	  @Test
	    public void antivirusTest() {

		// Select Payment Mode
	        antivirus.selectPaymentMode("Cash");

	        // Select Product
	        antivirus.selectProduct("Total Security (Single User)");

	        // Customer details
	        antivirus.enterCustomerMobile("9876543210");

	        antivirus.enterCustomerName("Rahul");

	        antivirus.enterEmail("ragulsacariya@inetcsc.com");

	        // Generate Licence Key
	        antivirus.clickGenerateLicenceKey();
	        
	        String message = antivirus.getDeductionMessage();

	        System.out.println("Popup: " + message);

	        antivirus.clickAgreeYes();
	        
	        antivirus.captureLicenseKeyAlertScreenshot();
	    }

	
	
	
}
