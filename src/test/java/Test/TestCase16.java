package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Dashboard2;
import Pages.Dashboard5;
import Pages.Dashboard6;
import Pages.Login;

//@Listeners(utility.class)
public class TestCase16 {

	WebDriver driver;
	
	@Parameters("browser")
	@Test(priority=1)
	public void setBrowserConfig(String browser)
	{
		if(browser.equalsIgnoreCase("GoogleChrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("--set headless");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("MozillaFirefox"))
		{
			System.setProperty("Webdriver.gecko.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\geckodriver.exe");
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--set headless");
			driver = new FirefoxDriver(option);
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("MicrosoftEdge"))
		{
			System.setProperty("Webdriver.edge.driver", "C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://automationexercise.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		else
		{
			System.out.println("Browser is not launched");
		}
	}
	@Test(priority=2)
	public void SignUp() throws InterruptedException, IOException
	{
		Login login = new Login(driver);
		login.verifyHomePage();
		login.clickOnSignIn();
		login.enterLoginEmail("inevitablegaurav@gmail.com");
		login.enterLoginPassword("Gaurav");
		login.clickOnLoginButton();
		login.verifyLoggedInName();
	}
	@Test(priority=3)
	public void functional() throws InterruptedException, IOException
	{
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.scroll();
		//dashboard5.addProductsToCart();
		dashboard5.addProducts();
		dashboard5.scrollByArrowButton();
		dashboard5.clickOnCartButton();
		dashboard5.verifyCheckout();
		dashboard5.clickOnCheckoutButton();
		//dashboard5.verifyAddress();
		dashboard5.verifyAddress1();
		dashboard5.verifyReviewHeader();
		dashboard5.scrollToDescription();
		dashboard5.enterDescription("Description");
		dashboard5.clickOnPlaceOrder();
	} 
	@Test(priority=4)
	public void functional2() throws InterruptedException, IOException
	{
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.enterPaymentCardName("Pathange Gaurav");
		dashboard6.enterPaymentCardNumber("123456789123");
		dashboard6.enterPaymentCVV("123");
		dashboard6.enterPaymentExpiryMonth("12");
		dashboard6.enterPaymentExpiryYear("2030");
		dashboard6.clickOnPaymentButton();
		dashboard6.verifyPlacedOrder();
		dashboard6.clickOnDeleteButton();
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyAccountDeleted();
		dashboard2.clickOnContinue();
	}
	@Test(priority=5)
	public void logout()
	{
		driver.quit();
	}

}
