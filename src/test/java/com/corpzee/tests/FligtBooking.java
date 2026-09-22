package com.corpzee.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.corpzee.base.BaseTest;
import com.corpzee.pages.DashboardPage;
import com.corpzee.pages.FlightBookingPage;
import com.corpzee.pages.LoginPage;

public class FligtBooking extends BaseTest {

    @BeforeMethod
    public void setUp() {
        launchBrowser();   // This initializes driver and wait
    }

    @Test
    public void verifyFlightBookingSearch() {

        LoginPage login = new LoginPage();
        login.login("TEC0003", "Admin@123");
        

        DashboardPage dashboard = new DashboardPage();
        dashboard.openFlightBooking();

        FlightBookingPage flight = new FlightBookingPage();
        flight.selectFrom("Bangalore");
        flight.selectTo("Kochi");
        flight.selectDepartureDate("25 Aug 2026");
        flight.selectTravellers(1, 1, 0);
        flight.selectTravelClass("Economy");

        boolean result = flight.clickSearch();

        if (result) {
            System.out.println("Flights Found");
        } else {
            System.out.println("No Flights Available");
        }
        
        flight.getFlightsCount();
        
        flight.selectFare(null);
        
        flight.clickbooknow();
        
        flight.selectpassanger();
        
        flight.selectpassangerDetails();
        
        flight.selectManualSeat();
       
        flight.selectSeat("5C");
        
        flight.ClickDone();
        
        // User wants baggage
		/* flight.selectExtraBaggage(true, "10kg"); */

        // User doesn't want baggage
        flight.selectExtraBaggage(false, "");
        
        
        flight.travellerEmail();
        
        flight.travellerMobileNo();
        
        flight.selectterms();
        
        flight.clickReview();
        
        flight.ClickProceed();
        
        flight.confirmBooking();       
        
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}