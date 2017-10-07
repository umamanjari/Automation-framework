package com.wbl.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wbl.HomePage;
import com.wbl.SearchResultsPage;

public class CommonPage {
	protected WebDriver driver;
	@FindBy(how=How.ID,using ="gh-ac")
	WebElement searchbox;
	@FindBy(how=How.ID,using ="gh-btn")
	WebElement searchbutton;
	@FindBy(how=How.CSS,using =".gh-p")
	List<WebElement> headerNavigationLink;
	@FindBy(how=How.CSS,using =".thrd.gf-bar-a")
	List<WebElement> footerLink;
	
	
	public CommonPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getTitle(){
	       return driver.getTitle();
	}
	public SearchResultsPage clickSearchButton(String searchdata){
		
		searchbox.sendKeys(searchdata);
		searchbutton.click();;
		return new SearchResultsPage(driver);
		
	}
	
 public int headerNavigationLinks(){
	return headerNavigationLink.size();//3
	 
 }
 public void headerModalDropDown(){
	WebElement element=driver.findElement(By.linkText("My eBay"));
	 Actions action=new Actions(driver);
	 action.moveToElement(element).perform();
	List<WebElement> elms= driver.findElements(By.cssSelector(".gh-eb-oa.thrd"));//10
	for(WebElement elm:elms){
		System.out.println(elm.getText());
	}
		 
	 }
 public int footerLink(){
	 return footerLink.size();
 }
 
 }

