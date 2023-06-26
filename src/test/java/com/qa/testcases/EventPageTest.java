package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.EmployeesPage;
import com.qa.pages.EventPage;
import com.qa.pages.HomePage;
import com.qa.pages.JobRolePage;
import com.qa.pages.LoginPage;

public class EventPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	EventPage eventPage;
	
	//String sheetName = "Employee";
	
	public EventPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initializeDriver();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		eventPage = homePage.clickOnEventLink();
	}
	
	@Test(priority=1)
	public void eventPageTitleTest(){
		Assert.assertEquals(eventPage.getEventTitle(), "Admin | Event","Event page title not matched.");
	}
	
	@Test(priority=2)
	public void eventPageLogoTest(){
		Assert.assertTrue(eventPage.validatelogo());
	}
	
	@Test(priority=2)
	public void eventPageLableTest(){
		Assert.assertEquals(eventPage.verifyEventHeader(),"Event","Event page LAble not matched.");
	}
	
	@Test(priority=2)
	public void validateManuListTest(){
		Assert.assertEquals(homePage.validateManuList(), 14);
	}
	
	@Test(priority=3)
	public void saveEventTest(){
		eventPage.addEvent("Test", "Test Description", "C:\\Users\\mygoa\\Pictures\\folderorangejava_92947.ico");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
