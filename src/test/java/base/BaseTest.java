package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelReader;

public class BaseTest {

	public WebDriver driver;
	public Properties OR = new Properties();
	public Properties Config = new Properties();
	public Logger log = Logger.getLogger(BaseTest.class.getName());
	public FileInputStream fis;
	public WebDriverWait wait;
	public ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	ChromeOptions opts = new ChromeOptions();
	public String srcfileName;

	public void setUp() {

		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/properties/OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "src/test/resources/properties/Config.properties");
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
				opts.addArguments("--incognito");
				opts.addArguments("--disable-notifications");
				driver = new ChromeDriver(opts);
				log.info("Chrome Browser Launched");
			} else if (Config.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
				log.info("Firefox Browser Launched");
			}

			driver.get(Config.getProperty("testSiteURL"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}

	}

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
