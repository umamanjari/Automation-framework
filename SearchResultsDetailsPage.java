package com.wbl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.CommonPage;
import com.wbl.utils.WebDriverWaitUtils;

public class SearchResultsDetailsPage extends CommonPage{
	
	@FindBy(how=How.XPATH,using =".//*[@id='why2buy']/div/div[1]/span")
	WebElement freeShippingButton;

	public SearchResultsDetailsPage(WebDriver driver)  {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean isFreeShippingPresent(){
      WebDriverWaitUtils.implicitWait(driver, 30);
		return  freeShippingButton.isDisplayed();
				
	}
	
	
	

}
