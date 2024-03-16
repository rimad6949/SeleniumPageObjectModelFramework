package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class FindCarTest extends BaseTest{

	@Test
	public void findCarTest() throws InterruptedException {
		
		HomePage home = new HomePage(driver);
		home.findNewCar();
				
	}
}
