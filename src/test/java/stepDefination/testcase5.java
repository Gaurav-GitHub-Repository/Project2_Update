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
import io.cucumber.java.en.When;

public class testcase5 {

	WebDriver driver;

	@Before(order=1)
	@Given("^ launch browser and navigate To URL $")
	public void launch_browser_and_navigate_To_URL()
	{
		int browser=1;
		switch(browser)
		{
		case 1:
			DesiredCapabilities cap1 = new DesiredCapabilities();
			//cap1.setPlatform("Windows");
			cap1.setBrowserName("Google Chrome");
			cap1.setVersion("130.0.6723.117");
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("--set headless");
			System.setProperty("webdriver.chrome.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		case 2:
			DesiredCapabilities cap2 = new DesiredCapabilities();
			//cap2.setPlatform("Windows");
			cap2.setBrowserName("Mozilla Firefox");
			//cap2.setVersion("130.0.6723.117");
			FirefoxOptions option1 = new FirefoxOptions();
			//option1.addArguments("--set headless");
			System.setProperty("webdriver.gecko.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(option1);
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		case 3:
			DesiredCapabilities cap3 = new DesiredCapabilities();
			//cap3.setPlatform("Windows");
			cap3.setBrowserName("Microsoft Edge");
			//cap3.setVersion("130.0.6723.117");
			System.setProperty("webdriver.gecko.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\geckodriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		default:
			System.out.println("Browser is not launched");
		}
	}
	@When("^ verify that home page is visible successfully $")
	public void verify_that_home_page_is_visible_successfully()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("^ click on signuporlogin button $")
	public void click_on_signuporlogin_button()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.clickOnSignIn();
	}
	@When("^ verify newusersignup is visible $")
	public void verify_newusersignup_is_visible() throws IOException
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifySignUp();
	}
	@When("^ enter name and already regsitered email address $")
	public void enter_name_and_already_regsitered_email_address()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.enterSignInName("Gaurav");
		login.enterSignInEmail("gaurav@gmail.com");
	}
	@When("^ click on signup button $")
	public void click_on_signup_button()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.clickOnSignInButton();
	}
	@When("^ verify error email address already exist is visible  $")
	public void verify_error_email_address_already_exist_is_visible() throws IOException
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifySignInError();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
