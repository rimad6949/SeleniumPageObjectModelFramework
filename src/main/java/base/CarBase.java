package base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarBase {

	WebDriver driver;

	public CarBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Code to get all the trending Car Model Name and Price from the Homepage
	
/*	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div[2]/section/div/div/div[2]/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div[2]/a/div")
	public List<WebElement> trendingCars;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div[2]/section/div/div/div[2]/div[1]/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[1]")
	public List<WebElement> trendingCarPrice;
	
	public void gettrendingCars() {
		
		for(int i = 0; i<trendingCars.size();i++) {
			
			String trendingCarlist = (String)trendingCars.get(i).getText();
			System.out.println(trendingCarlist);
		}
		
	}
	
	public void gettrendingCarPrice() {
		
		for(int i = 0; i<trendingCarPrice.size();i++) {
			
			String trendingCarPricelist = (String)trendingCarPrice.get(i).getText();
			System.out.println(trendingCarPricelist);
		}
		
	}
*/	
	

	// Code to get the Title of Cars from New Cars Page
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[2]/div/h1")
	public WebElement carTitle;

	public String getCarTitle() {

		return carTitle.getText();

	}
	
	

	// Code to get Model name and Price of a particular Car Brand

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/ul/li/div/div/div/a/h3")
	// As there are multiple models, hence list
	public List<WebElement> carModel;

	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/ul/li/div/div/div/div[3]/div/span/span[1]")
	public List<WebElement> carPrice;

	public void getCarModelName() {

		for (int i = 0; i < carModel.size(); i++) {

			String modelNames = carModel.get(i).getText();
			System.out.println(modelNames);
		}

	}

	public void getCarPrice() {

		for (int i = 0; i < carPrice.size(); i++) {

			String modelPrice = carPrice.get(i).getText();
			System.out.println(modelPrice);
		}

	}

}
