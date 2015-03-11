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
@Story(Application.YandexMarket.FindMonitor.class)
public class PositiveFilterTest {
	@Managed
	public WebDriver webdriver;
	
	@ManagedPages()
	public Pages pages;
	
	@Steps
	public UserSteps user;
	
	@Test
	public void positiveFilterTest(){
		user.navigate("http://market.yandex.ru");
		user.findMonSteps.doGoToMonitors();
		user.findMonSteps.enterToPrice(5000);
		user.findMonSteps.clickApply();
		user.findMonSteps.checkAllItemsAreMonitors();
		user.findMonSteps.checkAllItemsPrices(5000);
	}
}
