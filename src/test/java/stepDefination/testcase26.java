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

import Pages.Dashboard3;
import Pages.Dashboard5;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase26 {

	WebDriver driver;

	@Before(order=1)
	@Given("^ Launch browser And Navigate to Url $")
	public void Launch_browser_And_Navigate_to_Url()
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
	@When("Verify Homepage Is Visible Successfully")
	public void Verify_Homepage_Is_Visible_Successfully() 
	{
		//Method to call Login
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("scroll Down Page To Bottom")
	public void scroll_Down_Page_To_Bottom() 
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.scrollToFooter();
	}
	@When("verify Subscription Is Visible")
	public void verify_Subscription_Is_Visible() 
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifySubscription();
	}
	@When("click On Arrow Button At Bottom Right Side To Move Upward")
	public void click_On_Arrow_Button_At_Bottom_Right_Side_To_Move_Upward() throws IOException 
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.scrollUp();
	}
	@Then("verify Page Is Scrolled Up To Mentioned Text On Screen")
	public void verify_Page_Is_Scrolled_Up_To_Mentioned_Text_On_Screen() throws IOException 
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyAutomationHeaderText();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
