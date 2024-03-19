package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class NewCarsPage extends BasePage{

	public NewCarsPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(linkText ="Maruti Suzuki")
	public WebElement marutiSuzuki;
	
	@FindBy(linkText ="Tata")
	public WebElement tata;
	
	@FindBy(linkText ="Hyundai")
	public WebElement hyundai;
	
	@FindBy(linkText ="Toyota")
	public WebElement toyota;
	
	@FindBy(linkText ="Mahindra")
	public WebElement mahindra; 
	
	@FindBy(linkText ="BMW")
	public WebElement bmw;
	
	@FindBy(linkText ="Mercedes-Benz")
	public WebElement mercedesbenz;
	
	@FindBy(linkText ="Audi")
	public WebElement audi;
	
	@FindBy(linkText ="Land Rover")
	public WebElement landrover;
	
	@FindBy(linkText ="Kia")
	public WebElement kia;
	
	@FindBy(linkText ="Porsche")
	public WebElement porsche;
	
	@FindBy(linkText ="Skoda")
	public WebElement skoda;
	
	public void marutiCars() {
		marutiSuzuki.click();
	}
	
	public void tataCars() {
		tata.click();
	}
	
	public void hyundaiCars() {
		hyundai.click();
	}
	
	public void toyotaCars() {
		toyota.click();
	}
	
	public void mahindraCars() {
		mahindra.click();
	}
	
	public void bmwCars() {
		bmw.click();
	}
	
	public void mercedesbenzCars() {
		mercedesbenz.click();
	}
	
	public void landroverCars() {
		landrover.click();
	}
	
	public void kiaCars() {
		kia.click();
	}
	
	public void porscheCars() {
		porsche.click();
	}
	
	public void skodaCars() {
		skoda.click();
	}
	
	
}
