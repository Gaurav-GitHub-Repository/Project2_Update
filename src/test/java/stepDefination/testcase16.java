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

import Pages.Dashboard2;
import Pages.Dashboard5;
import Pages.Dashboard6;
import Pages.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class testcase16 {

	WebDriver driver;  

	@Before(order=1)
	@Given("^ Launch google chrome browser And navigate to url $")
	public void Launch_google_chrome_browser_And_navigate_to_url()
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
	@When("^ verify Homepage is Visible Successfully $")
	public void verify_Homepage_is_Visible_Successfully()
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.verifyHomePage();
	}
	@When("^ Click on signup or login button $")
	public void Click_on_signup_or_login_button()
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.clickOnSignIn();
	}
	@When("^ fill email, password and click on login button $")
	public void fill_email_password_and_click_on_login_button() throws InterruptedException
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.enterLoginEmail("inevitablegaurav@gmail.com");
		login.enterLoginPassword("Gaurav");
		login.clickOnLoginButton();
	}
	@When("^ verify Logged in as username at top $")
	public void verify_Logged_in_as_username_at_top() throws IOException
	{
		//Method to call Login page
		Login login = new Login(driver);
		login.verifyLoggedInName();
	}
	@When("^ Add products to cart $")
	public void Add_products_to_cart() throws InterruptedException
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.scroll();
		//dashboard5.addProductsToCart();
		dashboard5.addProducts();
		dashboard5.scrollByArrowButton();
	}
	@When("^ click on Cart Button $")
	public void click_on_Cart_Button()
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.clickOnCartButton();
	}
	@When("^ Verify Cart Page is displayed $")
	public void Verify_Cart_Page_is_displayed()
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyCheckout();
	}
	@When("^ click on proceed to Checkout $")
	public void click_on_proceed_to_Checkout() throws InterruptedException
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.clickOnCheckoutButton();
	}
	@When("^ Verify address Details and Review your order $")
	public void Verify_address_Details_and_Review_your_order() throws IOException
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.verifyAddress1();
		dashboard5.verifyReviewHeader();
		dashboard5.scrollToDescription();
	}
	@When("^ Enter description in comment text area and click on place order $")
	public void Enter_description_in_comment_text_area_and_click_on_place_order()
	{
		//Method to call Dashboard5 page
		Dashboard5 dashboard5 = new Dashboard5(driver);
		dashboard5.enterDescription("Description");
		dashboard5.clickOnPlaceOrder();
	}
	@When("^ Enter payment details nameoncard, cardnumber, cvc and expirationdate $")
	public void Enter_payment_details_nameoncard_cardnumber_cvc_and_expirationdate()
	{
		//Method to call Dashboard6 page
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.enterPaymentCardName("Pathange Gaurav");
		dashboard6.enterPaymentCardNumber("123456789123");
		dashboard6.enterPaymentCVV("123");
		dashboard6.enterPaymentExpiryMonth("12");
		dashboard6.enterPaymentExpiryYear("2030");
	}
	@When("^ Click on Pay and Confirm Order Button $")
	public void Click_on_Pay_and_Confirm_Order_Button() throws InterruptedException
	{
		//Method to call Dashboard6 page
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.clickOnPaymentButton();
	}
	@Then("^ verify Success Message $")
	public void verify_Success_Message()
	{
		//Method to call Dashboard6 page
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.verifyPlacedOrder();
	}
	@Then("^ click on Delete Account button $")
	public void click_on_Delete_Account_button()
	{
		//Method to call Dashboard6 page
		Dashboard6 dashboard6 = new Dashboard6(driver);
		dashboard6.clickOnDeleteButton();
	}
	@Then("^ Verify Account deleted and Click on Continue Button $")
	public void Verify_Account_deleted_and_Click_on_Continue_Button() throws IOException, InterruptedException
	{
		//Method to call Dashboard6 page
		Dashboard6 dashboard6 = new Dashboard6(driver);
		Dashboard2 dashboard2 = new Dashboard2(driver);
		dashboard2.verifyAccountDeleted();
		dashboard2.clickOnContinue();
	}
	@After(order=1)
	public void logout()
	{
		driver.close();;
	}
}
