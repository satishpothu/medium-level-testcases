package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SendmailPOM {
	
	private WebDriver driver; 
	public SendmailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//i[@class = 'fa fa-share-alt fa-fw']")
	WebElement marketinglink;
	
	
	@FindBy(xpath = "//*[@id='menu']/li[7]/ul/li[4]/a")
	WebElement mail;
	
	
	@FindBy(id = "input-to")
	WebElement Tolistbox;
	
	
	@FindBy(name = "subject")
	WebElement subjectbox;
	
	@FindBy(xpath = "//*[@class = 'note-editable panel-body']")
	WebElement messagebox;
	
	@FindBy(id = "button-send")
	WebElement mailicon;
	
	
	public void clickonmarketingreports()
	{
		this.marketinglink.click();
		
	}

	
	
	
	public void clickonmail()
	{
		this.mail.click();
	}
	
	public void selectinttolist(String recipient)
	{
	
	Select sel = new Select(Tolistbox);
	sel.selectByVisibleText(recipient);
		
	}
	
	public void Entersubjecttextbox(String text)
	{
		
		this.subjectbox.sendKeys(text);
		
	}
	
	
	public void Entermessage(String msg)
	{
		
		this.messagebox.sendKeys(msg);
	}
	
	public void Clickonmailicon()
	
	
	{
		
	this.mailicon.click();
		
		
		
	}
	
}