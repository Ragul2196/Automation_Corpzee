package com.corpzee.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.corpzee.base.BaseTest;
import com.corpzee.pages.DashboardPage;
import com.corpzee.pages.LoginPage;
import com.corpzee.pages.IT_Services.ITNoticePage;

public class ITNoticeTest extends BaseTest{
	
	
	@BeforeTest
	public void setup() {
		launchBrowser();
	}
	

    @Test
    public void ITNoticeTest() {
    	
    	 LoginPage login = new LoginPage();
         login.login("TEC0003", "Admin@123");
         

         DashboardPage dashboard = new DashboardPage();
         dashboard.OpenTaxITNotice();
	
         ITNoticePage noticeCompliance = new ITNoticePage(driver);

         // Upload attachment
         noticeCompliance.uploadFilledApplication("C:\\Users\\ragulsacariya\\Downloads\\sample-local-pdf.pdf");

         // Fill form fields
         noticeCompliance.enterApplicantName("Rahul Kumar");
         noticeCompliance.enterPanNumber("ABCDE1234F");
         noticeCompliance.selectDateOfBirth("11-03-2005");
         noticeCompliance.enterMobileNumber("9876543210");
         noticeCompliance.enterEmail("rahul.test@example.com");

         // Select dropdowns
         noticeCompliance.selectState("TAMIL NADU");

         noticeCompliance.selectAssessmentYear(null);

         // Optional/Password fields
         noticeCompliance.enterITPassword("Test@1234");

         // Submit form
         noticeCompliance.clickSubmit();

         String serviceCharge = noticeCompliance.confirmServiceCharge();

         System.out.println("Final Service Charge = ₹" + serviceCharge);
         
         
         
         String successMessage = noticeCompliance.handleSuccessMessage();

         System.out.println("Success Message: " + successMessage);
     }
    

}

