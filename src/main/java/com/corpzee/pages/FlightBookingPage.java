package com.corpzee.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.corpzee.base.BaseTest;

public class FlightBookingPage extends BaseTest {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	// FROM locators
	By fromClick = By.xpath("//label[normalize-space()='From']/following::p-select[1]");
	By fromInput = By.xpath("//div[contains(@class,'p-select-overlay')]//input");
	By airportList = By.xpath("//*[@id=\"pn_id_8_0\"]");

	// TO locators
	By toClick = By.xpath("//label[normalize-space()='To']/following::p-select[1]");
	By toInput = By.xpath("//div[contains(@class,'p-select-overlay')]//input");
	By airportListto = By.xpath("//div[contains(@class,'p-select-overlay')]//li[@role='option']");
	

	// Date
	By departureDate = By.xpath("//input[contains(@placeholder,'Select date')]");

	// Travellers
	By traveller = By.xpath("//span[contains(text(),'1 Adult')]");

	By adultPlus = By.xpath("//div[contains(.,'Adults')]//button[last()]");

	By childPlus = By.xpath("//div[contains(.,'Children')]//button[last()]");

	By infantPlus = By.xpath("//div[contains(.,'Infants')]//button[last()]");

	By apply = By.xpath("//span[text()='Apply']");

	// Travel Class

	By classDropDown = By.xpath("//label[contains(text(),'Travel Class')]/following::p-select[1]");

	// Search

	By searchButton = By.xpath("//button[@type='submit']");

	// Loader

	By spinner = By.cssSelector(".spinner-border");

	// No Flights

	By noFlights = By.xpath("//*[contains(text(),'No Flights') or contains(text(),'No flights')]");

	By flightsfound = By.xpath(
			"//*[@id=\"flightHomeRouteWrapper\"]/section/app-flight-booking/div/div/div/div/app-flight-oneway-search-result-card/div/div/div[2]/div/div/div[1]/div[1]/p");

	// fare
	By fareOptions = By.xpath(
			"//*[@id=\"flightHomeRouteWrapper\"]/section/app-flight-booking/div/div/div/div/app-flight-oneway-search-result-card/div/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/label[2]/div");
	// -------------------------

	By BookNow = By.xpath(
			"//*[@id=\"flightHomeRouteWrapper\"]/section/app-flight-booking/div/div/div/div/app-flight-oneway-search-result-card/div/div/div[2]/div/div/div[2]/div[2]/div/div[1]/div[3]/button[1]");

	
	//Click passenger
	By selectpassenger = By.xpath("//*[@id=\"pn_id_109_content\"]/div/div[1]/p-button/button");
	
	
	//rendered passenger details
	By passengerDetails = By.xpath("/html/body/div/div/div[3]/div/div[2]/div[1]");
	
	
	//Manual seat selection
	By manualSeat = By.id("manualSeat");
	
	//baggages
	By baggageDropdown = By.xpath("//*[@id=\"pn_id_435_0\"]/div");
	
	
	By baggageOptions = By.xpath("//li[@role='option']");
	
	
	//Traveller email
	
	By travellerEmail = By.xpath("//*[@id=\"pn_id_430_steppanel_1\"]/div/div/p-card/div[2]/div/form/div[4]/div[1]/input");
	
	//Traveller mobile 
	
	By travellerMobile = By.xpath("//*[@id=\"pn_id_430_steppanel_1\"]/div/div/p-card/div[2]/div/form/div[4]/div[2]/input");
	
	
	//terms and conditions
	By terms = By.id("terms");
	
	
	By Review = By.xpath("//*[@id=\"pn_id_79_steppanel_1\"]/div/div/p-card/div[2]/div/form/div[6]/p-button/button/span[1]");
	
	
	By Proceed = By.xpath("//*[@id=\"pn_id_79_steppanel_2\"]/div/div/p-card/div[2]/div/div[4]/p-button[2]/button/span[1]");
	
	
	By completeBooking = By.xpath("//*[@id=\"pn_id_79_steppanel_3\"]/div/div/p-card/div/div/div/p-button[2]/button");
	
	public void selectFrom(String city) {
	    // 1. Click the 'From' dropdown container
	    wait.until(ExpectedConditions.elementToBeClickable(fromClick)).click();

	    // 2. Wait for overlay input, click to focus, clear, and type city character-by-character
	    WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(fromInput));
	    input.click();
	    input.clear();
	    
	    for (char c : city.toCharArray()) {
	        input.sendKeys(String.valueOf(c));
	        try {
	            Thread.sleep(100); // Gives PrimeNG angular state time to digest input
	        } catch (InterruptedException ignored) {}
	    }

	    // 3. Wait until list options are visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(airportList));
	    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(airportList, 0));

	    // 4. Iterate and click option
	    List<WebElement> airports = driver.findElements(airportList);

	    for (WebElement airport : airports) {
	        String text = airport.getText();
	        String innerHTML = airport.getAttribute("innerHTML");
	        String ariaLabel = airport.getAttribute("aria-label");

	        boolean matchesText = text != null && text.toLowerCase().contains(city.toLowerCase());
	        boolean matchesHTML = innerHTML != null && innerHTML.toLowerCase().contains(city.toLowerCase());
	        boolean matchesAria = ariaLabel != null && ariaLabel.toLowerCase().contains(city.toLowerCase());

	        if (matchesText || matchesHTML || matchesAria) {
	            wait.until(ExpectedConditions.elementToBeClickable(airport));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", airport);
	            System.out.println("Selected From: " + city);
	            return;
	        }
	    }

	    // Fallback: If list rendered filtered results but text matching was missed, hit Enter
	    input.sendKeys(Keys.ENTER);
	    System.out.println("Selected From via ENTER key: " + city);
	}

	// -------------------------

	public void selectTo(String city) {
	    // 1. Click the 'To' dropdown container
	    wait.until(ExpectedConditions.elementToBeClickable(toClick)).click();

	    // 2. Wait for overlay input, click to focus, clear, and type city character-by-character
	    WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(toInput));
	    input.click();
	    input.clear();

	    for (char c : city.toCharArray()) {
	        input.sendKeys(String.valueOf(c));
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException ignored) {}
	    }

	    // 3. Wait until list options are visible
	    wait.until(ExpectedConditions.visibilityOfElementLocated(airportListto));
	    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(airportListto, 0));

	    // 4. Iterate and click option
	    List<WebElement> airports = driver.findElements(airportListto);

	    for (WebElement airport : airports) {
	        String text = airport.getText();
	        String innerHTML = airport.getAttribute("innerHTML");
	        String ariaLabel = airport.getAttribute("aria-label");

	        boolean matchesText = text != null && text.toLowerCase().contains(city.toLowerCase());
	        boolean matchesHTML = innerHTML != null && innerHTML.toLowerCase().contains(city.toLowerCase());
	        boolean matchesAria = ariaLabel != null && ariaLabel.toLowerCase().contains(city.toLowerCase());

	        if (matchesText || matchesHTML || matchesAria) {
	            wait.until(ExpectedConditions.elementToBeClickable(airport));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", airport);
	            System.out.println("Selected To: " + city);
	            return;
	        }
	    }

	    // Fallback: If list rendered filtered results but text matching was missed, hit Enter
	    input.sendKeys(Keys.ENTER);
	    System.out.println("Selected To via ENTER key: " + city);
	}
	// -------------------------

	public void selectDepartureDate(String date) {

		WebElement txt = wait.until(ExpectedConditions.visibilityOfElementLocated(departureDate));

		txt.sendKeys(Keys.CONTROL + "a");

		txt.sendKeys(date);

		txt.sendKeys(Keys.ENTER);

	}

	// -------------------------

	public void selectTravellers(int adults, int children, int infants) {

		wait.until(ExpectedConditions.elementToBeClickable(traveller)).click();

		for (int i = 0; i < adults; i++)
			driver.findElement(adultPlus).click();

		for (int i = 0; i < children; i++)
			driver.findElement(childPlus).click();

		for (int i = 0; i < infants; i++)
			driver.findElement(infantPlus).click();

		driver.findElement(apply).click();

	}

	// -------------------------

	public void selectTravelClass(String travelClass) {

		wait.until(ExpectedConditions.elementToBeClickable(classDropDown)).click();

		By option = By.xpath("//li[contains(.,'" + travelClass + "')]");

		wait.until(ExpectedConditions.elementToBeClickable(option)).click();

	}

	// -------------------------

	public boolean clickSearch() {

		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

		try {

			wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));

		} catch (Exception e) {

		}

		if (driver.findElements(noFlights).size() > 0) {

			System.out.println("No Flights Found");

			return false;

		}

		return true;

	}

	public int getFlightsCount() {

		WebElement flights = wait.until(ExpectedConditions.visibilityOfElementLocated(flightsfound));

		String text = flights.getText().trim();

		// Example: "35 flights found"
		String count = text.split(" ")[0];

		return Integer.parseInt(count);
	}

	public void selectFare(Integer index) {

		List<WebElement> fares = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fareOptions));

		if (fares.isEmpty()) {
			throw new RuntimeException("No Fare Options Available");
		}

		if (index == null) {
			index = new Random().nextInt(fares.size());
		}

		WebElement fare = fares.get(index);

		scrollIntoView(fare);

		jsClick(fare);

		System.out.println("--------------------------------");
		System.out.println("Total Fare Options : " + fares.size());
		System.out.println("Selected Index : " + index);
		System.out.println("Selected Fare :");
		System.out.println(fare.getText());
		System.out.println("--------------------------------");
	}

	public void clickbooknow() {

		wait.until(ExpectedConditions.elementToBeClickable(BookNow)).click();

	}
	
	
	public void selectpassanger() {
		
		wait.until(ExpectedConditions.elementToBeClickable(selectpassenger)).click();
	}
	
	
public void selectpassangerDetails() {
		
		wait.until(ExpectedConditions.elementToBeClickable(passengerDetails)).click();
	}
	
	
public void selectManualSeat() {

    WebElement seat = wait.until(
            ExpectedConditions.elementToBeClickable(manualSeat));

    scrollIntoView(seat);

    if (!seat.isSelected()) {
        jsClick(seat);
    }

    System.out.println("Manual Seat Selection Selected");

    
}

public void selectSeat(String seatNumber) {

    By seat = By.xpath("//div[contains(@class,'seat') and normalize-space()='" + seatNumber + "']");

    WebElement seatElement = wait.until(
            ExpectedConditions.elementToBeClickable(seat));

    scrollIntoView(seatElement);

    jsClick(seatElement);

    System.out.println("Selected Seat : " + seatNumber);
}


public void ClickDone(){
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[4]/div/div/div[2]/p-button/button/span[1]"))).click();
}

public void selectExtraBaggage(boolean addBaggage, String baggageName) {

    if (!addBaggage) {
        System.out.println("User skipped Extra Baggage.");
        return;
    }

    try {

        wait.until(ExpectedConditions.elementToBeClickable(baggageDropdown)).click();

        List<WebElement> options = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(baggageOptions));

        for (WebElement option : options) {

            if (option.getText().contains(baggageName)) {

                scrollIntoView(option);
                jsClick(option);

                System.out.println("Selected Baggage : " + option.getText());

                return;
            }
        }

        System.out.println("Requested baggage not available.");

    } catch (Exception e) {

        System.out.println("Unable to select baggage.");
    }
}


public void travellerEmail() {

    WebElement email = wait.until(
            ExpectedConditions.visibilityOfElementLocated(travellerEmail));

    email.clear();
    email.sendKeys("ragulsacariya@inetcsc.com");
}

public void travellerMobileNo() {

    WebElement email = wait.until(
            ExpectedConditions.visibilityOfElementLocated(travellerMobile));

    email.clear();
    email.sendKeys("8454545454");
}


public void selectterms() {
	
	wait.until(ExpectedConditions.elementToBeClickable(terms)).click();
}

public void clickReview() {
	
	wait.until(ExpectedConditions.elementToBeClickable(Review)).click();
}

public void ClickProceed() {
	
	wait.until(ExpectedConditions.elementToBeClickable(Proceed)).click();
}

public void confirmBooking() {
	
	wait.until(ExpectedConditions.elementToBeClickable(completeBooking)).click();
}


}