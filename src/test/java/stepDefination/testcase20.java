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
import org.testng.Assert;

import Pages.Dashboard3;
import Pages.Dashboard4;
import Pages.Dashboard5;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase20 {


	WebDriver driver;

	@Before(order=1)
	@Given("^ Launch browser And navigate to URL $")
	public void Launch_browser_And_navigate_to_URL()
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

		@When("click On Products Button")
		public void click_On_Products_Button() throws InterruptedException 
		{
			//Method to call Dashboard4
			Dashboard4 dashboard4 = new Dashboard4(driver);
			dashboard4.clickOnProducts();
		}

		@When("user is navigated to all products page successfully")
		public void userIsNavigatedToAllProductsPageSuccessfully() 
		{
			//Method to call Dashboard3 page
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.verifyProductPage();
		}

		@When("enter product name in search input and click on search button")
		public void enterProductNameInSearchInputAndClickOnSearchButton() throws InterruptedException 
		{
			//Method to call Dashboard3 page
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.enterSearchProduct("Polo");
			dashboard3.clickOnSearchButton();
		}

		@When("verify searched products is visible")
		public void verifySearchedProductsIsVisible() throws IOException 
		{
			//Method to call Dashboard3 page
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.verifySearched_Product();
		}

		@When("verify all products related to search are visible")
		public void verifyAllProductsRelatedToSearchAreVisible() throws IOException 
		{
			//Method to call Dashboard3 page
			Dashboard3 dashboard3 = new Dashboard3(driver);
			dashboard3.verifySearched_Product();
		}

		@When("add products to cart")
		public void addProductsToCart() throws InterruptedException 
		{
				//Method to call Dashboard5
				Dashboard5 dashboard5 = new Dashboard5(driver);
				dashboard5.addProducts();
		}
		@When("click on cart button and verify that products are visible in cart")
		public void clickOnCartButtonAndVerifyThatProductsAreVisibleInCart() throws IOException 
		{
			//Method to call Dashboard5
			Dashboard5 dashboard5 = new Dashboard5(driver);
			dashboard5.cartButton();
			dashboard5.verifyProductsAddedInCart();
		}
		@When("click on signup or login button and submit login details")
		public void clickOnSignupOrLoginButtonAndSubmitLoginDetails() throws InterruptedException 
		{
			//Method to call Login page
			Login login = new Login(driver);
			login.clickOnSignIn();
			login.enterLoginEmail("inevitablegaurav@gmail.com");
			login.enterLoginPassword("Gaurav");
			login.clickOnLoginButton();
		}

		@Then("go to cart page")
		public void goToCartPage() 
		{
			//Method to call Dashboard5 page
			Dashboard5 dashboard5 = new Dashboard5(driver);
			dashboard5.cartButton();
		}

		@Then("verify products are visible in cart after login as well")
		public void verifyProductsAreVisibleInCartAfterLoginAsWell() throws IOException 
		{
			//Method to call Dashboard5 page
			Dashboard5 dashboard5 = new Dashboard5(driver);
			dashboard5.verifyProductsAddedInCart();
		}
	
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
