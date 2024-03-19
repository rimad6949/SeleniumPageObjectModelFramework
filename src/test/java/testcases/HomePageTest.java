package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utilities.DataUtil;

public class HomePageTest extends BaseTest{
	
	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	public void homePageTest(String browserName) {
		
		setUp(browserName);
		
		HomePage home = new HomePage(driver);
		home.gettrendingCars();
		home.gettrendingCarPrice();
		
		//Need to write the code to click on the arrow to scroll to next 
	}

}
