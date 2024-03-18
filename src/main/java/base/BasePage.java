package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public WebDriver driver;
	
	//We are encapsulating the object here as all the common features like getting title, getting price we are adding under CarBase
	public static CarBase car;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		car = new CarBase(driver);
		PageFactory.initElements(driver,this);
	}

}
