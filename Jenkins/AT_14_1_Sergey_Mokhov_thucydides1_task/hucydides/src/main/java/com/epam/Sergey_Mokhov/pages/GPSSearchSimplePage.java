package com.epam.Sergey_Mokhov.pages;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class GPSSearchSimplePage extends PageObject{
	public GPSSearchSimplePage (WebDriver webdriver){
		super(webdriver);
	}
	
	@FindBy(xpath = "//a[contains(., 'расширенный поиск')]")
	public WebElementFacade advancedSearch;
}
