package com.wbl;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BasePage;

public class SearchResultsPageTest extends BasePage {
	HomePage hm;
	SearchResultsPage sp;
	
	
	
	
	public SearchResultsPageTest(){
	PageFactory.initElements(driver, SearchResultsPage.class);
	}
		
	@Test
	public void maxPricesortTest() throws Exception{
		hm=PageFactory.initElements(driver, HomePage.class);
	    SearchResultsPage	sp=hm.clickSearchButton("Shoes");
	    sp.selectValueFromSortDropDown("Price + Shipping: highest first");
	    sp.pricesInSearchResults();

	    Assert.assertTrue(sp.clicksearchResultsLinks(0).getTitle().contains("Shoes"));
	   
	    
	}
	
	}


