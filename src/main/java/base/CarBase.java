package base;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
	
	//Adding the array list so that we can print the output in a file
	public ArrayList<String> list = new ArrayList<String>();

	public void getCarModelName() {

		for (int i = 0; i < carModel.size(); i++) {

			String modelNames = carModel.get(i).getText();
			//At each index the data will be added to list
			list.add(modelNames);
			System.out.println(modelNames);
		}

	}

	public void getCarPrice() {

		for (int i = 0; i < carPrice.size(); i++) {

			String modelPrice = carPrice.get(i).getText();
			list.add(modelPrice);
			System.out.println(modelPrice);
		}

	}
	
	public void addCarModelInFile(String fileName) {
		
		String info = fileName + " car brand name and price\n";
		File file = new File(fileName);
		
		try {
			FileWriter fw = new FileWriter(file, true);
			
			fw.write(info);
			String lineSeparator = System.getProperty("line.separator");
			
			for(int i = 0;i < list.size(); i++) {
				fw.write(list.get(i));
				fw.write(lineSeparator);
			}
			
			fw.flush();
			fw.close();
			
			FileUtils.copyFile(file, new File("/Users/rimadas/eclipse-workspace/SeleniumPageObjectModelFramework/target/CarModelAndPrice/" + fileName + ".txt"));
			FileUtils.deleteQuietly(file);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
