package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/header/div/nav/ul/li[1]/div")
	public WebElement newCars;
	
	@FindBy(linkText="Find New Cars")
	public WebElement findNewCars;	
	
	public NewCarsPage findNewCar() throws InterruptedException {
		
		new Actions(driver).moveToElement(newCars).perform();
		findNewCars.click();
		Thread.sleep(2000);	
		return new NewCarsPage(driver);

	}

}
