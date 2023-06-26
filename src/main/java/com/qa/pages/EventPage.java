package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utils.TestUtils;

public class EventPage extends TestBase{

	@FindBy(xpath="//h4[contains(text(),'Event')]")
	WebElement eventHeader;
	
	@FindBy(xpath="(//img[@alt='logo'])[1]")
	WebElement logoImg;
	
	@FindBy(xpath="//b[contains(text(),'Rising Stars')]")
	WebElement logoText;

	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement addButton;
	
	@FindBy(id="eventName")
	WebElement eventNameTxtBox;
	
	@FindBy(id="eventDescription")
	WebElement eventDescTxtArea;
	
	@FindBy(id="multipartFile")
	WebElement uploadEventfile;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public EventPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getEventTitle(){
		return driver.getTitle();
	}
	
	public String verifyEventHeader(){
		return eventHeader.getText();
	}
	
	public boolean validatelogo() {
		if(logoImg.isDisplayed() && logoText.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void addEvent(String eventName,String eventDesc,String eventFile){
		addButton.click();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITE_WAIT,TimeUnit.SECONDS);
		
		eventNameTxtBox.sendKeys(eventName);
		eventDescTxtArea.sendKeys(eventDesc);
		uploadEventfile.sendKeys(eventFile);
		
		saveBtn.click();
	}

}
