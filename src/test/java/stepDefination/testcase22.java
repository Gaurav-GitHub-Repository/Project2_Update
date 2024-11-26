package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.Dashboard4;
import Pages.Dashboard5;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase22 {

	WebDriver driver;

	@Before(order=1)
	@Given("^ Launch Browser And navigate to url $")
	public void Launch_Browser_And_navigate_to_url()
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
	@When("^ scroll to bottom of page $")
	public void scroll_to_bottom_of_page() throws InterruptedException 
	{
		//Method to call Dashboard4
		Dashboard4 dashboard4 = new Dashboard4(driver);
		dashboard4.scrollToFooter();
	}
	@When("^ verify recommended items are visible $")
	public void verify_recommended_items_are_visible() throws InterruptedException 
	{
		//Method to call Dashboard4
		Dashboard4 dashboard4 = new Dashboard4(driver);
		dashboard4.verifyRecommendedItems();
	}
	@When("^ click on add to cart button in recommended product $")
	public void  click_on_add_to_cart_button_in_recommended_product() throws InterruptedException 
	{
		//Method to call Dashboard4
		Dashboard4 dashboard4 = new Dashboard4(driver);
		dashboard4.addRecommendedProducts();
	}
	@When("^ Click on View cart button $")
	public void  Click_on_View_cart_button() throws InterruptedException 
	{
		//Method to call Dashboard4
		Dashboard4 dashboard4 = new Dashboard4(driver);
		dashboard4.clickOnModalViewCart();
	}
	@Then("^ verify product is displayed in cart page $")
	public void verify_product_is_displayed_in_cart_page() throws InterruptedException 
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyCheckout();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
