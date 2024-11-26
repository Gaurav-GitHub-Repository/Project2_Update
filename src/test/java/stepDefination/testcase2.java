package stepDefination;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.Dashboard2;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase2 {

	WebDriver driver;
	
	@Before(order=1)
	@Given("^ Launch google chrome browser and navigate to url $")
	public void Launch_google_chrome_browser_and_navigate_to_url()
	{
		int browser=1;
		switch(browser)
		{
		case 1:
			DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setPlatform("Windows");
			caps.setBrowserName("Google Chrome");
			caps.setVersion("130.0.6723.117");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--set headless");
			System.setProperty("webdriver.chrome.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
		case 2:	
			DesiredCapabilities caps1 = new DesiredCapabilities();
			//caps1.setPlatform("Windows");
			caps1.setBrowserName("MozillaFirefox");
			//caps1.setVersion("130.0.6723.117");
			FirefoxOptions option1 = new FirefoxOptions();
			option1.addArguments("--set headless");
			System.setProperty("webdriver.gecko.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(option1);
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		case 3:
			DesiredCapabilities caps2 = new DesiredCapabilities();
			//caps2.setPlatform("Windows");
			caps2.setBrowserName("MicrosoftEdge");
			caps2.setVersion("131.0.2903.51");
			System.setProperty("webdriver.edge.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		default:
			System.out.println("Browser is not launched");
		}
	}
	@When("^ Verify homepage $")
	public void Verify_homepage()
	{
		//Method to call Login
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("^ Click on Signup or Login button $")
	public void Click_on_Signup_or_Login_button()
	{
		//Method to call Login
		Login login = new Login(driver);
		login.clickOnSignIn();
	}
	@When("^ Verify Login to your account is visible $")
	public void Verify_Login_to_your_account_is_visible()
	{
		//Method to call Login
		Login login = new Login(driver);
		login.verifyLogin();
	}
	@When("^ Enter correct (.*) and (.*) $")
	public void Enter_correct_email_address_and_password(String emailaddress, String Password)
	{
		//Method to call Login
		Login login = new Login(driver);
		login.enterLoginEmail(emailaddress);
		login.enterLoginPassword(Password);
	}
	@When("^ Click on login button $")
	public void Click_on_login_button() throws InterruptedException
	{
		//Method to call Login
		Login login = new Login(driver);
		login.clickOnLoginButton();
	}
	@When("^ Verify Logged in as username $")
	public void Verify_Logged_in_as_username() throws IOException
	{
		//Method to call Login
		Login login = new Login(driver);
		login .verifyLoggedInName();
	}
	@Then("^ Click_on_delete_account_button $")
	public void Click_on_delete_account_button() throws InterruptedException
	{
		//Method to call Dashboard2
         Dashboard2 dashboard = new Dashboard2(driver);
         dashboard.clickOnDeleteButton();
	}
	@Then("^ Verify account deleted is visible $")
	public void Verify_account_deleted_is_visible() throws IOException
	{
		//Method to call Dashboard2
        Dashboard2 dashboard = new Dashboard2(driver);
        dashboard.verifyAccountDeleted();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
