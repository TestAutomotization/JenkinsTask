package com.epam.Sergey_Mokhov.tests;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.epam.Sergey_Mokhov.features.Application;
import com.epam.Sergey_Mokhov.steps.UserSteps;

@RunWith(ThucydidesRunner.class)
@Story(Application.YandexMarket.FindGPSNoResults.class)
public class NegativeFilterTest {
	@Managed
	public WebDriver webdriver;
	
	@ManagedPages()
	public Pages pages;
	
	@Steps
	public UserSteps user;
	
	@Test
	public void negativeFilterTest(){
		user.navigate("http://market.yandex.ru");
		user.findNoResults.doGoToGPS();
		user.findNoResults.selectBrand("Navitel");
		user.findNoResults.enterToPrice(1000);
		user.findNoResults.clickApply();
		user.findNoResults.checkNoItems();
	}

}
