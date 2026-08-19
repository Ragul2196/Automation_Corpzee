package com.corpzee.tests;




import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.corpzee.base.BaseTest;
import com.corpzee.pages.DashboardPage;
import com.corpzee.pages.LoginPage;
import com.corpzee.pages.IT_Services.ITFilingPage;


public class ITFilingTest extends BaseTest {
	
	@BeforeTest
	public void setup() {
		launchBrowser();
	}
	

    @Test
    public void itFilingTest() {
    	
    	 LoginPage login = new LoginPage();
         login.login("TEC0003", "Admin@123");
         

         DashboardPage dashboard = new DashboardPage();
         dashboard.OpenTaxITFliling();
    		

        ITFilingPage itFiling = new ITFilingPage(driver);

        itFiling.selectEmployeeType("Salaried");

        itFiling.uploadFilledApplication(
                "C:\\Users\\ragulsacariya\\Downloads\\sample-local-pdf.pdf"
        );	

        itFiling.enterApplicantName("Rahul Kumar");
        itFiling.enterFatherName("Ramesh Kumar");

        itFiling.selectDateOfBirth("11-03-2005");

        itFiling.enterPanNumber("ABCDE1234F");
        itFiling.enterAddress("Chennai, Tamil Nadu");

        itFiling.selectState("Tamil Nadu");

        itFiling.enterPinCode("600001");
        itFiling.enterMobileNumber("9876543210");
        itFiling.enterEmail("rahul.test@example.com");

        System.out.println(
                "Assessment Year: " + itFiling.getAssessmentYear()
        );

		/* itFiling.selectTDSYes() */;
		itFiling.selectTDSNo();

        itFiling.enterAadhaarNumber("121212121212");
        itFiling.enterBankAccountNumber("1234567890123456");
        itFiling.enterIFSC("SBIN0001234");
        itFiling.enterTAN("ABCD12345E");

        itFiling.enterITDPassword("Test@1234");

        itFiling.uploadForm(
                "C:\\Users\\ragulsacariya\\Downloads\\sample-local-pdf.pdf"
        );

		itFiling.selectAnnualIncome(2); 
        
        itFiling.clickSubmit();
        
        String message = itFiling.clickConfirm();

        System.out.println("Form Submission Message: " + message);
        
        
    }
    
	/*
	 * @AfterMethod public void tearDown() { closeBrowser(); }
	 */
}