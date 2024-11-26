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

import Pages.Dashboard2;
import Pages.Login;

//@Listeners(utility.class)
public class TestCase6 {

	WebDriver driver;
	
	@Parameters("browser")
	@Test(priority=1)
	public void setBrowserConfig(String browser)
	{
		if(browser.equalsIgnoreCase("GoogleChrome"))
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
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
		//Method to call dashboard page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.clickOnContactButton();
		dashboard2.verifyGetInTouchText();
		dashboard2.enterContactFormName("Gaurav");
		dashboard2.enterContactFormEmail("gaurav.pathange@gmail.com");
		dashboard2.enterSubject("Automation Exercise");
		dashboard2.enterMessage("Automation Exercise");
		dashboard2.clickOnChooseFile();
		dashboard2.clickOnSubmitButton();
		dashboard2.OkButton();
		dashboard2.verifyAlertSuccess();
		dashboard2.clickOnHomeButton();
		login.verifyHomePage();
	}
	@Test(priority=3)
	public void logout()
	{
		driver.quit();
	}  
}
