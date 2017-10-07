package com.wbl.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.wbl.utils.ConfigUtils;
import com.wbl.utils.Constants;
import com.wbl.utils.ScreenshotUtils;
import com.wbl.utils.WebDriverUtil;


public class BasePage {
	protected WebDriver driver;
	protected static String url;
	protected static String browser;
	static Logger log = LogManager.getLogger(BasePage.class);
	
	@BeforeSuite(alwaysRun=true)
	public void beforeSuite(){
		ConfigUtils configUtils = new ConfigUtils(Constants.RESOURCES_PATH +"config.properties");
		url=configUtils.getProperty("qaUrl");
		browser=configUtils.getProperty("browser");
	}
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest(){
		System.out.println("Test Execution Starts");
		
	}
@BeforeMethod(alwaysRun=true)
public	void beforeClass(){
		driver=WebDriverUtil.getDriver("chrome");
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
@AfterMethod(alwaysRun=true)
public void afterClass(ITestResult rs){
	log.info("rs test case name "+rs.getName());
	if(ITestResult.FAILURE==rs.getStatus())
		ScreenshotUtils.takeScreenShot(rs.getName(), driver);
	    driver.quit();
}

}
