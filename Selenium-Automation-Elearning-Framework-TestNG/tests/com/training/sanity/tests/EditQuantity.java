package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.CatalogPOM;
import com.training.pom.EditquantityPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class EditQuantity {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CatalogPOM CatalogPOM;
	private EditquantityPOM EditquantityPOM;
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
		EditquantityPOM =  new EditquantityPOM(driver);
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
	public void validquantityedit() throws InterruptedException {
		
		//giving user name
		loginPOM.sendUserName("admin");
		
		
		//giving password
		loginPOM.sendPassword("admin@123");
		
		//clicking on login button
		loginPOM.clickLoginBtn(); 
		
		//clicking on catalog
		CatalogPOM.clickoncatalog();
		
		Thread.sleep(2000);
		
	   //Clicking on the products
		CatalogPOM.clickonproduct();
		
		Thread.sleep(2000);
		
		//clicking on the Edit button
		EditquantityPOM.clickEditbutton();
		
		Thread.sleep(2000);
		
		//Clicking on data tab
		EditquantityPOM.clickdatabutton();
		
		Thread.sleep(2000);
		
		//Changing the quantity
		EditquantityPOM.changequantity("200");
		
		//Clicking on save
		EditquantityPOM.clickonsave();

	//Getting the success message
     String successmessage =	driver.findElement(By.xpath("//*[@class = 'alert alert-success']")).getText();
     
     //Printing the message
      System.out.println(successmessage);
      
      //Verifying the success message 
      Assert.assertEquals("Success: You have modified products!",successmessage);
      
			

	}
	}


