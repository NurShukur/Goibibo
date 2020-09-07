package com.qa.goibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.goibibo.base.BasePage;
import com.qa.goibibo.utils.ElementUtil;

public class FlightReviewPage extends BasePage {

	WebDriver driver; 
	ElementUtil elementUtil; 
	
	
	
	// By Locators
	
	By tripRisk=By.xpath("//input[@id='secure-trip']"); 
	By title=By.id("Adulttitle1"); 
	By firstName=By.id("AdultfirstName1"); 
	By lastName=By.id("AdultlastName1"); 
	By email =By.xpath("//input[@type='email']"); 
	By countryCode= By.xpath("//select[@id='mobilecode']");
	By number = By.xpath("//input[@id='mobile']");
	By proceed=By.xpath("//div[text()='Proceed ']"); 
	By covidButton= By.xpath("//button[text()='OK']"); 	
	By proceedPayment =By.xpath("//span[text()='Proceed To Payment']");  // wait after this 
	By wallet =By.id("tab_wallet"); 
	By pay=By.xpath("//div[@id='walletPayNow']/div"); 

	
	
	// constructor
	public FlightReviewPage(WebDriver driver) {
		
		this.driver=driver; 
		elementUtil=new ElementUtil(this.driver);
	}

	// Page actions 
	
	public String getAmazonTitle() {
		
		
		return elementUtil.doGetPageTitleWithContains(10, "Amazon"); 
	}
	
	
	public void fillPassengerDetails(String title,String firstName,String lastName,String countryCode, String number, String email) throws InterruptedException {
		
		
		//elementUtil.doActionsClick(tripRisk);
		elementUtil.doSelectValuesByVisibleText(this.title, title);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSelectValuesByVisibleText(this.countryCode, countryCode);
		elementUtil.doSendKeys(this.number, number);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doClick(proceed);
		elementUtil.clickWhenReady(covidButton, 15);
		elementUtil.doClick(proceedPayment);
		elementUtil.clickWhenReady(wallet, 15);
		elementUtil.clickWhenReady(pay, 5);
		Thread.sleep(3000);
		
	}
	
	
	
	
	
	
	
	
}
