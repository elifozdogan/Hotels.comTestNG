package com.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotels.base.BasePage;
import com.hotels.pages.HotelsMainPage1;
import com.hotels.util.Constants;


public class HotelsMainPage1Test {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HotelsMainPage1 hotelsMainPage1;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		hotelsMainPage1 = new HotelsMainPage1(driver);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title=hotelsMainPage1.getHomePageTitle();
		System.out.println("Page title is "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
}
	@Test(priority=2)
	public void searchHotelsInNewYork() throws InterruptedException{
		hotelsMainPage1.searchMenu();
		
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}}
