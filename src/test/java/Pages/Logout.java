package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {

	static WebDriver driver;
	
	public Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Webelement for new user name
	@FindBy(xpath="//div[@class='row'][1]/div[2]/div/ul/li[4]/a")
	@CacheLookup
	private By Name;
	
	//WebElement for email
	@FindBy(xpath="//div[@class='signup-form']/form/input[3]")
	@CacheLookup
	private By Email;

	//WebElement for signup button
	@FindBy(xpath="//button[text()='Signup']")
	@CacheLookup
	private By SignUpButton;

	//WebElement for signup button
	@FindBy(xpath="//div[@class='login-form']/h2")
	@CacheLookup
	private By Login;

	//WebElement for login email
	@FindBy(xpath="//div[@class='login-form']/form/input[2]")
	@CacheLookup
	private By Login_Email;
	
	//WebElement for login password
	@FindBy(xpath="//div[@class='login-form']/form/input[3]")
	@CacheLookup
	private By Login_Password;
	
	//WebElement for login password
	@FindBy(xpath="//button[text()='Login']")
	@CacheLookup
	private By Login_Button;

	
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
	public void enterLoginEmail(String value)
	{
		driver.findElement(Login_Email).sendKeys(value);
	}
	//Method to enter login password
	public void enterLoginPassword(String value)
	{
		driver.findElement(Login_Password).sendKeys(value);
	}
	//Method to click on login button
	public void clickOnLoginButton() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(Login_Button).click();
	}
}
