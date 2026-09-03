package com.corpzee.tests_GSTService;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.corpzee.GST.GstAmendmentPage;
import com.corpzee.base.BaseTest;
import com.corpzee.pages.DashboardPage;
import com.corpzee.pages.LoginPage;

public class GstAmendmentTest extends BaseTest {
	
 		GstAmendmentPage gst;
	
	  @BeforeTest
	    public void setup() {
	        launchBrowser();
	        
	        LoginPage Login = new LoginPage();
			Login.login("TEC0003", "Admin@123");
			  
			DashboardPage dashboard = new DashboardPage();
			dashboard.openGSTAmendment();
			  
			  
			 gst = new GstAmendmentPage(driver);
	    }
	  
	  @Test
	  public void gstAmendmentTest() {
		  
		  
		  gst.uploadAmendmentLetter(
	                "C:\\Users\\ragulsacariya\\Downloads\\sample-local-pdf.pdf"
	        );

	        // Mobile
	        gst.enterMobileNumber(
	                "9876543210"
	        );

	        // Taxpayer
	        gst.enterTaxpayer(
	                "Test Taxpayer"
	        );

	        // Email
	        gst.enterEmail(
	                "test@gmail.com"
	        );

	        // Trade Name
	        gst.enterTradeName(
	                "Test Trade Name"
	        );

	        // GST User
	        gst.enterGstUser(
	                "GSTUSER123"
	        );

	        // GST Password
	        gst.enterGstPassword(
	                "GSTPassword123"
	        );

	        // Amendment Type
	        gst.selectAmendmentType(
	                "Mobile No/ E-mail"
	        );

	        // Proof
	        gst.uploadAmendmentProof(
	        		"C:\\Users\\ragulsacariya\\Downloads\\sample-local-pdf.pdf"
	        );

	        // Reason
	        gst.enterReasonForAmendment(
	                "Amendment required for updating taxpayer details"
	        );

	        // Service Charge
	        String charge =
	                gst.getServiceCharge();

	        System.out.println(
	                "GST Amendment Service Charge: " + charge
	        );

	        // Submit
	        gst.clickSubmit();
	        
	        gst.ClickConfirm();
	        
	
	        String successMessage = gst.handleSuccessMessage();

	        System.out.println("Final Message: " + successMessage);
	        
	        
	        
	    
	  }
}
