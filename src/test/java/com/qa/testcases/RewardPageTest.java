package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.RewardPage;

public class RewardPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	RewardPage rewardPage;
	
	public RewardPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initializeDriver();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		rewardPage = homePage.clickOnRewardLink();
	}
	
	@Test(priority=1)
	public void rewardPageTitleTest(){
		//String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(rewardPage.getRewardPageTitle(), "Admin | Rewards","Reward page title not matched.");
	}
	
	@Test(priority=2)
	public void rewardPageLogoTest(){
		Assert.assertTrue(rewardPage.validatelogo());
	}
	
	@Test(priority=2)
	public void rewardPageLableTest(){
		Assert.assertEquals(rewardPage.verifypageLable(),"Rewards","Reward page LAble not matched.");
	}
	
	@Test(priority=3)
	public void validateManuListTest(){
		Assert.assertEquals(homePage.validateManuList(), 14);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
