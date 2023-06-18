package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.JobRolePage;
import com.qa.pages.LoginPage;
import com.qa.pages.RewardPage;

public class JobRolePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	JobRolePage jobRolePage;
	RewardPage rewardPage;
	String role = "test";
	
	public JobRolePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initializeDriver();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		jobRolePage = homePage.clickOnJobRoleLink();
	}
	
	@Test(priority=1)
	public void jobRolePageTitleTest(){
		//String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(jobRolePage.getJobRoleTitle(), "Admin | Job Role","Job Role page title not matched.");
	}
	
	@Test(priority=2)
	public void jobRolePageLogoTest(){
		Assert.assertTrue(jobRolePage.validatelogo());
	}
	
	@Test(priority=2)
	public void jobRolePageLableTest(){
		Assert.assertEquals(jobRolePage.verifypageLable(),"Job Role","Job Role page LAble not matched.");
	}
	
	@Test(priority=2)
	public void validateManuListTest(){
		Assert.assertEquals(homePage.validateManuList(), 14);
	}
	
	@Test(priority=3)
	public void saveJovRoleTest(){
		jobRolePage.saveRole(role, "test");
	}
	
	//@Test(priority=4)
	public void verifyRoleListTodbTest(){
		Assert.assertEquals(jobRolePage.verifyRoleListTodb(), 2);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}