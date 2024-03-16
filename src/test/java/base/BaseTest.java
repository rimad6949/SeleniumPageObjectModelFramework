package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilities.ExcelReader;

public class BaseTest {

	public WebDriver driver;
	public Properties Config = new Properties();
	public Logger log = LogManager.getLogger(BaseTest.class.getName());
	public FileInputStream fis;
	public WebDriverWait wait;
	public ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	static WebElement dropdown;
	public String srcfileName;

	@BeforeTest
	public void setUp() {

			try {
				fis = new FileInputStream("/Users/rimadas/eclipse-workspace/SeleniumPageObjectModelFramework/src/test/resources/properties/Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (Config.getProperty("browser").equals("chrome")) {
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);	
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");				
				options.addArguments("--incognito");

				
				driver = new ChromeDriver(options);
				log.info("Chrome Browser Launched");
				
			} else if (Config.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
				log.info("Firefox Browser Launched");
			}

			driver.get(Config.getProperty("testSiteURL"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			System.out.println("Clicking on New car");
		}


	@AfterTest
	public void tearDown() {

		driver.quit();
		log.info("Closing the browser");

	}

	public class ScreenshotUtil extends BaseTest {


		public void captureScreenshot() {

			Date d = new Date();

			srcfileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(screenshot, new File(
						"/Users/rimadas/eclipse-workspace/SeleniumDataDrivenFramework/target/reports/" + srcfileName));
				FileUtils.copyFile(screenshot, new File(
						"/Users/rimadas/eclipse-workspace/SeleniumDataDrivenFramework/target/surefire-reports/html/"
								+ srcfileName));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void captureElementScreenshot(WebElement element) {

			Date d = new Date();

			String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			File screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyDirectory(screenshot,
						new File(System.getProperty("user.dir") + "/screenshot/" + fileName));
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}

}
