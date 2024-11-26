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

import Pages.Dashboard;
import Pages.Dashboard2;
import Pages.Dashboard5;
import Pages.Dashboard6;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase24 {


	WebDriver driver;

	@Before(order=1)
	@Given("^ Launch browser and navigate to Url $")
	public void Launch_browser_and_navigate_to_Url()
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
	@When("verify homepage is visible successfully")
	public void verifyHomepageIsVisibleSuccessfully() 
	{
		//Method to call Login
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("Add Products To Cart")
	public void Add_Products_To_Cart() throws InterruptedException 
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.scroll();
		dashboard5.addProducts();
	}
	@When("click on cart button")
	public void clickOnCartButton() 
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.cartButton();
	}
	@When("verify cart page is displayed")
	public void verifyCartPageIsDisplayed() 
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyCheckout();
	}
	@When("click on proceed to checkout button")
	public void clickOnProceedToCheckoutButton() throws InterruptedException 
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.clickOnCheckoutButton();
	}
	@When("click on register or login button")
	public void clickOnRegisterOrLoginButton() 
	{
		//Method to call Login
		Login login = new Login(driver);
		login.clickOnSignIn();
	}
	@When("fill details in signup and create account")
	public void fillDetailsInSignupAndCreateAccount() throws InterruptedException 
	{
		//Method to call Login
		Login login = new Login(driver);
		login.clickOnSignIn();
		login.enterSignInName("Pathange");
		login.enterSignInEmail("abc@gmail.com");
		login.clickOnSignInButton();
		//Method to call Dashboard
		Dashboard dashboard = new Dashboard(driver);
		dashboard.clickOnRadioButton();
		dashboard.enterPassword("Gaurav");
		dashboard.scroll();
		dashboard.clickOnCheckbox();
		dashboard.clickOnSecondCheckbox();
		dashboard.enterFirstName("Pathange");
		dashboard.enterLastName("Gaurav");
		dashboard.enterCompany("Linkedin");
		dashboard.enterAddress1("Kompally");
		dashboard.enterAddress2("Hyderabad");
		dashboard.selectCountry();
		dashboard.enterState("Telangana");
		dashboard.enterCity("Hyderabad");
		dashboard.enterZipcode("500032");
		dashboard.enterMobileNumber("8919876100");
		dashboard.clickOnCreateButton();
	}
	@When("verify account is created and click on continue button")
	public void verifyAccountIsCreatedAndClickOnContinueButton() throws IOException, InterruptedException 
	{
		//Method to call Dashboard2
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyAccountCreated();
		dashboard2.clickOnContinue();
		dashboard2.pageload();
	}
	@When("verify logged in as username at top")
	public void verifyLoggedInAsUsernameAtTop() throws IOException, InterruptedException 
	{
		//Method to call Dashboard2
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyLoggedInName();
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.cartButton();
		dashboard5.clickOnCheckoutButton();
	}
	@When("verify address details and review your order")
	public void verifyAddressDetailsAndReviewYourOrder() throws IOException 
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyAddress1();
		dashboard5.verifyReviewHeader();
		dashboard5.scrollToDescription();
	}
	@When("enter description in comment text area and click on place order")
	public void enterDescriptionInCommentTextAreaAndClickOnPlaceOrder() 
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.enterDescription("Description");
		dashboard5.clickOnPlaceOrder();
	}
	@When("enter payment details NameonCard, CardNumber, CVC and ExpirationDate")
	public void enterPaymentDetails() 
	{
		//Method to call Dashboard6
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.enterPaymentCardName("P Gaurav");
		dashboard6.enterPaymentCardNumber("123456789123");
		dashboard6.enterPaymentCVV("123");
		dashboard6.enterPaymentExpiryMonth("12");
		dashboard6.enterPaymentExpiryYear("2030");
	}
	@When("click on pay and confirm order button")
	public void clickOnPayAndConfirmOrderButton() throws InterruptedException 
	{
		//Method to call Dashboard6
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.clickOnPaymentButton();
	}
	@When("verify Success Message")
	public void verifySuccessMessage() 
	{
		//Method to call Dashboard6
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.verifyPlacedOrder();
	}
	@When("click on delete account button")
	public void clickOnDeleteAccountButton() 
	{
		//Method to call Dashboard6
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.clickOnDeleteButton();
	}
	@Then("verify account is deleted and click on continue button")
	public void verifyAccountIsDeletedAndClickOnContinueButton() throws InterruptedException 
	{
		//Method to call Dashboard2
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.clickOnContinue();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();
	}
}
