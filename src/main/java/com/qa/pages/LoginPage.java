package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR(Object Repositories)

	@FindBy(id="exampleInputEmail1")
	//@CacheLookup // store web element in chache memory
	WebElement username;
	
	@FindBy(id="exampleInputPassword1")
	WebElement password;
	
	@FindBy(xpath="//input[@value='SIGN IN']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement logoImg;
	
	@FindBy(xpath="//b[contains(text(),'Rising Stars')]")
	WebElement logoText;
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatelogo(){
		if(logoImg.isDisplayed() && logoText.isDisplayed())
			return true;
		else
			return false;
	}
	
	public HomePage login(String username,String password){
	
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		
		this.loginBtn.click();
		
		return new HomePage();
	}
}
