package com.epam.Sergey_Mokhov.pages;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class MonitorSearchSimplePage extends PageObject{
	public MonitorSearchSimplePage (WebDriver webdriver){
		super(webdriver);
	}
	
	@FindBy(xpath = "//a[contains(., 'расширенный поиск')]")
	public WebElementFacade advancedSearch;
}
