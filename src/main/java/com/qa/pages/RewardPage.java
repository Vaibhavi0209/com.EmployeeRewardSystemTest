package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class RewardPage extends TestBase{

	@FindBy(xpath="(//img[@alt='logo'])[1]")
	WebElement logoImg;
	
	@FindBy(xpath="//b[contains(text(),'Rising Stars')]")
	WebElement logoText;
	
	@FindBy(xpath="//h4[contains(text(),'Rewards')]")
	WebElement pageLable;
	
	public RewardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getRewardPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatelogo(){
		if(logoImg.isDisplayed() && logoText.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String verifypageLable(){
		return pageLable.getText();
	}
	
}