package com.epam.Sergey_Mokhov.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSteps extends ScenarioSteps{
	private static final long serialVersionUID = 6474911715596698692L;
	
	public UserSteps (Pages pages){
		super(pages);
	}

	@Step
	public void navigate(String URL){
		getDriver().manage().window().maximize();
		getDriver().get(URL);
	}
	
	@Steps
	public FindMonitorSteps findMonSteps;
	
	@Steps
	public FindGPSNoResults findNoResults;
}
