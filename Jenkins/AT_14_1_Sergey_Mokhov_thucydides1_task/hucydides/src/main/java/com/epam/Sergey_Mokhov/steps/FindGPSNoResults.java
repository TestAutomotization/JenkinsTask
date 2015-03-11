package com.epam.Sergey_Mokhov.steps;


import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import com.epam.Sergey_Mokhov.pages.GPSSearchAdvancedPage;
import com.epam.Sergey_Mokhov.pages.GPSSearchSimplePage;
import com.epam.Sergey_Mokhov.pages.StartPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class FindGPSNoResults extends ScenarioSteps{
	private static final long serialVersionUID = 7508818487873746743L;
	
	public FindGPSNoResults(Pages pages) {
		super(pages);
	}

	private StartPage onStartPage() {
		return pages().get(StartPage.class);
	}

	private GPSSearchSimplePage onGPSSearchSimplePage() {
		return pages().get(GPSSearchSimplePage.class);
	}

	private GPSSearchAdvancedPage onGPSSearchAdvancedPage() {
		return pages().get(GPSSearchAdvancedPage.class);
	}

	@Step
	public void selectCategoryElectronics() {
		onStartPage().basketButton.click();
		onStartPage().basket.waitUntilNotVisible();
		onStartPage().categoryElectronics.waitUntilVisible();
		new Actions(getDriver()).moveToElement(onStartPage().categoryElectronics).build().perform();
	}

	@Step
	public void selectSubCategoryGPS() {
		onStartPage().subCategoryGPS.click();
	}

	@Step
	public void clickAdvancadSearch() {		
		onGPSSearchSimplePage().advancedSearch.click();
	}

	@StepGroup
	public void doGoToGPS() {
		selectCategoryElectronics();
		selectSubCategoryGPS();
		clickAdvancadSearch();
	}

	@Step
	public void enterToPrice(int toPrice) {
		String price = Integer.toString(toPrice);
		onGPSSearchAdvancedPage().priceTo.waitUntilVisible().type(price);
	}

	@Step
	public void clickApply(){		
		onGPSSearchAdvancedPage().applyButton.click();
	}
	
	@Step
	public void selectBrand(String brand){		
		onGPSSearchAdvancedPage().getBrand(brand).click();
	}

	@Step
	public void checkNoItems(){
		onGPSSearchAdvancedPage().noItemsMark.waitUntilVisible();
		Assert.assertTrue("No Itams found element invisible", onGPSSearchAdvancedPage().noItemsMark.isCurrentlyVisible());
	}
}
