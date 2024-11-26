package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Pages.Dashboard;
import Pages.Dashboard2;
import Pages.Login;
import Pages.Reusablecomponents;

//@Listeners(utility.class)
public class TestCase1 {

	WebDriver driver;

	@Parameters("browser")
	@Test(priority=1)
	public void setBrowserConfig(String browser)
	{
		if(browser.equalsIgnoreCase("GoogleChrome"))
		{
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("--headless");
			System.setProperty("Webdriver.chrome.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\AutomationExercise\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); 
			
			//DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setBrowserName(CapabilityType.BROWSER_NAME);
			
		}
		else if (browser.equalsIgnoreCase("MozillaFirefox"))
		{
			FirefoxOptions option = new FirefoxOptions();
			//option.addArguments("--headless");
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
		//Method to call login page
		Login login = new Login(driver);
		login.verifyHomePage();
		login.clickOnSignIn();
		login.verifySignUp();
		login.enterSignInName("Gaurav");
		login.enterSignInEmail("gaurav.pathange@gmail.com");
		login.clickOnSignInButton();
		//Method to call Dashboard Page
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAccountInformation();
		dashboard.clickOnRadioButton();
		//dashboard.enterName("Gaurav");
		//dashboard.enterEmail("gaurav.pathange@gmail.com");
		dashboard.enterPassword("Gaurav");
		dashboard.scroll();
		dashboard.clickOnCheckbox();
		dashboard.clickOnSecondCheckbox();
		dashboard.enterFirstName("Pathange");
		dashboard.enterLastName("Gaurav");
		dashboard.enterCompany("XYZ");
		dashboard.enterAddress1("Kompally");
		dashboard.enterAddress2("Hyderabad");
		dashboard.selectCountry();
		dashboard.enterState("Telangana");
		dashboard.enterCity("Hyderabad");
		dashboard.enterZipcode("500032");
		dashboard.enterMobileNumber("8919876100");
		dashboard.clickOnCreateButton();
		//Method to call Dashboard2 Page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyAccountCreated();
		dashboard2.clickOnContinue();
		dashboard2.verifyLoggedInName();
		dashboard2.clickOnDeleteButton();
		dashboard2.verifyAccountDeleted();
		dashboard2.clickOnContinue();
	}
	public void logout()
	{
		driver.close();
	}
}
