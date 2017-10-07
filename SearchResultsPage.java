package com.wbl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.CommonPage;
import com.wbl.utils.WebDriverWaitUtils;

public class SearchResultsPage extends CommonPage {
	
	
    @FindBy(how=How.XPATH,using=".//*[@id='DashSortByContainer']/ul[1]/li/a")
	WebElement sortDropDown;
    @FindBy(how=How.CSS,using ="#SortMenu>li>a")
    List<WebElement> sortdropDownValues;
    @FindBy(how=How.CSS,using =".amt.bold")
    List<WebElement> prices;
    @FindBy(how=How.CSS,using =".rls>a>b")
    List<WebElement> searchLinks;
   @FindBy(how=How.CSS,using=".vip")
	List<WebElement> clickSearchResultsLinks;
	public SearchResultsPage(WebDriver driver) {
    	 super(driver);
    	 PageFactory.initElements(driver, this);
		
	}

	
public void  selectValueFromSortDropDown(String value){
	WebDriverWaitUtils.explicitWait(driver, 20, sortDropDown); 
	sortDropDown.click();
	for(WebElement val:sortdropDownValues){
		if(val.getText().equals(value)){
			val.click();
			break;
		}
			
	}
	String actualprice=(prices.get(0).getText());
	System.out.println("Max in List: "+actualprice);
	
	
}
public void pricesInSearchResults(){
	for(WebElement elm   : prices){
		System.out.println(elm.getText());
	}
}
public int relatedSearchLinks(){
	return searchLinks.size();
}

public SearchResultsDetailsPage clicksearchResultsLinks(int index){
	clickSearchResultsLinks.get(index).click();
    return new SearchResultsDetailsPage(driver);
}

/*public String  actualMaxPricesInSearchResults(){
 String price=prices.get(0).getText();//.replaceAll("[^0-9].", ""));
	System.out.println(price);
	return price;
}*/

/*public String maxPricesInSearchResults(){
	String max;
	for(WebElement elm:prices){
		System.out.println(elm.getText()); 
		String price=elm.getText();//.replaceAll("[^0-9].", ""));
	
	System.out.println(max);
	return max;
}}*/
}

