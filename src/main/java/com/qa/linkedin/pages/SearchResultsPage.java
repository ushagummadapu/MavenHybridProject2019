package com.qa.linkedin.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.linkedin.base.TestBase;

public class SearchResultsPage extends TestBase{

	public SearchResultsPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[contains(@class,'search-results__total')]")
	WebElement search_results_text;
	
	public int getResultsCount() {
		wait.until(ExpectedConditions.titleContains("Search | LinkedIn"));
		wait.until(ExpectedConditions.visibilityOf(search_results_text));
		//get the results text
		String txt=search_results_text.getText();
		//txt="Showing 35,709 results";
		String[] str=txt.split(" ");
		//str[]=["showing","35,709","results"]
		String finalTxt=str[1].replace(",", "").trim();
		//convert string into integer
		int i=Integer.parseInt(finalTxt);
		return i;
	}
	
	
	
	
	
	

}
