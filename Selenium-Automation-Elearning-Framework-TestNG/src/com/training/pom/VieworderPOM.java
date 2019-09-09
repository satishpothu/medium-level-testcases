package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VieworderPOM {
	
	private WebDriver driver; 
	public VieworderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class = 'fa fa-shopping-cart fa-fw']")
	private WebElement shoppingcart;
	

	@FindBy(xpath = "//li[@id = 'sale']/ul/li[1]/a")
	private WebElement orderslink;
	
	
	@FindBy(xpath = "//a[@class = 'btn btn-info']")
	private WebElement viewicon;
	
	@FindBy(xpath = "//*[@id = 'content' ]/div/div/div/a")
	private WebElement invoiceicon;
	
	public void clickonshoppingcart()

	{
	    this.shoppingcart.click();		
	}
	
	
	public void clickonorderslink()
	{
		this.orderslink.click();
	}
	
	
    public void clickonviewicon()
    {
    	
    	this.viewicon.click();
        
    }
	
	
    public void clickonprintinnovice()
    
    {
       this.invoiceicon.click();    	
    	
    }
    
}	


