package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login  {

	Reusablecomponents utility = new Reusablecomponents();
	
	private WebDriver driver;
	//Constructor to assign driver
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	//WebElement for signup/login
	@FindBy(xpath="//div[@class='row'][1]/div[2]/div/ul/li[4]/a")
	@CacheLookup
	private By SignIn;
	
	//WebElement to click on signup/login
	@FindBy(xpath="//div[@class='row']/div[2]/div/ul/li[4]")
	@CacheLookup
	private By Signup_Login;

	//Webelement for new user name
	@FindBy(xpath="//div[@class='signup-form']/form/input[2]")
	@CacheLookup
	private By Name;

	//WebElemnt to verify new user signup page
	@FindBy(xpath="//div[@class='signup-form']/h2")
	@CacheLookup
	private By SignUpPage;
	
	//WebElemnt to verify new user signup page
	@FindBy(xpath="//div[@class='signup-form']/form/input[3]")
	@CacheLookup
	private By Email;
	
	//WebElement for signin button
	@FindBy(xpath="//div[@class='signup-form']/form/input[3]")
	@CacheLookup
	private By SignInButton;

	//WebElement for signup button
	@FindBy(xpath="//button[text()='Signup']")
	@CacheLookup
	private By SignUpButton;

	//WebElement to verify account information
	@FindBy(xpath="//div[@class='login-form']/h2/b")
	@CacheLookup
	private By AccountInformation;
	
	//WebElement to verify login to your account is visible
	@FindBy(xpath="//div[@class='login-form']/h2")
	@CacheLookup
	private By Login;
	
	//WebElement for login email address
	@FindBy(xpath="//div[@class='login-form']/form/input[2]")
	@CacheLookup
	private By Login_Email;

	//WebElement for login password
	@FindBy(xpath="//div[@class='login-form']/form/input[3]")
	@CacheLookup
	private By Login_Password;
	
	//WebElement for login button
	@FindBy(xpath="//button[text()='Login']")
	@CacheLookup
	private By Login_Button;

	//WebElement for logged in name
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[10]/a/b")
	@CacheLookup
	private By Logged_Name;

	//WebElement for logged in name
	@FindBy(xpath="//div[@class='login-form']/form/p")
	@CacheLookup
	private By Login_Error;

	//WebElement for logout button
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[4]/a")
	@CacheLookup
	private By Logout_Button;
	
	//WebElement for signin error
	@FindBy(xpath="//div[@class='signup-form']/form/p")
	@CacheLookup
	private By SignInError;

	//WebElement for test cases
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[5]")
	@CacheLookup
	private By TestCases;
	
	
	//Method to verify homepage
	public void verifyHomePage()
	{
		String HomePageTitle = driver.getTitle();
		if(HomePageTitle.equalsIgnoreCase("Automation Exercise"))
		{
			System.out.println("Home Page is verified and user is on homepage");
		}
		else
		{
			System.out.println("Home Page is not verified");
		}
	}
	//Method to click on signin 
	public void clickOnSignIn()
	{
		driver.findElement(SignIn).click();
		System.out.println("Successfully clicked on signin page");
	}
	//Method to verify user is on new user sign up page
	public void verifySignUp() throws IOException
	{	
	 	String NewUserSignUp = driver.findElement(SignUpPage).getText();
	 	if(NewUserSignUp.equalsIgnoreCase("New User Signup!"))
	 	{
	 		System.out.println("User is on new signin page");
	 		utility.takeScreenshot(driver);
	 	}
	 	else
	 	{
	 		System.out.println("User is not on new signin page");
	 	}
	}
	//Method to enter new signup name
	public void enterSignInName(String value)
	{
		driver.findElement(Name).sendKeys(value);
		System.out.println("Successfully entered signin name");
	}
	//Method to enter signin email
	public void enterSignInEmail(String value)
	{
		driver.findElement(Email).sendKeys(value);
		System.out.println("Successfully entered signin email");
	}
	//Method to click on signin button
	public void clickOnSignInButton()
	{
		try
		{
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(SignUpButton));
		    driver.findElement(SignUpButton).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("signin button is not working");
		}
	}
	//Method to verify login account
	public void verifyLogin()
	{
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Login));
		String Login_Form = driver.findElement(Login).getText();
		if(Login_Form.equalsIgnoreCase("Login to your account"))
		{
			System.out.println("Login to your account is visible");
		}
		else
		{
			System.out.println("Login to your account is not visible");
		}
	}
	//Method to enter login email
	public void enterLoginEmail(String value_email)
	{
		driver.findElement(Login_Email).sendKeys(value_email);
	}
	//Method to enter login password
	public void enterLoginPassword(String value_password)
	{
		driver.findElement(Login_Password).sendKeys(value_password);
	}
	//Method to click on login button
	public void clickOnLoginButton() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(Login_Button).click();
	}
	//Method to verify logged in name
	public void verifyLoggedInName() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Logged_Name));
		String Homepage_Name = driver.findElement(Logged_Name).getText();
		if(Homepage_Name.contains("Pathange Gaurav"))
		{
			System.out.println("Logged in as :" + Homepage_Name + "is verified");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Homepage_Name is not verified");
		}
	}
	//Method to verify login error
	public void verifyLoginError() throws IOException
	{
		String Error = driver.findElement(Login_Error).getText();
		if(Error.contains("Your email or password is incorrect!"))
		{
			System.out.println("Login error is verified");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Login error is not verified");
		}
	}
	//Method to click on logout button
	public void clickOnLogoutButton() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Logout_Button));
		driver.findElement(Logout_Button).click();
	}
	//Method to verify login/signin page title
	public void verifyLoginPageTitle()
	{
		if(driver.getTitle().equalsIgnoreCase("Automation Exercise - Signup / Login"))
		{
			System.out.println("Login/Signin page title is verified : " + "User is on login page");
		}
		else
		{
			System.out.println("Login/Signin page title is not verified : " + "User is not in login page");
		}
	}
	//Method to verify sigin error
	public void verifySignInError() throws IOException
	{	
		String Error = driver.findElement(SignInError).getText();
		if(Error.contains("Email Address already exist!"))
		{
			System.out.println("SignIn error is verified");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("SignIn error is not verified");
		}
	}
	//Method to click on test cases
	public void clickOnTestCase()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(TestCases));
		driver.findElement(TestCases).click();
	}
	//Method to verify test case [page
	public void verifyTestCase()
	{
		if(driver.getTitle().equalsIgnoreCase("Automation Practice Website for UI Testing - Test Cases"))
		{
			System.out.println("Page title is verified and user is on the test case page");
		}
		else
		{
			System.out.println("Page title is not verified and user is not on the test case page");
		}
	}
}
