package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.*;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SendmailTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private SendmailPOM SendmailPOM;
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
		SendmailPOM = new SendmailPOM(driver);
		baseUrl = properties.getProperty("baseURL");	
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test()
	public void Sendmail() {
		
		//giving user name
		loginPOM.sendUserName("admin");
		
		//giving password
		loginPOM.sendPassword("admin@123");
		
		//clicking on login button
		loginPOM.clickLoginBtn();
		
       //Clicking on marketing reports
       SendmailPOM.clickonmarketingreports();
       
       //Clicking on mail
       SendmailPOM.clickonmail();
       
       //Selecting to list as affiliates
       SendmailPOM.selectinttolist("Affiliates");
       
       
       //Entering subject box
       SendmailPOM.Entersubjecttextbox("New Product launch");
       
       //Typing message to be sent
       SendmailPOM.Entermessage("New Product Launch to be launched on 25th  February 2019");
       
       //clicking on send
       SendmailPOM.Clickonmailicon();
       
       
       
       
       
       
       

	
		
		
		

         
		
	 
		
		
			
		
		
	
	
  
			
	
			
				
		
	
	}


}

