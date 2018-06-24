package com.selenium.mercury.pages;

import org.openqa.selenium.WebDriver;

public class FindAFlightPage {
	WebDriver driver;
	
	public FindAFlightPage( WebDriver driver ) {
		this.driver = driver;
	}
	
	//*****Functions*****
	public String getTitle() {
		return driver.getTitle();
	}
}
