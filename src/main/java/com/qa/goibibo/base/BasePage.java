package com.qa.goibibo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public  WebDriver driver; 
	public Properties prop; 
	
	
	/**
	 * This method is used to initialize the driver on hte basis given browsername.
	 * @param prop
	 * @return driver
	 */
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser").trim();
		
		System.out.println("Your browser is : "+browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(); 	
			
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver(); 
			System.out.println("Your browser is : "+browserName);
		}
		
		else {
			System.out.println("Your"+ browserName + "is not supported , please pass defined browser ...");
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		return driver;
			
	}
	
	/**
	 * This method is used to initialize the properties from config.properties file.
	 * @param path
	 * @return prop
	 */
	
	 public Properties init_prop () {
		
		 String path="C:\\Users\\shuku\\eclipse-workspace\\"
		 		+ "Goibibo\\src\\main\\java\\com\\qa\\goibibo\\config\\config.properties";
		 prop=new Properties (); 
		 
		 try {
			FileInputStream ip=new FileInputStream(path);
			prop.load(ip);
			
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		} 
		 
		 return prop; 
		 
		

	 }
 	
	
	
	

}
