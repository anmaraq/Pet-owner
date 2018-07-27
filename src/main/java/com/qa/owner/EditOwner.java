package com.qa.owner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditOwner {
	
	String firstn = "Anmar";
	String lastn = "Smith";
	String Oaddress = "66 Oak Lane";
	String Ocity = "Manchester";
	String Otelephone = "5645614644";
	
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[11]/td[1]/a")
	private WebElement user;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/button[2]")
	private WebElement edit;
	
	@FindBy(xpath = "//*[@id=\"firstName\"]")
	private WebElement first;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	private WebElement last;
	
	@FindBy(xpath = "//*[@id=\"address\"]")
	private WebElement address;

	@FindBy(xpath = "//*[@id=\"city\"]")
	private WebElement city;

	@FindBy(xpath = "//*[@id=\"telephone\"]")
	private WebElement telephone;
	
	@FindBy(xpath = "/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]")
	private WebElement update;
	

	public void editO() {
		
		user.click();
		edit.click();
		first.clear();
		first.sendKeys(firstn);
		last.clear();
		last.sendKeys(lastn);
		address.clear();
		address.sendKeys(Oaddress);
		city.clear();
		city.sendKeys(Ocity);
		telephone.clear();
		telephone.sendKeys(Otelephone);
		update.click();
			
	}


}
