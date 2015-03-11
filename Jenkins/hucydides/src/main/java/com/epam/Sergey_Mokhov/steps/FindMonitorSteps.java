package com.epam.Sergey_Mokhov.steps;

import java.util.List;

import org.junit.Assert;

import org.openqa.selenium.interactions.Actions;

import com.epam.Sergey_Mokhov.pages.MonitorSearchAdvancedPage;
import com.epam.Sergey_Mokhov.pages.MonitorSearchSimplePage;
import com.epam.Sergey_Mokhov.pages.StartPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.steps.ScenarioSteps;

public class FindMonitorSteps extends ScenarioSteps {
	private static final long serialVersionUID = -5140872565840918133L;

	public FindMonitorSteps(Pages pages) {
		super(pages);
	}

	private StartPage onStartPage() {
		return pages().get(StartPage.class);
	}

	private MonitorSearchSimplePage onMonitorSearchSimplePage() {
		return pages().get(MonitorSearchSimplePage.class);
	}

	private MonitorSearchAdvancedPage onMonitorSearchAdvancedPage() {
		return pages().get(MonitorSearchAdvancedPage.class);
	}

	@Step
	public void selectCategoryPC() {
		onStartPage().categoryPC.waitUntilVisible();
		new Actions(getDriver()).moveToElement(onStartPage().categoryPC).build().perform();
	}

	@Step
	public void selectSubCategoryMonitor() {
		onStartPage().subCategoryMonitor.click();
	}

	@Step
	public void clickAdvancadSearch() {
		onMonitorSearchSimplePage().advancedSearch.click();
	}

	@StepGroup
	public void doGoToMonitors() {
		selectCategoryPC();
		selectSubCategoryMonitor();
		clickAdvancadSearch();
	}

	@Step
	public void enterToPrice(int toPrice) {
		String price = Integer.toString(toPrice);
		onMonitorSearchAdvancedPage().priceTo.waitUntilVisible().type(price);
	}

	@Step
	public void clickApply(){		
		onMonitorSearchAdvancedPage().applyButton.click();
	}

	@Step
	public void checkAllItemsAreMonitors() {
		onMonitorSearchAdvancedPage().waitForReloadResults();
		onMonitorSearchAdvancedPage().resultsList.waitUntilVisible();
		List<WebElementFacade> results = onMonitorSearchAdvancedPage().getResults();
		int size = results.size();
		for (int i = 0; i < size; i++) {
			results.get(i).waitUntilVisible();
			Assert.assertTrue("One ore more result is not Monitor", results.get(i).containsText("монитор"));
		}
	}

	@Step
	public void checkAllItemsPrices(int toPrice) {
		onMonitorSearchAdvancedPage().resultsList.waitUntilVisible();
		List<WebElementFacade> results = onMonitorSearchAdvancedPage().getResultPrices();
		int size = results.size();
		for (int i = 0; i < size; i++) {
			results.get(i).waitUntilVisible();
			int currentPrice = Integer.parseInt(results.get(i).getText().replaceAll("\\D", ""));
			Assert.assertTrue("One or more monitors are more expensive than "+toPrice, currentPrice <= toPrice);
		}
	}
}
