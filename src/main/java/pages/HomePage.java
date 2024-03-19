package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	//Code to get all the trending Car Model Name and Price from the Homepage
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/section/div/div/div[2]/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div[2]/a/div")
	public List<WebElement> trendingCars;

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/section/div/div/div[2]/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[1]")
	public List<WebElement> trendingCarPrices;

	public void gettrendingCars() {

		for (int i = 0; i < trendingCars.size(); i++) {

			String trendingCarlist = (String) trendingCars.get(i).getText();
			System.out.println(trendingCarlist);
		}

	}

	public void gettrendingCarPrice() {

		for (int i = 0; i < trendingCarPrices.size(); i++) {

			String trendingCarPricelist = (String) trendingCarPrices.get(i).getText();
			System.out.println(trendingCarPricelist);
		}

	}

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/header/div/nav/ul/li[1]/div")
	public WebElement newCars;

	@FindBy(linkText = "Find New Cars")
	public WebElement findNewCars;

	public NewCarsPage findNewCar() throws InterruptedException {

		new Actions(driver).moveToElement(newCars).perform();
		findNewCars.click();
		Thread.sleep(2000);
		return new NewCarsPage(driver);

	}

}
