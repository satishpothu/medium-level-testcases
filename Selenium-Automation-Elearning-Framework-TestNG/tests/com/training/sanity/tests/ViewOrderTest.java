package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewOrderTest 

{
    private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	
	private VieworderPOM VieworderPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);	
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		VieworderPOM  = new VieworderPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test()
	public void VieworderTest() throws InterruptedException {
		
		//giving User name
		loginPOM.sendUserName("admin");
		
		//giving Password
		loginPOM.sendPassword("admin@123");
		
		//clicking on login button
		loginPOM.clickLoginBtn(); 
		
		//Clicking on shopping cart
		VieworderPOM.clickonshoppingcart();
		
		//Clicking on orders link	
		VieworderPOM.clickonorderslink();
		
		Thread.sleep(2000);
		
		//Getting all the details of the products
		String Webtable = driver.findElement(By.xpath("//*[@class = 'table-responsive']")).getText();
		System.out.println(Webtable);
		
		//clicking on viewicon
		VieworderPOM.clickonviewicon();
		
		
		//Now clicking print the invoice
		  WebElement printinvoice = driver.findElement(By.xpath("//*[@id = 'content']/div/div/div/a[1]"));
		  
		  Actions ac = new Actions(driver); 
		  Action mouseover =ac.moveToElement(printinvoice).click().build(); 
		  mouseover.perform();
		 
		// Store all currently open tabs in tabs
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				 
		// Switch newly open Tab
		driver.switchTo().window(tabs.get(1));
	
		//Printing the invoice information
		String invoicedetails = driver.findElement(By.xpath("//*[@class ='container']")).getText();
		System.out.println(invoicedetails);
		
	 
       
	}
       
	
	  
      
       
       

       
       
       
       
      
           
           
           
       
       
       
       
       
       
		
		
	
		
		
		
		
		
		
	      
}

	