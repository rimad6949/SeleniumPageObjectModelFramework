package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//*[@id=\"root\"]/div[1]/header/div/nav/ul/li[1]/div")
	public WebElement newCars;
	
	@FindBy(linkText="Find New Cars")
	public WebElement findNewCars;	
	
	public void findNewCar() throws InterruptedException {
		
		new Actions(driver).moveToElement(newCars).perform();
		findNewCars.click();
		Thread.sleep(2000);	

	}

}
