package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[@class='nav-profile-name']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement logoImg;
	
	@FindBy(xpath="//b[contains(text(),'Rising Stars')]")
	WebElement logoText;
	
	@FindAll( value = {@FindBy (xpath ="//ul[@class='nav']//span")})
	List <WebElement> menuList;
	
	@FindBy(linkText="Dashboard")
	WebElement dashboardLink;
	
	@FindBy(linkText="Rewards")
	WebElement rewardsLink;
	
	@FindBy(linkText="Job Role")
	WebElement jobRoleLink;
	
	@FindBy(linkText="Employees")
	WebElement employeesLink;
	
	@FindBy(linkText="Event")
	WebElement EventLink;
	
	@FindBy(linkText="Event Rewards")
	WebElement EventRewardsLink;
	
	@FindBy(linkText="Product Category")
	WebElement ProductCategoryLink;
	
	@FindBy(linkText="Product")
	WebElement ProductLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatelogo(){
		if(logoImg.isDisplayed() && logoText.isDisplayed())
			return true;
		else
			return false;
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public int validateManuList(){
		return menuList.size();
	}
	
	public HomePage clickOnDashBordLink(){
		dashboardLink.click();
		return new HomePage();
	}
	
	public RewardPage clickOnRewardLink(){
		rewardsLink.click();
		return new RewardPage();
	}
	
	public JobRolePage clickOnJobRoleLink(){
		jobRoleLink.click();
		return new JobRolePage();
	}
	
	public EmployeesPage clickOnEmployeesLink(){
		employeesLink.click();
		return new EmployeesPage();
	}
	
	public EventPage clickOnEventLink(){
		EventLink.click();
		return new EventPage();
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		HomePage homePage = new HomePage();
		initializeDriver();
		
		LoginPage loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//System.out.println(homePage.getHomePageTitle());
		
		//homePage.clickOnServicesLink();
	}
}
