package com.wbl;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BasePage;



public class SearchResultsDetailsPageTest extends BasePage {
	HomePage hm;
	SearchResultsPage sp;
	SearchResultsDetailsPage sdp;
	public SearchResultsDetailsPageTest(){
		PageFactory.initElements(driver, SearchResultsDetailsPage.class);
		}
	@Test
	public void freeShippingTest() {
		hm=new HomePage(driver);
		sp=hm.clickSearchButton("Shoes");
		sdp=sp.clicksearchResultsLinks(0);
		    
		Assert.assertTrue(sdp.isFreeShippingPresent());
		
	}

}
