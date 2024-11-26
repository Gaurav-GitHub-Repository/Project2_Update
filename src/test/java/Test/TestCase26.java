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
import Pages.Dashboard5;
import Pages.Login;

//@Listeners(utility.class)
public class TestCase26 {

	WebDriver driver;
	
	@Parameters("browser")
	@Test(priority=1)
	public void setBrowserConfig(String browser)
	{
		if(browser.equalsIgnoreCase("GoogleChrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("--set headless");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("MozillaFirefox"))
		{
			System.setProperty("Webdriver.gecko.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\geckodriver.exe");
			FirefoxOptions option = new FirefoxOptions();
			//option.addArguments("--set headless");
			driver = new FirefoxDriver(option);
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("MicrosoftEdge"))
		{
			System.setProperty("Webdriver.edge.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\msedgedriver.exe");
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
	public void regression() throws IOException
	{
		//Method to call Login
		Login login = new Login(driver);
		login.verifyHomePage();
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.scrollToFooter();
		dashboard3.verifySubscription();
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		//dashboard5.scrollByArrowButton();
		dashboard5.scrollUp();
		dashboard5.verifyAutomationHeaderText();
	}
	@Test(priority=3)
	public void logout()
	{
		driver.close();
	}
}
