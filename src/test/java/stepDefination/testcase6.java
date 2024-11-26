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

public class testcase6 {

	WebDriver driver;

	@Before(order=1)
	@Given("^ launch browser and navigate to Url $")
	public void launch_browser_and_navigate_to_Url()
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
	@When("^ Verify that home page is visible successfully $")
	public void Verify_that_home_page_is_visible_successfully()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("^ click on contact us form $")
	public void click_on_contact_us_form()
	{
		//Method to call dashboard page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.clickOnContactButton();
	}
	@When("^ verify get in touch is visible $")
	public void verify_get_in_touch_is_visible() throws IOException
	{
		//Method to call dashboard page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyGetInTouchText();
	}
	@When("^ enter name, email, subject and message $")
	public void enter_name_email_subject_and_message() throws IOException
	{
		//Method to call dashboard page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyGetInTouchText();
		dashboard2.enterContactFormName("Gaurav");
		dashboard2.enterContactFormEmail("gaurav.pathange@gmail.com");
		dashboard2.enterSubject("Automation Exercise");
		dashboard2.enterMessage("Automation Exercise");
	}
	@When("^ upload file $")
	public void upload_file()
	{
		//Method to call dashboard page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.clickOnChooseFile();
	}
	@When("^ click on submit button $")
	public void click_on_submit_button() throws InterruptedException
	{
		//Method to call dashboard page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.clickOnSubmitButton();
	}
	@When("^ click on ok button $")
	public void click_on_ok_button()
	{
		//Method to call dashboard page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.OkButton();
	}
	@Then("^ verify success message Success Your details have been submitted is visible $")
	public void verify_success_message_Success_Your_details_have_been_submitted_is_visible() throws IOException
	{
		//Method to call dashboard page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyAlertSuccess();
	}
	@Then("^ click on home button and verify that landed to homepage successfully $")
	public void click_on_home_button_and_verify_that_landed_to_homepage_successfully() throws InterruptedException
	{
		//Method to call dashboard page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.clickOnHomeButton();
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
