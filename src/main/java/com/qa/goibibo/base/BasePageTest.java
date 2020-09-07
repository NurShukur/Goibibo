package com.qa.goibibo.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.goibibo.pages.FlightReviewPage;
import com.qa.goibibo.pages.FlightsPage;
import com.qa.goibibo.pages.HomePage;

public class BasePageTest {

	public WebDriver driver; 
	public  Properties prop;
	public BasePage basePage;
	public  HomePage homePage; 
	public FlightsPage flightsPage; 
	public FlightReviewPage  flightReviewPage; 
	
	
	@BeforeTest
	public void setup() {
		basePage=new BasePage();
		prop=basePage.init_prop();
		driver=basePage.init_driver(prop);
		homePage=new HomePage(driver); 
		flightsPage = new FlightsPage(driver);
		flightReviewPage=new FlightReviewPage(driver); 
	}
	
	
	@AfterTest
	
	public void tearDown () {
		
		driver.quit();
		
	}
	
	


	
	
	
	
	
}
