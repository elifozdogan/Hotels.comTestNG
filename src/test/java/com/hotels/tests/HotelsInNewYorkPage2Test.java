package com.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotels.base.BasePage;
import com.hotels.pages.HotelsInNewYorkPage2;
import com.hotels.pages.HotelsMainPage1;
import com.hotels.util.Constants;
import com.hotels.util.JavaScriptUtil;

public class HotelsInNewYorkPage2Test {
			
			WebDriver driver;
			Properties prop;
			BasePage basePage;
			HotelsMainPage1 hotelsMainPage1;
			HotelsInNewYorkPage2 hotelsInNewYorkPage2;
			
			
			@BeforeMethod
			public void setUp() throws InterruptedException{
				basePage = new BasePage();
				prop = basePage.initialize_properties();
				driver = basePage.initialize_driver(prop);
				hotelsMainPage1 = new HotelsMainPage1(driver);
				hotelsMainPage1.searchMenu();
				hotelsInNewYorkPage2= new HotelsInNewYorkPage2(driver);
		
		
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}
			@Test(priority=1)
			public void verifyHomePageTitleTest(){
				String title=hotelsInNewYorkPage2.getHomePageTitle();
				System.out.println("Page title is "+title);
				Assert.assertEquals(title, Constants.HOTELS_PAGE_TITLE);
		}
			@Test(priority=2)
			public void Search3StarHotels() throws InterruptedException{
				hotelsInNewYorkPage2.Select3StarHotels();
				hotelsInNewYorkPage2.verifySelectedOption("3");
				hotelsInNewYorkPage2.scrollDownToGetListOfHotels();
				hotelsInNewYorkPage2.getHotelsList("3");
				hotelsInNewYorkPage2.distanceCheck();
				hotelsInNewYorkPage2.HiltonIsOnTheList();
		   
		        }
			@Test(priority=3)
			public void Search4StarHotels() throws InterruptedException{
				hotelsInNewYorkPage2.Select4StarHotels();;
				hotelsInNewYorkPage2.verifySelectedOption("4");
				hotelsInNewYorkPage2.scrollDownToGetListOfHotels();
				hotelsInNewYorkPage2.getHotelsList("4");
				hotelsInNewYorkPage2.distanceCheck();
				hotelsInNewYorkPage2.HiltonIsOnTheList();
		   
		        }
			@Test(priority=4)
			public void Search5StarHotels() throws InterruptedException{
				hotelsInNewYorkPage2.Select5StarHotels();;
				hotelsInNewYorkPage2.verifySelectedOption("5");
				hotelsInNewYorkPage2.scrollDownToGetListOfHotels();
				hotelsInNewYorkPage2.getHotelsList("5");
				hotelsInNewYorkPage2.distanceCheck();
				hotelsInNewYorkPage2.HiltonIsOnTheList();
		   
		        }
			@AfterMethod
			public void tearDown(){
				driver.quit();
		}
}
