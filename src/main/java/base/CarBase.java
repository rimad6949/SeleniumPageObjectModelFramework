package base;

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
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div/h1")
	public WebElement carTitle;
	
	public String getCarTitle() {
		
		return carTitle.getText();
		
	}
	
	public void getCarBrandName() {
		
	}

}
