package com.hotels.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hotels.base.BasePage;
import com.hotels.util.ElementUtil;
import com.hotels.util.Constants;

public class HotelsMainPage1 extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By destination =By.id("qf-0q-destination");
	By newyork=By.id("citysqm-asi0-s0");
	By checkInButton =By.id("qf-0q-localised-check-in");
	By checkInDate=By.xpath("//td[@data-date='2019-11-20']//a");
	By checkoutButton =By.id("qf-0q-localised-check-out");
	By checkOutDate= By.xpath("//td[@data-date='2019-11-26']//a");
	By childrenButton=By.id("qf-0q-room-0-children");
	By searchButton= By.xpath("//button[@class='cta cta-strong']");
	By childOneAge = By.id("qf-0q-room-0-child-0-age");
	By childTwoAge= By.id("qf-0q-room-0-child-1-age");
	
	public HotelsMainPage1(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	public String getHomePageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	}
	public void chooseDestination() throws InterruptedException{
		
		elementUtil.doSendKeys(destination, "New York, New York,");
		elementUtil.waitForElementPresent(newyork);
		elementUtil.doClick(newyork);
		
	}
	public void CheckInOutDate() throws InterruptedException{
		elementUtil.doClick(checkInButton);
		elementUtil.waitForElementPresent(checkInDate);
		elementUtil.getElement(checkInDate).click();
		elementUtil.waitForElementPresent(checkoutButton);
		elementUtil.doClick(checkoutButton);
		elementUtil.waitForElementPresent(checkOutDate);
		elementUtil.getElement(checkOutDate).click();
	
	}
	public void select2Children() throws InterruptedException{
		elementUtil.waitForElementPresent(childrenButton);
		elementUtil.doClick(childrenButton);
		elementUtil.waitForElementPresent(childrenButton);
		elementUtil.selectDropDownValueByText(driver, childrenButton, "2");
		elementUtil.waitForElementPresent(childOneAge);
		elementUtil.selectDropDownValueByText(driver, childOneAge, "6");
		elementUtil.waitForElementPresent(childTwoAge);
		elementUtil.selectDropDownValueByText(driver, childTwoAge, "9");
		
		
		
	}
	public void submitSearch() throws InterruptedException{
		elementUtil.waitForElementPresent(searchButton);
		elementUtil.doClick(searchButton);
		
	}
	public void searchMenu() throws InterruptedException{
		chooseDestination();
		CheckInOutDate();
		select2Children();
		submitSearch();
	}
}
