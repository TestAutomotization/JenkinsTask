package com.epam.Sergey_Mokhov.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class MonitorSearchAdvancedPage extends PageObject{
	public MonitorSearchAdvancedPage (WebDriver webdriver){
		super(webdriver);
	}
	
	@FindBy(id = "gf-priceto-var")
	public WebElementFacade priceTo;
	
	@FindBy(xpath = "//button[contains(., 'Применить')]")
	public WebElementFacade applyButton;
	
	@FindBy(xpath = "//div[@class = 'snippet-list snippet-list_type_vertical island']")
	public WebElementFacade resultsList;
	
	public void waitForReloadResults(){
		this.waitForAbsenceOf("//div[@class = 'snippet-list snippet-list_type_vertical island']");
	}

	public List<WebElementFacade> getResults(){
		return this.findAll("//div[contains(@class, 'snippet-card clearfix ')]");
	}
	
	public List<WebElementFacade> getResultPrices(){
		return this.findAll("//span[@class = 'price']");
	}
	
}