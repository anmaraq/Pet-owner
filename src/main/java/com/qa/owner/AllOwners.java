package com.qa.owner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllOwners {
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement owners;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a")
	private WebElement find;

	public void findTab() throws InterruptedException {
		owners.click();
		Thread.sleep(2000);
		find.click();
		
	}
	
}

