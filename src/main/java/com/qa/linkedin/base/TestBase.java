package com.qa.linkedin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.linkedin.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver=null;
	protected static WebDriverWait wait=null;
	public static Properties prop=null;
	
	public TestBase() throws IOException {
		//create an object for properties class
		
		prop=new Properties();
		
		//read the config.properties file
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\linkedin\\config\\config.properties");
			//load all the properties
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void initializeTheBrowser() {
		//fetch the browser name
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		//add implicitwait
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS );
		//maximize the window
		driver.manage().window().maximize();
		//open the url
		driver.get(prop.getProperty("url"));
		
		
		//cfreate object for webdriverwait
		wait=new WebDriverWait(driver,TestUtil.EXPLICIT_WAIT);
		
		//create object for fluentwait class
		FluentWait fw=new FluentWait(driver);
		fw.withTimeout(60, TimeUnit.SECONDS);
		fw.pollingEvery(5, TimeUnit.SECONDS);
	}
	
	
	
	
	
	

}
