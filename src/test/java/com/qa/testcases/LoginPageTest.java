package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage HomePage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initializeDriver();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		//String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPage.getLoginPageTitle(), "Employee Rewards System | Login");
	}
	
	@Test(priority=2)
	public void loginPageLogoTest(){
		Assert.assertEquals(loginPage.validatelogo(), true);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException{
		HomePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
