package com.epam.Sergey_Mokhov.pages;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class GPSSearchAdvancedPage extends PageObject{
	public GPSSearchAdvancedPage (WebDriver webdriver){
		super(webdriver);
	}
	
	@FindBy(id = "gf-priceto-var")
	public WebElementFacade priceTo;
	
	@FindBy(xpath = "//button[contains(., 'Применить')]")
	public WebElementFacade applyButton;
	
	@FindBy(xpath = "//div[@class = 'snippet-list snippet-list_type_vertical island']")
	public WebElementFacade resultsList;
	
	@FindBy(xpath = "//h1[contains(., 'Нет подходящих товаров')]")
	public WebElementFacade noItemsMark;
	
	public void waitForReloadResults(){
		this.waitForAbsenceOf("//div[@class = 'snippet-list snippet-list_type_vertical island']");
	}

	public WebElementFacade getBrand(String brand){
		return this.findBy("//label[contains(@class, 'checkbox') and contains(text(), '"+brand+"')]");
	}	
}