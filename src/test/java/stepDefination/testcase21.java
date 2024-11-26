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
import Pages.Dashboard4;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase21 {

	WebDriver driver;

	@Before(order=1)
	@Given("^ launch browser And navigate to url $")
	public void launch_browser_And_navigate_to_url()
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
	    @When("click on Products button")
	    public void click_on_Products_button() throws InterruptedException 
	    {
			//Method to call Dashboard4
			Dashboard4 dashboard4 = new Dashboard4(driver);
			dashboard4.clickOnProducts();
	    }
	    @When("verify user is navigated to all products page successfully")
	    public void verifyUserIsNavigatedToAllProductsPageSuccessfully() 
	    {
			//Method to call Dashboard3
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.verifyProductPage();
	    }
	    @When("click on view product button")
	    public void clickOnViewProductButton() 
	    {
			//Method to call Dashboard3
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.clickOnViewProduct();
	    }
	    @When("verify write your review is visible")
	    public void verifyWriteYourReviewIsVisible() throws InterruptedException 
	    {
			//Method to call Dashboard3
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.verifyReviewVisible();
	    }
	    @When("enter name, email and review")
	    public void enterNameEmailAndReview() 
	    {
			//Method to call Dashboard3
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.enterReviewName("Gaurav");
			dashboard3.enterReviewEmail("inevitablegaurav@gmail.com");
			dashboard3.enterReview("Review");
	    }
	    @When("click on submit button")
	    public void click_on_submit_button() 
	    {
			//Method to call Dashboard3
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.clickOnReviewSubmit();
	    }
	    @Then("verify success message")
	    public void verify_success_message() 
	    {
			//Method to call Dashboard3
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.verifyReviewMessage();
	    } 
		@After(order=1)
		public void logout()
		{
			driver.close();
		}
	}

