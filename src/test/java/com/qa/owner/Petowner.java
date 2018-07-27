package com.qa.owner;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class Petowner {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	WebDriver driver;

	public ExtentTest test;

	ExtentReports report = new ExtentReports("C:\\Users\\Admin\\eclipse-workspace\\Owners\\Report\\Owners Report.html", true);

	
	@Before
	
	public void setup() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		test = report.startTest("Start the Test");

		driver.manage().window().maximize();
		driver.get("http://10.0.10.10:4200/petclinic/welcome");
		
		assertEquals("http://10.0.10.10:4200/petclinic/welcome", driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Home Page");
		
		Thread.sleep(2000);
	}
		
		@Test
		
		public void test() throws InterruptedException {
			
			AllOwners find = PageFactory.initElements(driver, AllOwners.class);

			find.findTab();
			
			assertEquals("http://10.0.10.10:4200/petclinic/owners", driver.getCurrentUrl());
			test.log(LogStatus.PASS, "Find Owners Page");
			
			System.out.println("Success");
			
			Thread.sleep(2000);
			
			
			EditOwner editowner = PageFactory.initElements(driver, EditOwner.class);
			editowner.editO();
			
			test.log(LogStatus.PASS, "Owner Edit Complete");
			
			Thread.sleep(2000);
						
	}
		
	@After
	public void teardown() {
		
		report.endTest(test);
		report.flush();
		
		driver.quit();
	}

}
