package com.qa.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.EmployeesPage;
import com.qa.pages.HomePage;
import com.qa.pages.JobRolePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

public class EmployeePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	JobRolePage jobRolePage;
	EmployeesPage employeePage;
	
	String sheetName = "Employee";
	
	public EmployeePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initializeDriver();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		employeePage = homePage.clickOnEmployeesLink();
	}
	
	@Test(priority=1)
	public void employeePageTitleTest(){
		Assert.assertEquals(employeePage.getEmployeeTitle(), "Admin | Employee","Employee page title not matched.");
	}
	
	@Test(priority=2)
	public void employeePageLogoTest(){
		Assert.assertTrue(employeePage.validatelogo());
	}
	
	@Test(priority=2)
	public void employeePageLableTest(){
		Assert.assertEquals(employeePage.verifypageLable(),"Employee","Employee page LAble not matched.");
	}
	
	@Test(priority=2)
	public void validateManuListTest(){
		Assert.assertEquals(homePage.validateManuList(), 14);
	}
	
	@DataProvider
	public Object[][] getEmployeeData(){
		Object empData[][] = TestUtils.getTestData(sheetName);
		return empData;
	}
	
	@Test(priority=3,dataProvider="getEmployeeData")
	public void saveEmployeeTest(String EmpName,String skills,String filePath,String jobRole,String gender,String state,String city,String email,
			String phoneNo,String dob,String pincode,String address){
		Map<String,String> employeeMap = new HashMap<String,String>();
		employeeMap.put("EmpName", EmpName);
		employeeMap.put("skills", skills);
		employeeMap.put("filePath", filePath);
		employeeMap.put("jobRole", jobRole);
		employeeMap.put("gender", gender);
		employeeMap.put("state", state);
		employeeMap.put("city", city);
		employeeMap.put("email", email);
		employeeMap.put("phoneNo", phoneNo);
		employeeMap.put("dob", dob);
		employeeMap.put("pincode", pincode);
		employeeMap.put("address", address);
		//employeePage.saveEmployee(employeeMap);
	}
	
	//@Test(priority=4)
	public void verifyEmployeeListTodbTest(){
		Assert.assertEquals(employeePage.verifyEmployeeListTodb(), 2);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
