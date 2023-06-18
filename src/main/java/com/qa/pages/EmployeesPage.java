package com.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;
import com.qa.utils.TestUtils;

public class EmployeesPage extends TestBase{

	@FindBy(xpath="//h4[contains(text(),'Employee')]")
	WebElement pageLable;
	
	@FindBy(xpath="(//img[@alt='logo'])[1]")
	WebElement logoImg;
	
	@FindBy(xpath="//h4[contains(text(),'Employee')]")
	WebElement logoText;

	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement addButton;
	
	@FindBy(id="employeeName")
	WebElement employeeNameTxtBox;
	
	@FindBy(id="skills")
	WebElement skillsTxtBox;
	
	@FindBy(id="multipartFile")
	WebElement uploadfile;
	
	@FindBy(id="jobRoleId")
	WebElement jobRoleIdSelect;
	
	@FindAll(value = {@FindBy(name="gender")})
	List<WebElement> radioBtns;
	
	@FindBy(id="stateId")
	WebElement stateIdSelect;
	
	@FindBy(id="cityId")
	WebElement cityIdSelect;

	@FindBy(id="email")
	WebElement emailtxtbox;
	
	@FindBy(id="phoneNo")
	WebElement phoneNoTxtBox;
	
	@FindBy(id="dob")
	WebElement dobTxtBox;
	
	@FindBy(id="pinCode")
	WebElement pinCodeTxtBox;
	
	@FindBy(id="address")
	WebElement addressTxtArea;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public EmployeesPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getEmployeeTitle(){
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
	
	public void saveEmployee(Map<String,String> empData){
		addButton.click();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITE_WAIT,TimeUnit.SECONDS);
		
		employeeNameTxtBox.sendKeys(empData.get("EmpName"));
		skillsTxtBox.sendKeys(empData.get("skills"));
		uploadfile.sendKeys(empData.get("filePath"));
		
		jobRoleIdSelect.click();
		Select selectRole = new Select(jobRoleIdSelect);
		selectRole.selectByVisibleText(empData.get("jobRole"));
		
		String gender = empData.get("gender");
		if(gender.equals("Male")){
			radioBtns.get(0).click();
		}else if(gender.equals("Female")){
			radioBtns.get(1).click();
		}else{
			radioBtns.get(-1).click();
		}
		
		stateIdSelect.click();
		Select selectState = new Select(stateIdSelect);
		selectState.selectByVisibleText(empData.get("state"));
		
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITE_WAIT,TimeUnit.SECONDS);
		
		cityIdSelect.click();
		Select selectCity = new Select(cityIdSelect);
		selectCity.selectByVisibleText(empData.get("city"));
		
		emailtxtbox.sendKeys(empData.get("email"));
		phoneNoTxtBox.sendKeys(empData.get("phoneNo"));
		dobTxtBox.sendKeys(empData.get("dob"));
		pinCodeTxtBox.sendKeys(empData.get("pincode"));
		addressTxtArea.sendKeys(empData.get("address"));
		
		saveBtn.click();
		//Need to add database insert method
	}

	public List verifyEmployeeListTodb(){
		
		// add db code to getAll data from jobRole table
		return new ArrayList();
	}
}
