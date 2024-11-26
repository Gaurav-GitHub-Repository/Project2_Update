package stepDefination;

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

import Pages.Dashboard;
import Pages.Dashboard2;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class testcase1 {

	WebDriver driver;

	@Before(order=1)
	@Given("^ launch google chrome browser and navigate to url $")
	public void launch_google_chrome_browser_and_navigate_to_url()
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
	@When("^ verify that homepage is visible successfully $")
	public void verify_that_homepage_is_visible_successfully()
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.verifyHomePage();	
	}
	@When("^ click on signup or login button $")
	public void click_on_signup_or_login_button()
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.clickOnSignIn();
	}
	@When("^ verify new user signup is visible $")
	public void verify_new_user_signup_is_visible() throws IOException
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.verifySignUp();
	}
	@When("^ enter name and email address $")
	public void enter_name_and_email_address()
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.enterSignInName("Gaurav");
		login.enterSignInEmail("gaurav.pathange@gmail.com");
	}
	@When("^ click_on_signup_button $")
	public void click_on_signup_button()
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.clickOnSignInButton();
	}
	@When("^ verify_that_enter_account_information_is_visible $")
	public void verify_that_enter_account_information_is_visible() throws InterruptedException, IOException
	{
		//Method to call Dashboard Page
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyAccountInformation();
	}
	@When("^ fill details title, name, email, password and date of birth $")
	public void fill_details_title_name_email_password_date_of_birth_and_checkbox()
	{
		//Method to call Dashboard Page
		Dashboard dashboard = new Dashboard(driver);
		dashboard.clickOnRadioButton();
		//dashboard.enterName("Gaurav");
		//dashboard.enterEmail("gaurav.pathange@gmail.com");
		dashboard.enterPassword("Gaurav");
		dashboard.scroll();
		dashboard.clickOnCheckbox();
		dashboard.clickOnSecondCheckbox();
	}
	@When("^ fill details like firstname lastname company address address2 country state city zipcode and mobilenumber $")
	public void fill_details_like_firstname_lastname_company_address_address2_country_state_city_zipcode_and_mobilenumber()
	{
		//Method to call Dashboard Page
		Dashboard dashboard = new Dashboard(driver);
		//dashboard.enterName("Gaurav");
		//dashboard.enterEmail("gaurav.pathange@gmail.com");
		dashboard.enterPassword("Gaurav");
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
	}
	@When("^ click on create account button $")
	public void click_on_create_account_button() throws InterruptedException
	{
		//Method to call Dashboard Page
		Dashboard dashboard = new Dashboard(driver);
		dashboard.clickOnCreateButton();
	}
	@When("^ verify account created is visible $")
	public void verify_account_created_is_visible() throws IOException
	{
		//Method to call Dashboard2 Page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyAccountCreated();
	}
	@When("^ click on continue button $")
	public void click_on_continue_button() throws InterruptedException
	{
		//Method to call Dashboard2 Page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.clickOnContinue();
	}
	@When("^ verify logged in username is visible $")
	public void verify_logged_in_username_is_visible() throws IOException
	{
		//Method to call Dashboard2 Page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyLoggedInName();
	}
	@Then("^ click on delete account button $")
	public void click_on_delete_account_button() throws InterruptedException
	{
		//Method to call Dashboard2 Page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.clickOnDeleteButton();
	}
	@Then("^ verify that account deleted is visible $")
	public void  verify_that_account_deleted_is_visible() throws IOException, InterruptedException
	{
		//Method to call Dashboard2 Page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyAccountDeleted();
		dashboard2.clickOnContinue();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
