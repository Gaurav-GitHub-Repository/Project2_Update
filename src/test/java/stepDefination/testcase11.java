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
import org.testng.annotations.Test;

import Pages.Dashboard3;
import Pages.Dashboard4;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class testcase11 {

	WebDriver driver;

	@Before(order=1)
	@Given("^ launch google_chrome_browser and navigate to url $")
	public void launch_google_chrome_browser_and_navigate_to_url()
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
	@When("^ Verify homepage is visible Successfully $")
	public void Verify_homepage_is_visible_Successfully()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("^ click on cart button $")
	public void click_on_cart_button() throws InterruptedException
	{
		//Method to call Dashboard4
		Dashboard4 dashboard4 = new Dashboard4(driver);
		dashboard4.clickOnCart();
	}
	@When("^ verify scroll down to footer $")
	public void verify_scroll_down_to_footer()
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.scrollToFooter();
	}
	@When("^ Verify text subscription $")
	public void Verify_text_subscription()
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifySubscription();
	}
	@When("^ enter emailaddress in input and click on arrow button $")
	public void enter_emailaddress_in_input_and_click_on_arrow_button() throws InterruptedException
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.enterSubscriptionEmail("gaurav.pathange@gmail.com");
		dashboard3.clickOnSubscriptionButton();
	}
	@When("^ verify success message	 $")
	public void verify_success_message() throws IOException
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifySubscriptionMessage();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}  
}
