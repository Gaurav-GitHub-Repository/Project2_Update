package Pages;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Alert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard2  {

	Reusablecomponents utility = new Reusablecomponents();

	private WebDriver driver;
	//Constructor to assign driver
	public Dashboard2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement to verify account is created
	@FindBy(xpath="//b[text()='Account Created!']")
	@CacheLookup
	private By Account_Created;

	//WebElement for continue button
	@FindBy(xpath="//a[text()='Continue']")
	@CacheLookup
	private By Continue_Button;

	//WebElement for logged in name
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[10]/a/b")
	@CacheLookup
	private By Logged_Name;

	//WebElement for delete button
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[5]/a/i")
	@CacheLookup
	private By Delete_Button;

	//WebElement to verify account deleted
	@FindBy(xpath="//b[text()='Account Deleted!']")
	@CacheLookup
	private By Account_Deleted;

	//WebElement for contact us
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[8]/a")
	@CacheLookup
	private By Contact_Button;

	//WebElement for contact us
	@FindBy(xpath="//div[@class='contact-form']/h2")
	@CacheLookup
	private By Get_In_Touch;

	//WebElement for contact form name
	@FindBy(xpath="//div[@class='contact-form']/div[3]/form/div/input[@name='name']")
	@CacheLookup
	private By ContactForm_Name;

	//WebElement for contact form email
	@FindBy(xpath="//div[@class='contact-form']/div[3]/form/div[2]/input")
	@CacheLookup
	private By ContactForm_Email;

	//WebElement for subject
	@FindBy(xpath="//div[@class='contact-form']/div[3]/form/div[3]/input")
	@CacheLookup
	private By Subject;

	//WebElement for message
	@FindBy(xpath="//div[@class='contact-form']/div[3]/form/div[4]/textarea")
	@CacheLookup
	private By Message;

	//WebElement for message
	@FindBy(xpath="//input[@name='upload_file']")
	@CacheLookup
	private By ChooseFile_Button;

	//WebElement for submit button
	@FindBy(xpath="//div[@class='contact-form']/div[3]/form/div[6]/input")
	@CacheLookup
	private By Submit_Button;

	//WebElement for alert success message
	@FindBy(xpath="//div[@class='contact-form']/div[2]")
	@CacheLookup
	private By Alert_Success;

	//WebElement for home button
	@FindBy(xpath="//div[@class='contact-form']/div[3]/a")
	@CacheLookup
	private By Home_Button;


	//Method to verify account is created
	public void verifyAccountCreated() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Account_Created));
		String Account = driver.findElement(Account_Created).getText();
		if(Account.equalsIgnoreCase("Account Created!"))
		{
			System.out.println("Account is created");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Account is not created");
		}
	}
	//Method to click on continue button
	public void clickOnContinue() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.findElement(Continue_Button).click();
	}
	//Method to load page
	public void pageload()
	{
		try
		{
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		}
		catch(TimeoutException e)
		{
			System.out.println("TimeoutException Occured");
		}
	}
	//Method to verify logged in name
	public void verifyLoggedInName() throws IOException
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Logged_Name));
			String Homepage_Name = driver.findElement(Logged_Name).getText();
			if(Homepage_Name.equalsIgnoreCase("Gaurav"))
			{
				System.out.println("Logged in as :" + Homepage_Name + "is verified");
				utility.takeScreenshot(driver);
			}
			else
			{
				System.out.println("Homepage_Name is not verified");
			}
		} catch (TimeoutException e)
		{
			e.printStackTrace();
		}
	}
	//Method to click on delete button
	public void clickOnDeleteButton() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(Delete_Button).click();
	}
	//Method to verify account is deleted
	public void verifyAccountDeleted() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Account_Deleted));
		String Deleted_Account = driver.findElement(Account_Deleted).getText();
		if(Deleted_Account.equalsIgnoreCase("Account Deleted!"))
		{
			System.out.println("Account is deleted");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Account is not deleted");
		}	
	}
	//Method to click on contact button
	public void clickOnContactButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Contact_Button));
		driver.findElement(Contact_Button).click();
	}
	//Method to verify contact form text is visible
	public void verifyGetInTouchText() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Get_In_Touch));
		String contact_form = driver.findElement(Get_In_Touch).getText();
		if(contact_form.equalsIgnoreCase("Get In Touch"))
		{
			System.out.println("Contact us form : Get in touch text is visible");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Contact us form : Get in touch text is not visible");
		}
	}
	//Method to enter name
	public void enterContactFormName(String value)
	{
		driver.findElement(ContactForm_Name).sendKeys(value);
	}
	//Method to enter contact form email
	public void enterContactFormEmail(String value)
	{
		driver.findElement(ContactForm_Email).sendKeys(value);
	}
	//Method to enter subject
	public void enterSubject(String value)
	{
		driver.findElement(Subject).sendKeys(value);
	}
	//Method to enter message
	public void enterMessage(String value)
	{
		driver.findElement(Message).sendKeys(value);
		driver.findElement(Message).sendKeys(Keys.TAB);
		//driver.findElement(ChooseFile_Button).sendKeys(Keys.ENTER);
	}
	//Method to click on choose file button
	public void clickOnChooseFile()
	{
		//driver.findElement(ChooseFile_Button).click();
		WebElement element = driver.findElement(By.xpath("//input[@name='upload_file']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		try
		{
			utility.uploadFile();
		}
		catch(AWTException e)
		{
			System.out.println("File is not uploaded");
		}
	}
	//Method to click on submit button
	public void clickOnSubmitButton() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(Submit_Button).click();
	}
	//Method to click on ok button in alert window
	public void OkButton()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	//Method to verify alert success message
	public void verifyAlertSuccess() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Alert_Success));
		String Success_Message = driver.findElement(Alert_Success).getText();
		if(Success_Message.equalsIgnoreCase("Success! Your details have been submitted successfully."))
		{
			System.out.println("Alert success message is verified");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Alert success message is not verified");
		}
	}
	//Method to click on home button
	public void clickOnHomeButton() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(Home_Button).click();
	}
}

