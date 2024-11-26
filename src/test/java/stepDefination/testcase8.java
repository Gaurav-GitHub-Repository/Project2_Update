package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.Dashboard3;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase8 {

	WebDriver driver;

	@Before(order=1)
	@Given("^ launch browser and navigate to application $")
	public void launch_browser_and_navigate_to_application()
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
	@When("^ Verify homepage is visible successfully $")
	public void Verify_homepage_is_visible_successfully()
	{
		//Method to call Login Page
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("^ click On Products button $")
	public void  click_On_Products_button()
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.clickOnProducts();
	}
	@When("^ user is navigated to All Products page successfully $")
	public void user_is_navigated_to_All_Products_page_successfully()
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifyProductPage();
	}
	@When("^ The products list is visible $")
	public void The_products_list_is_visible()
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.brandproducts();
		dashboard3.element();
	}
	@When("^ click on view product of first product	 $")
	public void click_on_view_product_of_first_product()
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.clickOnViewProduct();
	}
	@Then("^ user is landed to product detail page $")
	public void user_is_landed_to_product_detail_page()
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.verifyProductDetails();
	}
	@Then("^ verify that detail is visible  $")
	public void verify_that_detail_is_visible()
	{
		//Method to call Dashboard3
		Dashboard3 dashboard3 = new Dashboard3(driver);
		dashboard3.productinfo();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
