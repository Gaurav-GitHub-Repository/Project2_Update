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
import org.testng.annotations.Test;

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

public class testcase15 {

	WebDriver driver;  

	@Before(order=1)
	@Given("^ Launch google_chrome_browser and Navigate_to_url $")
	public void Launch_google_chrome_browser_and_Navigate_to_url()
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
	@When("^ Verify homepage is Visible Successfully $")
	public void Verify_homepage_is_Visible_Successfully()
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("^ Click on signup or login Button $")
	public void Click_on_signup_or_login_Button()
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.clickOnSignIn();
	}
	@When("^ fill all details in signup and create account $")
	public void fill_all_details_in_signup_and_create_account() throws InterruptedException
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.enterSignInName("Pathange Gaurav");
		login.enterSignInEmail("abc@gmail.com");
		login.clickOnSignInButton();
		Dashboard dashboard = new Dashboard(driver);
		dashboard.clickOnRadioButton();
		dashboard.enterPassword("Gaurav");
		dashboard.scroll();
		dashboard.clickOnCheckbox();
		dashboard.clickOnSecondCheckbox();
		dashboard.enterFirstName("Pathange");
		dashboard.enterLastName("Gaurav");
		dashboard.enterCompany("XYZ");
		dashboard.enterAddress1("Kompally");
		dashboard.enterAddress2("Hyderabad");
		dashboard.enterState("Telangana");
		dashboard.enterCity("Hyderabad");
		dashboard.enterZipcode("500032");
		dashboard.enterMobileNumber("8919876100");
		dashboard.clickOnCreateButton();
	}
	@When("^ Verify Account created and Click on Continue button $")
	public void Verify_Account_created_and_Click_on_Continue_button() throws IOException, InterruptedException
	{
		//Method to call Dashboard2 page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyAccountCreated();
		dashboard2.clickOnContinue();
		dashboard2.pageload();
	}
	@When("^ verify logged in as username at top $")
	public void verify_logged_in_as_username_at_top() throws IOException
	{
		//Method to call Dashboard2 page
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyLoggedInName();
	}
	@When("^ Add products to Cart $")
	public void Add_products_to_Cart() throws InterruptedException
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.scroll();
		//dashboard5.addProductsToCart();
		dashboard5.addProducts();
		dashboard5.scrollByArrowButton();
	}
	@When("^ Click on Cart button $")
	public void Click_on_Cart_button()
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.clickOnCartButton();
	}
	@When("^ Verify cart page is Displayed $")
	public void Verify_cart_page_is_Displayed() throws InterruptedException
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyCheckout();
	}
	@When("^ click on proceed to checkout $")
	public void click_on_proceed_to_checkout() throws InterruptedException
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.clickOnCheckoutButton();
	}
	@When("^ Verify Address details and Review your order $")
	public void Verify_Address_details_and_Review_your_order() throws IOException
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyAddress1();
		dashboard5.verifyReviewHeader();
		dashboard5.scrollToDescription();
	}
	@When("^ enter description in comment text area and click on place order $")
	public void enter_description_in_comment_text_area_and_click_on_place_order()
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.enterDescription("Description");
		dashboard5.clickOnPlaceOrder();
	}
	@When("^ enter payment details nameoncard, cardnumber, cvc and expirationdate $")
	public void enter_payment_details_nameoncard_cardnumber_cvc_and_expirationdate()
	{
		//Method to call Dashboard6 page
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.enterPaymentCardName("Pathange Gaurav");
		dashboard6.enterPaymentCardNumber("123456789123");
		dashboard6.enterPaymentCVV("123");
		dashboard6.enterPaymentExpiryMonth("12");
		dashboard6.enterPaymentExpiryYear("2030");
	}
	@When("^ Click on pay and Confirm order button $")
	public void Click_on_pay_and_Confirm_order_button() throws InterruptedException
	{
		//Method to call Dashboard6 page
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.clickOnPaymentButton();
	}
	@Then("^ Verify Success message $")
	public void Verify_Success_message()
	{
		//Method to call Dashboard6 page
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.verifyPlacedOrder();
	}
	@Then("^ Click on Delete account Button $")
	public void  Click_on_Delete_account_Button()
	{
		//Method to call Dashboard6 page
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.clickOnDeleteButton();
	}
	@Then("^ Verify account deleted and Click on continue button $")
	public void Verify_account_deleted_and_Click_on_continue_button() throws IOException, InterruptedException
	{
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
