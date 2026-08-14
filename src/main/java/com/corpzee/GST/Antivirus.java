package com.corpzee.GST;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Antivirus {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://uat-corphub.inetcsc.com/gstregistration");
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(30));

		
	}

}
