package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.EmployeesPage;
import com.qa.pages.HomePage;
import com.qa.pages.JobRolePage;
import com.qa.pages.LoginPage;
import com.qa.pages.RewardPage;
import com.qa.utils.TestUtils;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	RewardPage rewardPage;
	JobRolePage jobRolePage;
	EmployeesPage employeesPage;
	TestUtils testUtils;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initializeDriver();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		//String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(homePage.getHomePageTitle(), "Admin | Index","Home page title not matched.");
	}
	
	@Test(priority=2)
	public void homePageLogoTest(){
		Assert.assertTrue(homePage.validatelogo());
	}
	
	@Test(priority=2)
	public void validateUserNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=2)
	public void validateManuListTest(){
		Assert.assertEquals(homePage.validateManuList(), 14);
	}
	
	@Test(priority=3)
	public void dasbordLinkTest(){
		homePage = homePage.clickOnDashBordLink();
		Assert.assertEquals(homePage.getHomePageTitle(), "Admin | Index","Home page title not matched.");
	}
	
	@Test(priority=3)
	public void RewardLinkTest(){
		rewardPage = homePage.clickOnRewardLink();
	}
	
	@Test(priority=3)
	public void JobRoleLinkTest(){
		jobRolePage = homePage.clickOnJobRoleLink();
	}
	
	@Test(priority=3)
	public void EmployeesLinkTest(){
		employeesPage = homePage.clickOnEmployeesLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
