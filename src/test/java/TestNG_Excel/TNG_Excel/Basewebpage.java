package TestNG_Excel.TNG_Excel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basewebpage {

	public static WebDriver driver;
	public String browser = "chrome";

	public Basewebpage() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\lokesh\\Downloads\\ChromeDriver_79\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "Firefox Driver Server Path");
				driver = new FirefoxDriver();
			}
			driver.get("http://automationpractice.com/index.php/");
		}
	}

	public void Maximize() {
			driver.manage().window().maximize();
	}
	
	public void Waittime() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void setText(WebElement element, String name) {
			element.clear();
	}

	public void setText1(WebElement element, String name) {
			element.sendKeys(name);
	}
	
	public void setText2(WebElement element, String name) {
			element.click();
	}
	
	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public String selectFromDropDown(WebElement element, String option) {
		Select obj = new Select(element);
		obj.selectByValue(option);
		return obj.getFirstSelectedOption().getText();
	}

	public String getTitle() {
		String tit= driver.getTitle();
		return tit;
	}	

	public void quitDriver() {
		driver.quit();
	}

	public void closeDriver() {
		driver.close();
	}

	public void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}



}
