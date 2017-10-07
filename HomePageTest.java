package com.wbl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.base.BasePage;
import com.wbl.utils.Constants;
import com.wbl.utils.ExcelHelper;



public class HomePageTest extends BasePage {
	HomePage hm;
	SearchResultsPage sp;
	@BeforeMethod
	public void beforeMethod(){
		hm=new HomePage(driver);
		
	}
	public HomePageTest(){
		PageFactory.initElements(driver, HomePage.class);
		}
	@DataProvider(name="searchData")
	public Object[][]  testData(){
		return ExcelHelper.getExcelData("EBayHomePage.xlsx", "Sheet1");
	}
	
	
	@Test(dataProvider="searchData")
	public void clickSearchButtonTest(String searchKeyword,String expected){
		hm=new HomePage(driver);
	    sp=hm.clickSearchButton(searchKeyword);	
	    Assert.assertEquals(expected, sp.getTitle());
		
			}
	
	@Test
	public void headerNavigationLinksTest(){
		hm=new HomePage(driver);
	    Assert.assertEquals(4,hm.headerNavigationLinks());//4
	   
	}
	@Test
	public void homePageLinksTest(){
		hm=new HomePage(driver);
		Assert.assertEquals(11, hm.homePageLinks());
	}
	
	@Test
	public void sliderImageTest(){
		hm=new HomePage(driver);
		Assert.assertEquals(7, hm.sliderImages());
		
	}

}
