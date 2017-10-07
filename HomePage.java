 package com.wbl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.CommonPage;


public class HomePage  extends CommonPage{
		
	@FindBy(how=How.CSS,using =".hl-cat-nav__js-tab>a")
	List<WebElement> homePageLinks;
	@FindBy(how=How.CSS,using =".gf-bttl")
	List<WebElement> homePageFooterLink;
	@FindBy(how=How.CSS,using =".ebayui-ellipsis-3")
	List<WebElement> sliderImage;
	
	public HomePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

public int homePageLinks(){
	return homePageLinks.size();//11
}
public int homePageFooterLinks(){
	return homePageFooterLink.size();//14
}
public int sliderImages(){
	
	return sliderImage.size();
}
}
