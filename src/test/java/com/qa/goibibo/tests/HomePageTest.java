package com.qa.goibibo.tests;



import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.goibibo.base.BasePageTest;
import com.qa.goibibo.utils.Constants;
public class HomePageTest extends BasePageTest {

	
	@Test
	public void getTitleTest () {
		
	
	String title = homePage.getTitle(); 
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
		
	}
	
	@Test (priority=1)
	public void enterFlightDetailsTest()  throws InterruptedException {
	
		
		boolean actual=homePage.enterFlightDetails("Del", "Mum", "December 2020", "21", "December 2020", "30");	///
	
		assertEquals(actual, true);
	
	}
	 
	
	
	

	
}
