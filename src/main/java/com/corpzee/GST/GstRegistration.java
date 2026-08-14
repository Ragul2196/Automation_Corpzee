package com.corpzee.GST;

import com.corpzee.base.BaseTest;
import com.corpzee.pages.DashboardPage;
import com.corpzee.pages.GSTRegistrationPage;
import com.corpzee.pages.LoginPage;

public class GstRegistration {

    public static void main(String[] args) throws InterruptedException {

        // Launch Browser
        BaseTest base = new BaseTest();
        base.launchBrowser();

        // Login
        LoginPage login = new LoginPage();
        login.login("tec0003", "Admin@123");

        // Open GST Registration
        DashboardPage dashboard = new DashboardPage();
        dashboard.openGSTRegistration();

        // GST Registration
        GSTRegistrationPage gst = new GSTRegistrationPage();

        gst.selectRegistrationType();
        gst.fillBasicDetails();
        gst.uploadPartnerDocuments();
        gst.selectAddressProof();
        gst.uploadAddressProof();
        gst.enterPartnerMobile();
        gst.enterPartnerEmail();
        gst.selectBusinessDropdown();
        gst.uploadNOC();
        gst.UploadEB();
        gst.uploadTINCertificate();
        gst.radioButton();
        gst.checkBox();

        // Close Browser (Optional)
        // base.closeBrowser();
    }
}