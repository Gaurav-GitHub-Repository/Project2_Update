package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Dashboard6  {

	Reusablecomponents utility = new Reusablecomponents();
	
	static WebDriver driver;
	
	public Dashboard6(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement for payment card name
	@FindBy(xpath="//input[@class='form-control' and @name='name_on_card']")
	@CacheLookup
	private By Payment_CardName;
	
	//WebElemnt for payment card number
	@FindBy(xpath="//input[@name='card_number' and @class='form-control card-number']")
	@CacheLookup
	private By Payment_CardNumber;

	//WebElement for payment cvv
	@FindBy(xpath="//input[@name='cvc' and @class='form-control card-cvc']")
	@CacheLookup
	private By Payment_CVV;
	
	//WebElemnt for payment expiry
	@FindBy(xpath="//input[@class='form-control card-expiry-month' and @name='expiry_month']")
	@CacheLookup
	private By Payment_CardExpiryMonth;

	//WebbElement for payment expiry year
	@FindBy(xpath="//input[@name='expiry_year' and @class='form-control card-expiry-year']")
	@CacheLookup
	private By Payment_ExpiryYear;

	//WebElement for pay and confirm order button
	@FindBy(xpath="//button[text()='Pay and Confirm Order']")
	@CacheLookup
	private By Payment_ConfirmButton;

	//Webelement for order placed success message
	@FindBy(xpath="//p[text()='Congratulations! Your order has been confirmed!']/parent::div/p")
	@CacheLookup
	private By OrderPlaced_Success;

	//WebElemnt to click on delete button
	@FindBy(xpath="//a[@href='/delete_account']")
	@CacheLookup
	private By Delete_Button;
	
	
	
	//Method to enter payment card name
	public void enterPaymentCardName(String value)
	{
		driver.findElement(Payment_CardName).clear();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Payment_CardName));
		driver.findElement(Payment_CardName).sendKeys(value);
	}
	//Method to enter payment card number
	public void enterPaymentCardNumber(String value)
	{
		driver.findElement(Payment_CardNumber).clear();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Payment_CardNumber));
		driver.findElement(Payment_CardNumber).sendKeys(value);
	}
	//Method to enter payment cvv
	public void enterPaymentCVV(String value)
	{
		driver.findElement(Payment_CVV).clear();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Payment_CVV));
		driver.findElement(Payment_CVV).sendKeys(value);
	}
	//Method to enter payment expiry
	public void enterPaymentExpiryMonth(String value)
	{
		driver.findElement(Payment_CardExpiryMonth).clear();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Payment_CardExpiryMonth));
		driver.findElement(Payment_CardExpiryMonth).sendKeys(value);		
	}
	//Method to enter payment expiry year
	public void enterPaymentExpiryYear(String value)
	{
		driver.findElement(Payment_ExpiryYear).clear();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Payment_ExpiryYear));
		driver.findElement(Payment_ExpiryYear).sendKeys(value);	
	}
	//Method to click on payment and conform button
	public void clickOnPaymentButton() throws InterruptedException
	{
		WebDriverWait button = new WebDriverWait(driver, Duration.ofSeconds(60));
		button.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Payment_ConfirmButton));
		driver.findElement(Payment_ConfirmButton).click();
	}
	//Method to verify placed order
	public void verifyPlacedOrder()
	{
		try {
			String OrderPlaced_Success = driver.findElement(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")).getText();
			Assert.assertEquals(OrderPlaced_Success, "Congratulations! Your order has been confirmed!");
			utility.takeScreenshot(driver);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	//Method to click on delete button
	public void clickOnDeleteButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Delete_Button));
		driver.findElement(Delete_Button).click();
	}
}
