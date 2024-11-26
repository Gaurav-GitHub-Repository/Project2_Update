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
import Pages.Dashboard4;
import Pages.Dashboard5;
import Pages.Dashboard6;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase14 {

	WebDriver driver;  

	@Before(order=1)
	@Given("^ Launch google_chrome_browser and navigate_to_url $")
	public void Launch_google_chrome_browser_and_navigate_to_url()
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
	@When("^ Verify Homepage is Visible Successfully $")
	public void Verify_Homepage_is_Visible_Successfully()
	{
		//Method to call login
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("^ add products to cart $")
	public void add_products_to_cart() throws InterruptedException
	{
		//Method to call Dashboard4
		Dashboard4 dashboard4 = new Dashboard4(driver);
		dashboard4.clickOnProducts();
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.scroll();
		//dashboard5.addProductsToCart();
		dashboard5.addProducts();
	}
	@When("^ Click on Cart Button $")
	public void Click_on_Cart_Button()
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.scrollByArrowButton();
		dashboard5.clickOnCartButton();
	}
	@When("^ verify cart page is displayed $")
	public void verify_cart_page_is_displayed()
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyCheckout();
	}
	@When("^ click proceed to checkout $")
	public void click_proceed_to_checkout() throws InterruptedException
	{
		//Method to call Dashboard5
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.clickOnCheckoutButton();
	}
	@When("^ click register or login button $")
	public void click_register_or_login_button()
	{
		Login login = new Login(driver);
		login.clickOnSignIn();
	}
	@When("^ fill details in signup and create account $")
	public void fill_details_in_signup_and_create_account() throws InterruptedException
	{
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
	@When("^ Verify account created and click on Continue button $")
	public void Verify_account_created_and_click_on_Continue_button() throws IOException, InterruptedException
	{
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyAccountCreated();
		dashboard2.clickOnContinue();
	}
	@When("^ verify account created and click on continue button $")
	public void verify_logged_in_as_username_at_top() throws IOException
	{
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.pageload();
		dashboard2.verifyLoggedInName();
	}
	@When("^ Click on cart button $")
	public void Click_on_cart_button()
	{
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.clickOnCartButton();
	}
	@When("^ click on proceed to checkout button $")
	public void click_on_proceed_to_checkout_button() throws InterruptedException
	{
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyCheckout();
		dashboard5.clickOnCheckoutButton();
	}
	@When("^ verify address details and review your order $")
	public void verify_address_details_and_review_your_order() throws IOException
	{
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyAddress1();
		dashboard5.verifyReviewHeader();
		dashboard5.scrollToDescription();
	}
	@When("^ enter description in comment text area and click place order $")
	public void enter_description_in_comment_text_area_and_click_place_order()
	{
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.enterDescription("Description");
		dashboard5.clickOnPlaceOrder();
	}
	@When("^ enter paymentdetails: nameoncard, cardnumber, CVC, expiration date $")
	public void enter_paymentdetails_nameoncard_cardnumber_CVC_expiration_date()
	{
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.enterPaymentCardName("Pathange Gaurav");
		dashboard6.enterPaymentCardNumber("123456789123");
		dashboard6.enterPaymentCVV("123");
		dashboard6.enterPaymentExpiryMonth("12");
		dashboard6.enterPaymentExpiryYear("2030");
	}
	@When("^ click on pay and confirm order button $")
	public void click_on_pay_and_confirm_order_button() throws InterruptedException
	{
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.clickOnPaymentButton();
	}
	@Then("^ Verify Success Message $")
	public void Verify_Success_Message()
	{
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.verifyPlacedOrder();
	}
	@Then("^ click on Delete Account Button $")
	public void Click_on_Delete_Account_Button()
	{
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.clickOnDeleteButton();
	}
	@Then("^ verify account deleted and click on continue button $")
	public void verify_account_deleted_and_click_on_continue_button() throws InterruptedException, IOException
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
