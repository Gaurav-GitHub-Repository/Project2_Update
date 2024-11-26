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

import Pages.Dashboard5;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase17 {

	WebDriver driver;  

	@Before(order=1)
	@Given("^ launch browser and navigate to url $")
	public void launch_browser_and_navigate_to_url()
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
	@When("^ verify Homepage is visible successfully $")
	public void verify_Homepage_is_visible_successfully()
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("^ enter credentials and click on login button $")
	public void enter_credentials_and_click_on_login_button() throws InterruptedException
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.verifyHomePage();
		login.clickOnSignIn();
		login.enterLoginEmail("inevitablegaurav@gmail.com");
		login.enterLoginPassword("Gaurav");
		login.clickOnLoginButton();
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.scroll();
	}
	@When("^ add products to Cart $")
	public void add_products_to_Cart() throws InterruptedException
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.addProducts();
		dashboard5.scrollByArrowButton();
	}
	@When("^ click On Cart Button $")
	public void click_On_Cart_Button()
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.clickOnCartButton();
		dashboard5.pageload();
	}
	@When("^ Verify Cart page is Displayed $")
	public void Verify_Cart_page_is_Displayed()
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyCheckout();
	}
	@When("^ click X button corresponding to particular product $")
	public void click_X_button_corresponding_to_particular_product()
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.clickOnDeleteButton();
	}
	@Then("^ verify product is removed from cart $")
	public void verify_product_is_removed_from_cart() throws IOException
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyRemovedProduct();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
