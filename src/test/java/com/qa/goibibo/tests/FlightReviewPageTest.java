package com.qa.goibibo.tests;

import static org.testng.Assert.*;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.goibibo.base.BasePageTest;
import com.qa.goibibo.utils.Constants;
public class FlightReviewPageTest extends BasePageTest {
	
	
	@Parameters({"title","firstName","lastName","countryCode","number","email"})
	@Test (priority=1)
	public void fillPassengerDetailsTest(String title,String firstName,String lastName,String countryCode, String number, String email)  throws InterruptedException {
	homePage.enterFlightDetails("Del", "Mum", "December 2020", "21", "December 2020", "28");
	flightsPage.bookTicket();
	flightReviewPage.fillPassengerDetails(title, firstName, lastName, countryCode, number, email);
	
	String actual=flightReviewPage.getAmazonTitle(); 
	
	assertEquals(actual, Constants.AMAZON_PAGE_TITLE);
	
	
   }

	
	
	
	
	
	
	
}
