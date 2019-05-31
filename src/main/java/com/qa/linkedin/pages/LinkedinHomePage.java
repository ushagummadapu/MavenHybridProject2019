package com.qa.linkedin.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.base.TestBase;

public class LinkedinHomePage extends TestBase {

	public LinkedinHomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="li-icon.nav__logo")
	WebElement Linkedin_logo;
	
	@FindBy(css="a.nav__button-secondary")
	WebElement signin_link;
	
	
	
	public boolean verifyLinkedinLogo() {
		return Linkedin_logo.isDisplayed();
	}	
	public String getLinkedinLandingTitle() {
		return driver.getTitle();
	}
	public LinkedinLoginPage clickOnSignInLink() throws IOException {
		signin_link.click();
		return new LinkedinLoginPage();
	}
	
		
	
	

}
