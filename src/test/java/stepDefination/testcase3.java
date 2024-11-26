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

import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase3 {

	WebDriver driver;
	
	@Before(order=1)
	@Given("^ launch google chrome browser and navigate to URL $")
	public void launch_google_chrome_browser_and_navigate_to_URL()
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
	@When("^ verify homepage is Visible Successfully $")
	public void verify_homepage_is_Visible_Successfully()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifyHomePage();	
	}
	@When("^ Click on Signup or Login Button $")
	public void Click_on_Signup_or_Login_Button()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.clickOnSignIn();
	}
	@When("^ verify login to your account is visible $")
	public void verify_login_to_your_account_is_visible()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifyLogin();
	}
	@When("^ enter incorrect (.*) and (.*) $")
	public void enter_incorrect_emailaddress_and_password(String value_email, String value_password)
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.enterLoginEmail(value_email);
		login.enterLoginPassword(value_password);
	}
	@When("^ click on login button $")
	public void click_on_login_button() throws InterruptedException
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.clickOnLoginButton();
	}
	@Then("^ verify error your email or password is incorrect is visible $")
	public void verify_error_your_email_or_password_is_incorrect_is_visible() throws IOException
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifyLoginError();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
