package com.qa.goibibo.tests;



import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.goibibo.base.BasePageTest;
import com.qa.goibibo.pages.FlightsPage;
import com.qa.goibibo.utils.Constants;
public class FlightsPageTest extends BasePageTest {

	
	@Test
	public void getTitleTest () {
	String title = homePage.getTitle(); 
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
		
	}
	
	@Test (priority=1)
	public void bookTicketsTest()  throws InterruptedException {
		homePage.enterFlightDetails("Del", "Mum", "December 2020", "21", "December 2020", "28");
		flightsPage.bookTicket();
		Thread.sleep(5000);
		
	
	}
	 
	
	
	

	
}
