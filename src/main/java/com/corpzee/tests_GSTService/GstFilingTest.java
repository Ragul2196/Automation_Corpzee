package com.corpzee.tests_GSTService;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.corpzee.GST.GstFilingPage;
import com.corpzee.base.BaseTest;
import com.corpzee.pages.DashboardPage;
import com.corpzee.pages.LoginPage;

public class GstFilingTest extends BaseTest {

    @BeforeTest
    public void setup() {
        launchBrowser();
    }

    @Test
    public void gstfilingTest() {

        // Login
        LoginPage login = new LoginPage();
        login.login("tec0003", "Admin@123");

        // Open GST Filing
        DashboardPage dashboard = new DashboardPage();
        dashboard.openGSTFiling();

        // GST Filing Page
        GstFilingPage gst = new GstFilingPage(driver);

        // Tax Type
        gst.selectTaxType("Nil Return");

        // Upload Application
        gst.uploadApplication(
                "C:\\Users\\ragulsacariya\\Downloads\\sample-local-pdf.pdf"
        );

        // GSTIN
        gst.enterGSTIN("33ABCDE1234F1Z5");

        // Mobile
        gst.enterMobileNo("9876543210");

        // Taxpayer Name
        gst.enterTaxpayerName("Rahul Kumar");

        // Email
        gst.enterEmail("rahul@gmail.com");

        // State
        gst.selectState("TAMIL NADU");

        // Trade / Taxpayer Name
        gst.enterTradeTaxpayer("Rahul Enterprises");

        // GST Frequency
        gst.selectGstFrequency("Monthly");

        // Tax Period
        gst.selectTaxPeriod("August-2026");

        // Invoice
        gst.enterInvoice("10");

        // GST User ID
        gst.enterGstUserId("GSTUSER123");

        // GST Password
        gst.enterGstPassword("Test@1234");

        // Sales File
        gst.uploadSalesFile(
        		"D:\\SampleData\\gst_purchase.xlsx"
        );

        // Purchase File
        gst.uploadPurchaseFile(
                "D:\\SampleData\\gst_purchase.xlsx"
        );

        gst.clicksubmit();

        // Service charge popup
        String serviceCharge = gst.confirmServiceCharge();

        // Success message
        String successMessage = gst.handleSuccessMessage();

        System.out.println("Final Service Charge: ₹" + serviceCharge);
        System.out.println("Final Message: " + successMessage);
    }

    }