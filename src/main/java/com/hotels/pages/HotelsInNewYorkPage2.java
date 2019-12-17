package com.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotels.base.BasePage;
import com.hotels.util.Constants;
import com.hotels.util.ElementUtil;
import com.hotels.util.JavaScriptUtil;

public class HotelsInNewYorkPage2 extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	float floatDistance;
	String strElement;
	Double doubleDistance;
	
	
	By fiveStars = By.id("f-star-rating-5");
    By fourStars = By.id("f-star-rating-4");
    By threeStars= By.id("f-star-rating-3");
  //  By containsText3 = By.xpath("//div[@class='additional-details resp-module']//span[contains(text(),'3')]");
   // By hotelNames = By.xpath("//li//a[@class='property-name-link'][contains(text(),'')]");
	By distanceToPlace = By.xpath("//li[contains(text(),'miles to City center')]");
	By hiltonAvaiable = By.xpath("//div[@class='resp-col main']//li[40] ");
	By hotelNames= By.cssSelector("a[class=property-name-link]");
	By landmarks =By.cssSelector("fieldset[id='filter-landmarks']");
	By cityCenter=By.cssSelector("label[id='f-label-lid-1506246']");
	By miles = By.cssSelector("select[id='f-distance']");
	By end =By.cssSelector("div#result-info-container");
	
	public HotelsInNewYorkPage2(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	public String getHomePageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOTELS_PAGE_TITLE);
	}
	public void Select3StarHotels() throws InterruptedException{
		
		Thread.sleep(1000);
		elementUtil.doClick(threeStars);
	
		elementUtil.waitForElementPresent(landmarks);
		Thread.sleep(3000);
		elementUtil.doClick(landmarks);
		
		elementUtil.waitForElementPresent(cityCenter);
		Thread.sleep(3000);
		elementUtil.doClick(cityCenter);
		
		elementUtil.waitForElementPresent(miles);
		Thread.sleep(2000);
		elementUtil.selectDropDownValueByValue(driver, miles, "10.0");
		Thread.sleep(2000);

	}
public void Select4StarHotels() throws InterruptedException{
		
		//Thread.sleep(1000);
		elementUtil.doClick(fourStars);
	
		elementUtil.waitForElementPresent(landmarks);
	//	Thread.sleep(3000);
		elementUtil.doClick(landmarks);
		
		elementUtil.waitForElementPresent(cityCenter);
		//Thread.sleep(3000);
		elementUtil.doClick(cityCenter);
		
		elementUtil.waitForElementPresent(miles);
		Thread.sleep(2000);
		elementUtil.selectDropDownValueByValue(driver, miles, "10.0");
		Thread.sleep(2000);

	}
public void Select5StarHotels() throws InterruptedException{
	
	Thread.sleep(1000);
	elementUtil.doClick(fiveStars);

	elementUtil.waitForElementPresent(landmarks);
	Thread.sleep(3000);
	elementUtil.doClick(landmarks);
	
	elementUtil.waitForElementPresent(cityCenter);
	Thread.sleep(3000);
	elementUtil.doClick(cityCenter);
	
	elementUtil.waitForElementPresent(miles);
	Thread.sleep(2000);
	elementUtil.selectDropDownValueByValue(driver, miles, "10.0");
	Thread.sleep(2000);

}
	public void verifySelectedOption(String star){
		if(star.equals("3")){
		WebElement threeStarBox = driver.findElement(threeStars);
		System.out.println("3 Star Rate Selected :"+threeStarBox.isSelected());
		}
		else if(star.equals("4")){
		WebElement fourStarBox = driver.findElement(fourStars);
		System.out.println("4 Star Rate Selected :"+fourStarBox.isSelected());
		}
		else if(star.equals("5")) {
		WebElement fiveStarBox = driver.findElement(fiveStars);
		System.out.println("5 Star Rate Selected :"+fiveStarBox.isSelected());
	}
	}
	public String getPageTitle(){
		return driver.getTitle();
		
	}
	public void scrollDownToGetListOfHotels() throws InterruptedException {
		 for (int i =0; i<10;i++){
	    	  JavaScriptUtil.scrollDownBy(driver);
	          Thread.sleep(3000);
	      }}
		 public void getHotelsList(String star){
			 if (star.equals("3")) {
				 		List<WebElement> ThreeStarHotelList = driver.findElements(hotelNames);
				 		for(WebElement hotel: ThreeStarHotelList){
				 			System.out.println("3 Star Hotel Names : " +hotel.getText());
		   }}else if (star.equals("4")) {
						List<WebElement> FourStarHotelList = driver.findElements(hotelNames);
						for(WebElement hotel: FourStarHotelList){
							System.out.println("4 Star Hotel Names : " +hotel.getText());
			}}else if (star.equals("5")) {
						List<WebElement> FiveStarHotelList = driver.findElements(hotelNames);
						for(WebElement hotel: FiveStarHotelList){
							System.out.println("5 Star Hotel Names : " +hotel.getText());
					}
				
			}
		 }
		 public void HiltonIsOnTheList(){
			 List<WebElement> ThreeStarHotelList = driver.findElements(hotelNames);
			 for(WebElement element: ThreeStarHotelList){
				 String hotel=element.getText();
				 if (hotel.contains("Hilton")) {
					System.out.println("Hilton Hotel is within 10 miles radius of City Center");
				}else{
					System.out.println("Hilton Hotel is not within 10 miles radius of City Center");
				}break;
			 }
		 }

      
		 

	public void distanceCheck(){
        List<WebElement> distanceList = driver.findElements(distanceToPlace);
		for(WebElement hotel : distanceList) {
		System.out.println("3 Star Hotel Names : " +hotel.getText());
        String makeDouble = hotel.getText().substring(0,3);
        doubleDistance = Double.parseDouble(makeDouble);

        }
        System.out.println(doubleDistance);
        boolean distanceToPlace = false;
        if (doubleDistance<10.00){distanceToPlace=true;}
        Assert.assertTrue(distanceToPlace);
    }

}
