package com.selenium.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	By usernameTextbox = By.name( "userName" );
	By passwordTextbox = By.name( "password" );
	
	By loginButton = By.name( "login" );
	
	public HomePage( WebDriver driver ) {
		this.driver = driver;
	}
	
	//*****Objects*****
	public void setUsername( String usernameText ) {
		driver.findElement( usernameTextbox ).clear();
		driver.findElement( usernameTextbox ).sendKeys( usernameText );
	}
	public void setPassword( String passwordText ) {
		driver.findElement( passwordTextbox ).clear();
		driver.findElement( passwordTextbox ).sendKeys( passwordText );
	}
	public void clickLoginButton() {
		driver.findElement( loginButton ).click();
	}
	
	//*****Functions*****
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void login( String username, String password ) {
		setUsername( username );
		setPassword( password );
		
		clickLoginButton();
	}
}
