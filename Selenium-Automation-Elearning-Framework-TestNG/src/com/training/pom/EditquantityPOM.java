package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditquantityPOM {
	
	private WebDriver driver; 
	public EditquantityPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class = 'fa fa-pencil']")
	WebElement Editbutton;

	
	@FindBy(xpath = "//*[@id = 'form-product']/ul/li[2]/a") 
	WebElement databutton;
	
	@FindBy(id = "input-minimum")
	WebElement quantity;
	
	
	@FindBy(xpath = "//*[@class = 'btn btn-primary']")
	WebElement save;
	
	@FindBy(xpath = "//*[@class = 'alert alert-success']")
	WebElement alerttext;
	
	public void clickEditbutton()
	{
		
		this.Editbutton.click();
	}
	
	public void clickdatabutton() {

	this.databutton.click();
	
}
	
  public void changequantity(String givenquantity)
  
  {
	  this.quantity.clear();
	  
	  this.quantity.sendKeys(givenquantity);
	  
	  
  }
  
  public void clickonsave()
  {
  
  this.save.click();
  
  }
  
  public String getalerttext()
  {
	  
  return	  
  this.alerttext.getText();
   
  }
  
  }
	
