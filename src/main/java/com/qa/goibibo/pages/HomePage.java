package com.qa.goibibo.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.goibibo.base.BasePage;
import com.qa.goibibo.utils.ElementUtil;

public class HomePage extends BasePage {

	
	private  WebDriver driver; 
	ElementUtil elementUtil;

	//By Locators 
	
	By from=By.id("gosuggest_inputSrc"); 
	By from1=By.id("react-autosuggest-1-suggestion--0");
	By destination = By.id("gosuggest_inputDest");
	By departure_date =By.id("departureCalendar"); 
	By return_date=By.id("returnCalendar"); 
	By search = By.id("gi_search_btn"); 
	By next=By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']");
	By book =By.xpath("//input[@value='BOOK']");
	By year=By.xpath("//div[@class='DayPicker-Caption']");
	
	
	
	// Constructor 
	public HomePage(WebDriver driver){

		this.driver=driver; 
		
	 elementUtil=new ElementUtil(this.driver); 
	 
	}
	
	// Page actions 
	
	public String getTitle () {
		
		return  driver.getTitle();
		
	}
	
	public boolean enterFlightDetails (String from,String destination ,String monthYear1,String day1, String monthYear2,String day2) throws InterruptedException {
	
		elementUtil.doSendKeys(this.from, from);
	
		
		elementUtil.doClick(from1);
		elementUtil.doSendKeys(this.destination, destination);
		elementUtil.doClick(from1);
		
		departureDate(monthYear1, day1);
		returnDate(monthYear2, day2);
		
		elementUtil.doClick(search);
		
		return elementUtil.waitForElementToBeVisible(book, 10).isDisplayed();
		
	}
	
	
	public void departureDate  (String monthYear,String day) {
		
		
		elementUtil.doClick(departure_date);
		
				
				while (true ) {
					
					String date=elementUtil.doGetText(year);
				if (date.equalsIgnoreCase(monthYear)) {
					
					break;
			}
	
				else {
						
					elementUtil.doClick(next);
					
				}
				}
		
				elementUtil.doClick(By.xpath("//div[contains(text(),'"+day+"')]"));
						}
	
	
    public void returnDate (String monthYear, String day) {
    	
    	elementUtil.doClick(return_date);
		

				while (true ) {
				
					String date=elementUtil.doGetText(year);
				if (date.equalsIgnoreCase(monthYear)) {
					
					break;
			}
	
				else {
					
					elementUtil.doClick(next);			
					
				}
				}
				
				driver.findElement(By.xpath("//div[contains(text(),'"+day+"')]")).click();
		
		}
    
    		
    
   
    
    
    
    
    
    
		
		
			
		
		
	}

	
	
	
	

