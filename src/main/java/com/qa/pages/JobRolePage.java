package com.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utils.TestUtils;

public class JobRolePage extends TestBase{

	@FindBy(xpath="//h4[contains(text(),'Job Role')]")
	WebElement pageLable;
	
	@FindBy(xpath="(//img[@alt='logo'])[1]")
	WebElement logoImg;
	
	@FindBy(xpath="//b[contains(text(),'Rising Stars')]")
	WebElement logoText;

	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement addButton;
	
	@FindBy(id="jobRoleName")
	WebElement jobRoleNameTxtBox;
	
	@FindBy(id="jobRoleDescription")
	WebElement jobRoleDescTxtArea;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public JobRolePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getJobRoleTitle(){
		return driver.getTitle();
	}
	
	public String verifypageLable(){
		return pageLable.getText();
	}
	
	public boolean validatelogo() {
		if(logoImg.isDisplayed() && logoText.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void saveRole(String roleName,String roleDesc){
		addButton.click();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITE_WAIT,TimeUnit.SECONDS);
		
		jobRoleNameTxtBox.sendKeys(roleName);
		jobRoleDescTxtArea.sendKeys(roleDesc);
		
		saveBtn.click();
		//Need to add database insert method
	}

	public List verifyRoleListTodb(){
		
		// add db code to getAll data from jobRole table
		return new ArrayList();
	}
	
	
}
