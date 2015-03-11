package com.epam.Sergey_Mokhov.pages;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@At("http://market.yandex.ru/")
public class StartPage extends PageObject{
	public StartPage (WebDriver webdriver){
		super(webdriver);
	}
	
	@FindBy(xpath = "//a[@class = 'link topmenu__link' and contains(., 'Компьютеры')]")
	public WebElementFacade categoryPC;
	
	@FindBy(xpath = "//a[@class = 'link topmenu__link' and contains(., 'Электроника')]")
	public WebElementFacade categoryElectronics;
	
	@FindBy(xpath = "//a[contains(@class, 'topmenu__subitem') and contains(., 'Монитор')]")
	public WebElementFacade subCategoryMonitor;
	
	@FindBy(xpath = "//a[contains(@class, 'topmenu__subitem') and contains(., 'GPS')]")
	public WebElementFacade subCategoryGPS;
	
	@FindBy(xpath = "//*[@class = 'personal-basket__content personal-basket__content_state_empty']")
	public WebElementFacade basket;
	
	@FindBy(xpath = "//button[contains(., 'Корзина')]")
	public WebElementFacade basketButton;
	
	
}
