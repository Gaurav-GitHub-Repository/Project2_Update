package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

	Reusablecomponents utility = new Reusablecomponents();
	
	private WebDriver driver;
	
	//Constructor to assign driver
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement to verify account information
	@FindBy(xpath="//div[@class='login-form']/h2/b")
	@CacheLookup
	private By AccountInformation;

	//WebElement for radio button1
	@FindBy(xpath="//input[@id='id_gender1' and @name='title']")
	@CacheLookup
	private By Radio_Button;
	
	//WebElement for name
	@FindBy(xpath="//div[@class='login-form']/form/div[2]/input")
	@CacheLookup
	private By Name;

	//WebElement for email
	@FindBy(xpath="//div[@class='login-form']/form/div[3]/input[@id='email']")
	@CacheLookup
	private By Email;

	//WebElement for password
	@FindBy(xpath="//div[@class='login-form']/form/div[4]/input")
	@CacheLookup
	private By Password;
	
	//WebElement for checkbox
	@FindBy(xpath="//label[text()='Sign up for our newsletter!']")
	@CacheLookup
	private By Checkbox;

	//WebElement for checkbox2
	@FindBy(xpath="//input[@name='optin' and @id='optin']")
	@CacheLookup
	private By Checkbox2;

	//WebElement for first name
	@FindBy(xpath="//input[@id='first_name' and @name='first_name']")
	@CacheLookup
	private By First_Name;
	
	//WebElement for Last Name
	@FindBy(xpath="//input[@id='last_name' and @name='last_name']")
	@CacheLookup
	private By Last_Name;

	//WebElement for Company
	@FindBy(xpath="//input[@id='company' and @name='company']")
	@CacheLookup
	private By Company;

	//WebElement for Address1
	@FindBy(xpath="//input[@name='address1' and @id='address1']")
	@CacheLookup
	private By Address1;
	
	//WebElement for Address2
	@FindBy(xpath="//input[@name='address2' and @id='address2']")
	@CacheLookup
	private By Address2;

	//WebElement for state
	@FindBy(xpath="//input[@name='state' and @id='state']")
	@CacheLookup
	private By State;

	//WebElement for city
	@FindBy(xpath="//input[@name='city' and @id='city']")
	@CacheLookup
	private By City;

	//WebElement for zipcode
	@FindBy(xpath="//input[@name='zipcode' and @id='zipcode']")
	@CacheLookup
	private By Zipcode;

	//WebElement for mobile number
	@FindBy(xpath="//input[@name='mobile_number' and @id='mobile_number']")
	@CacheLookup
	private By Mobile;
		
	//WebElement for mobile number
	@FindBy(xpath="//input[@name='mobile_number' and @id='mobile_number']")
	@CacheLookup
	private By Mobile_Number;

	//WebElement for create button
	@FindBy(xpath="//button[text()='Create Account']")
	@CacheLookup
	private By Create_Button;
	
	//Method to verify account information
	public void verifyAccountInformation() throws InterruptedException, IOException
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AccountInformation));
		String AccInfo = driver.findElement(AccountInformation).getText();
		System.out.println("Account Information is visible :" + AccInfo);
		utility.takeScreenshot(driver);
		}
		catch(TimeoutException e)
		{
			System.out.println("TimeoutException occured");
		}
	}
	//Method to click on radio button one
	public void clickOnRadioButton()
	{
		driver.findElement(Radio_Button).click();;
	}
	//Method to enter name
	public void enterName(String value)
	{
		driver.findElement(Name).sendKeys(value);
	}
	//Method to enter email
	public void enterEmail(String value)
	{
		driver.findElement(Email).sendKeys(value);
	}
	//Method to enter password
	public void enterPassword(String value)
	{
		driver.findElement(Password).sendKeys(value);
	}
	//Method to scroll
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	//Method to select checkbox
	public void clickOnCheckbox()
	{
		//utility.scroll();
		driver.findElement(Checkbox).click();
	}
	//Method to click on second checkbox
	public void clickOnSecondCheckbox()
	{
		driver.findElement(Checkbox2).click();
	} 
	//Method to enter first name
	public void enterFirstName(String value)
	{
		driver.findElement(First_Name).sendKeys(value);
	}
	//Method to enter Last Name
	public void enterLastName(String value)
	{
		driver.findElement(Last_Name).sendKeys(value);
	}
	//Method to enter company
	public void enterCompany(String value)
	{
		driver.findElement(Company).sendKeys(value);
	}
	//Method to enter address1
	public void enterAddress1(String value)
	{
		driver.findElement(Address1).sendKeys(value);
	}
	//Method to enter Address2
	public void enterAddress2(String value)
	{
		driver.findElement(Address2).sendKeys(value);
	}
	//Method to select country
	public void selectCountry()
	{
		Select country = new Select(driver.findElement(By.xpath("//select[@id='country']")));
		country.selectByVisibleText("India");
		List<WebElement> countryvar = country.getAllSelectedOptions();
		for(WebElement var : countryvar)
		{
			if(var.equals("India"))
			{
				System.out.println("Country is selected");
				break;
			}
		}
	}
	//Method to enter state
	public void enterState(String value)
	{
		driver.findElement(State).sendKeys(value);
	}
	//Method to enter city
	public void enterCity(String value)
	{
		driver.findElement(City).sendKeys(value);
	}
	//Method to enter zipcode
	public void enterZipcode(String value)
	{
		driver.findElement(Zipcode).sendKeys(value);
	}
	//Method to enter mobile number
	public void enterMobileNumber(String value)
	{
		driver.findElement(Mobile_Number).sendKeys(value);
	}
	//Method to click on create button
	public void clickOnCreateButton() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(Create_Button).click();
	}
}   

