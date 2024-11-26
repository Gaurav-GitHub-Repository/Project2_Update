package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Dashboard3;
import Pages.Dashboard4;
import Pages.Login;

//@Listeners(utility.class)
public class TestCase12 {
 
	WebDriver driver;
	
	@Parameters("browser")
	@Test(priority=1)
	public void setBrowserConfig(String browser)
	{
		if(browser.equalsIgnoreCase("GoogleChrome"))
		{
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("-- set headless");
			System.setProperty("WebDriver.Chrome.Driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\AutomationExercise\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("MozillaFirefox"))
		{
			 FirefoxOptions option = new FirefoxOptions();
			 option.addArguments("--headless--");
			 System.setProperty("Webdriver.gecko.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\AutomationExercise\\drivers\\geckodriver.exe");
			 driver = new FirefoxDriver(option);
			 driver.manage().window().maximize();
			 driver.get("https://automationexercise.com/");
			 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("MicrosoftEdge"))
		{
			 EdgeDriver driver = new EdgeDriver();
			 System.setProperty("Webdriver.edge.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\AutomationExercise\\drivers\\geckodriver.exe");
			 driver = new EdgeDriver();
			 driver.manage().window().maximize();
			 driver.get("https://automationexercise.com/");
			 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);			 
		}
		else 
		{
			System.out.println("Browser is not launched");
		}
	}
	@Test(priority=2)
	public void regression() throws InterruptedException, IOException
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifyHomePage();
		//Method to call Dashboard4
		Dashboard4 dashboard4 = new Dashboard4(driver);
		dashboard4.clickOnProducts();
		//dashboard4.pageload();
		dashboard4.clickOnAddToCartProduct();
		dashboard4.clickOnShoppingButton();
		dashboard4.clickOnAddToCartProduct2();
		dashboard4.clickOnViewCart();
		dashboard4.verifyProductHeader();
		dashboard4.verifyCheckoutProductDetails();
	}
	@Test(priority=3)
	public void logout()
	{
		driver.quit();
	}  
	 
}
