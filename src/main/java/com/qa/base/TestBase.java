package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utils.TestUtils;
import com.qa.utils.WebEventListener;
import com.relevantcodes.extentreports.model.Log;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public static Logger log = Logger.getLogger(TestBase.class);

	public TestBase() {

		try {
			
			File f = new File("C:\\Users\\mygoa\\Desktop\\java\\My_Project\\git\\com.EmployeeRewardSystemTest\\src\\main\\java\\com\\qa\\config\\config.properties");
			FileInputStream fis = new FileInputStream(f);
			
			prop = new Properties();
			prop.load(fis);
			
			log.info("Launching ::: "+ prop.getProperty("browser") +" Browser");
			//System.out.println(prop.getProperty("browser"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initializeDriver() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\mygoa\\Desktop\\java\\seleniumDemo\\QA\\SeleniumJars\\chromedriver.exe");	
			driver = new ChromeDriver();
		}else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\mygoa\\Desktop\\java\\seleniumDemo\\QA\\SeleniumJars\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICITE_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		log.info("lanching URL:");
		
	}
}
