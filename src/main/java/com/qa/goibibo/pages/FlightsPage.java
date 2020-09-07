package com.qa.goibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.goibibo.base.BasePage;
import com.qa.goibibo.utils.ElementUtil;

public class FlightsPage extends BasePage {
	
	
	private  WebDriver driver; 
	ElementUtil elementUtil;

	//By Locators 
	
	By departurePriceSort=By.xpath("(//span[text()='PRICE'])[1]"); 
	By returnPriceSort=By.xpath("(//span[text()='PRICE'])[2]"); 
	By highestDepartureFlight=By.xpath("(//span[@class='custRad'])[1]"); 
	By highestReturnFlight= By.xpath("(//div[@class='fltHpyRtrnWrp']//label)[1]");
	By book =By.xpath("//input[@value='BOOK']");
	
	

	
	// Constructor 
	public FlightsPage(WebDriver driver){

		this.driver=driver; 
		
	 elementUtil=new ElementUtil(this.driver); 
	 
	}
	
	
	
	// page actions
	
	public FlightReviewPage bookTicket () throws InterruptedException {
		
		
		elementUtil.doClick(departurePriceSort);		
		elementUtil.doClick(returnPriceSort);	
		elementUtil.doClick(highestDepartureFlight);	
		elementUtil.doClick(highestReturnFlight);
		elementUtil.doClick(book);
		Thread.sleep(3000);
		
		return new FlightReviewPage(driver); 
		
	}
	
	
	

}
