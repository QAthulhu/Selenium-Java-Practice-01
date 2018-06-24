package com.selenium.mercury.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.mercury.constants.Util;
import com.selenium.mercury.pages.*;

public class Login {
	static WebDriver driver;
	private static String baseUrl;
	
	private static HomePage homePage;
	private static FindAFlightPage findFlightPage;

	public static void main(String[] args) throws Exception {
		setup();
		
		login();
		
		driver.close();
	}

	public static void setup() throws Exception {
		// Setup geckodriver
		String path = Util.DRIVER_PATH_FIREFOX;
		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();

		// Set Timeout
		driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);

		baseUrl = Util.BASE_URL;
		driver.get(baseUrl);
	}

	public static void login() {
		//Instantiate Home Page
		homePage = new HomePage( driver );
		
		//Enter credentials and login
		homePage.login( Util.USERNAME, Util.PASSWORD );
		
		//Instantiate Find A Flight page and verify if login was successful
		findFlightPage = new FindAFlightPage( driver );
		
		String actualTitle = findFlightPage.getTitle();
		
		if (actualTitle.contains(Util.EXPECTED_TITLE)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
	}
}
