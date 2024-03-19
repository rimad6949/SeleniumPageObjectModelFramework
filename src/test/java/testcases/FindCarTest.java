package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;
import utilities.DataUtil;

public class FindCarTest extends BaseTest{

	@Test(dataProviderClass = DataUtil.class, dataProvider="dp")
	public void findCarTest(String brandName, String browserName) throws InterruptedException{
		//Calling the setup method from BaseTest
		setUp(browserName);
		
		if(brandName.equals("Maruti")) 
		{
			HomePage home = new HomePage(driver);
			
			home.findNewCar().marutiCars();
			System.out.println("---------"+ BasePage.car.getCarTitle()+"---------");
			BasePage.car.getCarModelName();	
			BasePage.car.getCarPrice();
			
		} 
		else if(brandName.equals("Kia"))
		{
			HomePage home = new HomePage(driver);
			home.findNewCar().kiaCars();
			System.out.println("---------"+ BasePage.car.getCarTitle()+"---------");
			BasePage.car.getCarModelName();	
			BasePage.car.getCarPrice();
			
		}
		else if(brandName.equals("Toyota"))
		{
			HomePage home = new HomePage(driver);
			home.findNewCar().tataCars();
			System.out.println("---------"+ BasePage.car.getCarTitle()+"---------");
			BasePage.car.getCarModelName();	
			BasePage.car.getCarPrice();
			
		}
		else if(brandName.equals("Hynundai"))
		{
			HomePage home = new HomePage(driver);
			home.findNewCar().hyundaiCars();
			System.out.println("---------"+ BasePage.car.getCarTitle()+"---------");
			BasePage.car.getCarModelName();	
			BasePage.car.getCarPrice();
			
		}
				
	}
}
