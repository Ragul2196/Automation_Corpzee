package com.corpzee.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.corpzee.base.BaseTest;
import com.corpzee.pages.AssetPages;
import com.corpzee.pages.DashboardPage;
import com.corpzee.pages.LoginPage;


public class AssetManagementTest extends BaseTest{

	
	AssetPages AssetService;
	
	  @BeforeTest
	    public void setup() {
		  
	        launchBrowser();
	        
	        LoginPage Login = new LoginPage();
			Login.login("TEC0003", "Admin@123");
			  
			DashboardPage dashboard = new DashboardPage();
			dashboard.openAsset();
			
			AssetService = new AssetPages(driver);		 
	    }
	  
	  @Test(priority = 1, enabled = false)
	    public void addCategoryTest() {

	        AssetService.clickSideMenu("Categories");

	        // Click Add Category
	        AssetService.clickCatagory();

	        // Enter Category Name
	        AssetService.enterCategoryName("IT Asset");

	        // Get Auto-generated Code
	        String code = AssetService.getCategoryCode();
	        System.out.println("Category Code: " + code);

	        // Get Status
	        String status = AssetService.getStatus();
	        System.out.println("Category Status: " + status);

	        // Submit Category
	        AssetService.clickSubmitCategories();

	        // Get Alert Message
	        String message = AssetService.getSubmittedMessage();
	        System.out.println("Category Submitted Message: " + message);


	        // Validations
	        Assert.assertFalse(
	            code.isEmpty(),
	            "Category code was not generated"
	        );

	        Assert.assertEquals(
	            status,
	            "Active",
	            "Category status is not Active"
	        );

	        Assert.assertTrue(
	            message.toLowerCase().contains("success"),
	            "Category was not submitted successfully"
	        );
	    }


	    // ==============================
	    // TEST 2 - ADD SUB-CATEGORY
	    // ==============================

	    @Test(priority = 2, enabled = false)
	    public void addSubCategoryTest() {

	        AssetService.clickSideMenu("Sub Categories");
	        
	        
	        AssetService.clickSubcatagoryButton();
	        
	        AssetService.selectParentCategory("IT - Asset");

	        
	        AssetService.enterSubCategoryName("Laptops");

	        
	        String code = AssetService.getSubCategoryCode();
	        System.out.println("Sub-Category Code: " + code);

	        // Get Status
	        String status = AssetService.getStatus();
	        System.out.println("Sub-Category Status: " + status);

	        // Submit Sub-Category
	        AssetService.clickSubmitSubCategory();

	        // Get Alert Message
	        String message = AssetService.getSubmittedMessage();
	        System.out.println("Sub-Category Submitted Message: " + message);


	        // Validations
	        Assert.assertFalse(
	            code.isEmpty(),
	            "Sub-Category code was not generated"
	        );

	        Assert.assertEquals(
	            status,
	            "Active",
	            "Sub-Category status is not Active"
	        );

	        Assert.assertTrue(
	            message.toLowerCase().contains("success"),
	            "Sub-Category was not submitted successfully"
	        );
	    }
	    
	    @Test(priority = 3, enabled = false)
	    public void addPurchaseDetailsTest() {

	        AssetService.clickSideMenu("Purchase Details");
	     
	        AssetService.clickAddPurchase();
	    
	     // Vendor Details
	        AssetService.enterVendorName("ABC Technologies");
	        AssetService.enterVendorMobile("9876543210");
	        AssetService.enterVendorEmail("abc@gmail.com");

	        // Location
	        AssetService.enterVendorState("Tamil Nadu");
	        AssetService.enterVendorCity("Chennai");

	        // Invoice Details
	        AssetService.enterInvoiceNumber("INV001");

	        AssetService.enterInvoiceDate("09/18/2026");

	        // Purchase Details
	        AssetService.enterPurchaseValue("5000");

	        // GST
	        AssetService.selectGstType("CGST/SGST");
	        AssetService.enterGstPercentage("18");

	        // Quantity
	        AssetService.enterTotalQuantity("5");

	        // Upload Invoice
	        AssetService.uploadInvoice(
	            "C:\\Users\\ragulsacariya\\Documents\\sample-local-pdf.pdf"
	        );

	        // Save
	        AssetService.clickSaveEntry();

	        
	    }
	    @Test(priority = 4, enabled = false)
	    public void createFiveAssetsTest() {

	        AssetService.clickSideMenu("Create Asset");

	        AssetService.selectPurchaseInvoice("INV001 (ABC Technologies)");

	        String[] assetNames = {
	            "IT Laptop 1",
	            "IT Laptop 2",
	            "IT Desktop 1",
	            "IT Monitor 1",
	            "IT Monitor 2"
	        };

	        String[] models = {
	            "Dell Latitude 5420",
	            "HP ProBook 440",
	            "Dell OptiPlex 7090",
	            "Dell P2422H",
	            "HP E24 G4"
	        };

	        for (int i = 0; i < 5; i++) {

	            // Add new row except first asset
	            if (i > 0) {
	                AssetService.clickAddAnotherAsset();
	            }

	            // Open Asset accordion
	            AssetService.openAsset(i);

	            // Category
	            AssetService.selectAssetCategory( i,"IT - Asset");

	            // Random Sub-Category
	            AssetService.selectRandomSubCategory(i);

	            // Asset Name
	            AssetService.enterAssetName(i,assetNames[i]);

	            // Model
	            AssetService.enterBrandModel(i,models[i]);

	            // Serial Number
	            AssetService.enterSerialNumber(i,"IT-ASSET-00" + (i + 1));

	            // Warranty
	            AssetService.enterWarrantyStartDate( i, "09/21/2026");

	            AssetService.enterWarrantyEndDate(i,"09/20/2029");

	            // AMC
	            AssetService.selectAMC(i,"No" );
	        }

	        // Submit all 5
	        AssetService.clickSubmitForVerification();

	        System.out.println(
	            "5 IT Assets submitted for verification"
	        );
	    }    
	    
	    @Test(priority = 5)
	    public void assetAllocationTest() {
	    	
	        AssetService.clickSideMenu("Asset Allocation");
	        
	        
	        //Click Allocate Asset
	        AssetService.AllocateAsset();

	        // Select Employee / Department / Project
	        AssetService.selectAllocationAssignee("0205-Rahul");

	        // Select available asset
	        AssetService.selectAllocationAsset("APPLE (INVE764748366)");

	        // Allocation Date
	        AssetService.enterAllocationDate("09/25/2026");

	        // Expected Return Date
	        AssetService.enterExpectedReturnDate("09/25/2027");

	        // Require digital acknowledgement
	        AssetService.selectRequireAcknowledgement();

	        // Confirm
	        AssetService.selectRequireAcknowledgement();

	        String message = AssetService.clickConfirmAllocation();

	        System.out.println("Final Allocation Message: " + message);
	        
	    }
	    
	    
}
	    
