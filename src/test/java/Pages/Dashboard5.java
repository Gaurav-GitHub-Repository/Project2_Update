package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Dashboard5  {

	Reusablecomponents utility = new Reusablecomponents();
	
	private WebDriver driver;
	
	//Constructor to assign driver
	public Dashboard5(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Webelement for cart button
	@FindBy(xpath="//div[@class='shop-menu pull-right']/ul/li[3]/a")
	@CacheLookup
	private By Cart_Button;
	
	//WebElement for shopping button
	@FindBy(xpath="//button[text()='Continue Shopping']")
	@CacheLookup
	private By Shopping_Button;
	
	//WebElement to scroll up arrow button
	@FindBy(xpath="//a[@href='#top']")
	@CacheLookup
	private By arrow_button;

	//WebElement for checkout button
	@FindBy(xpath="//a[text()='Proceed To Checkout']")
	@CacheLookup
	private By checkout_button;

	//WebElement for description text
	@FindBy(xpath="//label[text()='If you would like to add a comment about your order, please write it in the field below.']")
	@CacheLookup
	private By description_text;
	
	//WebElement for place order button
	@FindBy(xpath="//a[text()='Place Order']")
	@CacheLookup
	private By Place_Order;

	//WebElement for cart delete
	@FindBy(xpath="//div[@class='table-responsive cart_info']/table/tbody/tr[1]")
	@CacheLookup
	private By ProductsAdded_Cart;

	//WebElement for cart delete
	@FindBy(xpath="//div[@class='table-responsive cart_info']/table/tbody/tr[1]/td[6]/a")
	@CacheLookup
	private By Cart_Delete;

	//WebElement to verify empty product
	@FindBy(xpath="//div[@class='table-responsive cart_info']/span/p/b")
	@CacheLookup
	private By Empty_Product;

	//WebElement to verify women category
	@FindBy(xpath="//div[@class='left-sidebar']/div[1]/div[1]/div[1]/h4/a")
	@CacheLookup
	private By Women_Category;

	//WebElement for dress
	@FindBy(xpath="//div[@class='left-sidebar']/div[1]/div/div[2]/div/ul/li/a[1]")
	@CacheLookup
	private By Dress;
	
	//WebElement for men category
	@FindBy(xpath="//div[@class='left-sidebar']/div[1]/div[2]/div[1]/h4/a")
	@CacheLookup
	private By Men_Category;

	//WebElement for T-Shirts 
	@FindBy(xpath="//div[@class='left-sidebar']/div[1]/div[2]/div[2]/div/ul/li/a[1]")
	@CacheLookup
	private By T_Shirts;

	//WebElemnt for brand 
	@FindBy(xpath="//div[@class='left-sidebar']/div[2]/div/ul")
	@CacheLookup
	private By Brand;

	//WebElement for Full-Fledged practice website for Automation Engineers text
	@FindBy(xpath="//div[@id='slider-carousel']/div/div[2]/div/h2")
	@CacheLookup
	private By header_text;
	
	
	//Method to click on cart button
	public void cartButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Cart_Button));
		driver.findElement(Cart_Button).click();
	}
	//Method to scroll to the element
	public void scroll()
	{
		utility.scrollToElement(driver);
	}
	//Method to load page
	public void pageload()
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	//Method to add products to the cart
	public void addProductsToCart() throws InterruptedException
	{
		int i=2;
		while(i<=34)
		{
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			WebElement wait = driver.findElement(By.xpath("//div[@class='features_items']/div["+i+"]/div/div/div/img"));
			action.clickAndHold(wait).build().perform();
			WebElement Product = driver.findElement(By.xpath("//div[@class='features_items']/div["+i+"]/div/div/div/a"));
			action.click(Product).build().perform();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();		
			i++;
		}
	}
	//Method to add products
	public void addProducts() throws InterruptedException
	{
		int i=2;
		while(i<=34)
		{
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			WebElement wait = driver.findElement(By.xpath("//div[@class='features_items']/div["+i+"]/div/div/div/img"));
			action.clickAndHold(wait).build().perform();
			WebElement Product = driver.findElement(By.xpath("//div[@class='features_items']/div["+i+"]/div/div/div/a"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",Product);
			//WebDriverWait button = new WebDriverWait(driver, Duration.ofSeconds(60));
			//button.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Shopping_Button));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
			i++;
		}
	}
	//Method to scroll up using arrow button
	public void scrollByArrowButton()
	{
		WebDriverWait button = new WebDriverWait(driver, Duration.ofSeconds(60));
		button.until(ExpectedConditions.presenceOfAllElementsLocatedBy(arrow_button));
		driver.findElement(arrow_button).click();
	}
	//Method to click on cart
	public void clickOnCartButton()
	{
		WebDriverWait button = new WebDriverWait(driver, Duration.ofSeconds(60));
		button.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Cart_Button));
		driver.findElement(Cart_Button).click();
	}
	//Method to verify checkout page
	public void verifyCheckout()
	{
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Checkout");
	}
	//Method to click on checkout button
	public void clickOnCheckoutButton() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.findElement(checkout_button).click();
	}
	//Method to verify delivery address and billing address
	public void verifyAddress()
	{
		for(int i=2; i<=7; i++)
		{
			String delivery_address = driver.findElement(By.xpath("//div[@class='checkout-information']/div[1]/div[1]/ul/li["+i+"]")).getText();
			System.out.println(delivery_address);
			if(i==7)
			{
				for(int j=2; j<=7; j++)
				{
					String billing_address = driver.findElement(By.xpath("//div[@class='checkout-information']/div[1]/div[2]/ul/li["+i+"]")).getText();
					System.out.println(billing_address);
				}
			}
		}
	}
//Method to verify address
public void verifyAddress1()
{
for(int i=2; i<=7; i++)
{
if(driver.findElement(By.xpath("//div[@class='checkout-information']/div[1]/div[1]/ul/li["+i+"]")).getText().equalsIgnoreCase(driver.findElement(By.xpath("//div[@class='checkout-information']/div[1]/div[2]/ul/li["+i+"]")).getText()))
{
System.out.println("Delivery address and billing address are verified");
}
else
{
System.out.println("Delivery and billing address are not verified");
}
}
}
	//Method to review names displayed in header
	public void verifyReviewHeader()
	{
		for(int i=1; i<=5; i++)
		{
			String Review_Header = driver.findElement(By.xpath("//div[@id='cart_info']/table/thead/tr/td["+i+"]")).getText();
			System.out.println(Review_Header);
			if(i==5)
			{
				System.out.println("Review header is verified");
			}
		}
	}
	//Method to scroll to the description text
	public void scrollToDescription() throws IOException
	{
		WebElement Element = driver.findElement(By.xpath("//label[text()='If you would like to add a comment about your order, please write it in the field below.']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		utility.takeScreenshot(driver);
	}
	//Method to enter description
	public void enterDescription(String value)
	{
		driver.findElement(By.xpath("//div[@id='ordermsg']/textarea")).clear();
		driver.findElement(By.xpath("//div[@id='ordermsg']/textarea")).sendKeys(value);
	}
	//Method to click on place order button
	public void clickOnPlaceOrder()
	{
		WebDriverWait button = new WebDriverWait(driver, Duration.ofSeconds(60));
		button.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Place_Order));
		driver.findElement(Place_Order).click();
	}
	//Method to click on cart delete button
	public void clickOnDeleteButton()
	{
		int NumberOfTables = driver.findElements(By.xpath("//div[@class='table-responsive cart_info']/table/tbody")).size();
		
		for(int i=1; i<=NumberOfTables; i++)
		{
			driver.findElement(By.xpath("//div[@class='table-responsive cart_info']/table/tbody/tr["+i+"]/td[6]/a")).click();
		}
	}
	//Method to verify product added is emplty
	public void verifyRemovedProduct() throws IOException
	{
		WebElement RemovedProduct = driver.findElement(Empty_Product);
		if(RemovedProduct.getText().isEmpty())
		{
			System.out.println("Added products are removed from the cart");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Added products are not removed from the cart");
		}
	}
	//Method to verify categories
	public void verifyCategories()
	{
		int category = driver.findElements(By.xpath("//div[@class='left-sidebar']/div[1]")).size();
		for(int i=1; i<=category; i++)
		{
			String category_name =driver.findElement(By.xpath("//div[@class='left-sidebar']/div[1]/div["+i+"]/div[1]/h4/a")).getText();
			System.out.println(category_name + " " + "Category names are verified");
		}
	}
	//Method to click on women category
	public void verifyWomenCategory() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Women_Category));
		String women_category = driver.findElement(Women_Category).getText();
		if(women_category.equalsIgnoreCase("Women"))
		{
			System.out.println("Women category is verified");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Women category is not verified");
		}
	}
	//Method to click on women category
	public void clickOnWomenCategory() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Women_Category));
		driver.findElement(Women_Category).click();
		utility.takeScreenshot(driver);
	}
	//Method to click on dress
	public void clickOnDress()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Dress));
		driver.findElement(By.xpath("//div[@class='left-sidebar']/div[1]/div/div[2]/div/ul/li/a[1]")).click();
	}
	//Method to verify women product page
	public void verifyWomenProductPage()
	{
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Dress Products");
	}
	//Method to verify men category
	public void clickOnMencategory()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Men_Category));
		driver.findElement(Men_Category).click();
	}
	//Method to click on men t-shirt
	public void clickOnMenShirt()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(T_Shirts));
		driver.findElement(T_Shirts).click();
	}
	//Method to verify men product page
	public void verifyMenProductPage()
	{
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Tshirts Products");
	}
	//Method to verify category products
	public void verifyWomenCategoryProducts() throws IOException
	{
		int category = driver.findElements(By.xpath("//div[@class='left-sidebar']/div[1]")).size();
		for(int i=1; i<=category; i++)
		{
			String category_name =driver.findElement(By.xpath("//div[@class='left-sidebar']/div[1]/div["+i+"]/div[1]/h4/a")).getText();
			if(category_name.equalsIgnoreCase("Women"))
			{
				driver.findElement(By.xpath("//div[@class='left-sidebar']/div[1]/div[1]/div[2]/div/ul/li/a[1]")).click();
				Assert.assertEquals(driver.getTitle(), "Automation Exercise - Dress Products");
				utility.takeScreenshot(driver);
			}
			else
			{
				System.out.println("User is not on the product page");
			}
		}
	}
	//Method to verify category products
	public void verifyMenCategoryProducts() throws IOException
	{
		int category = driver.findElements(By.xpath("//div[@class='left-sidebar']/div[1]")).size();
		for(int i=1; i<=category; i++)
		{
			String category_name =driver.findElement(By.xpath("//div[@class='left-sidebar']/div[1]/div["+i+"]/div[1]/h4/a")).getText();
			if(category_name.equalsIgnoreCase("Men"))
			{
				driver.findElement(By.xpath("//div[@class='left-sidebar']/div[1]/div[2]/div[2]/div/ul/li/a[1]")).click();
				Assert.assertEquals(driver.getTitle(), "Automation Exercise - Tshirts Products");
				utility.takeScreenshot(driver);
			}
			else
			{
				System.out.println("User is not on the product page");
			}
		}
	}
	//Method to click on brand
	public void clickOnPoloBrand() throws IOException
	{
		int TotalBrands = driver.findElements(Brand).size();
		for(int i=1; i<=TotalBrands; i++)
		{
			WebElement PoloBrand = driver.findElement(By.xpath("//div[@class='left-sidebar']/div[2]/div/ul/li["+i+"]"));
			if(PoloBrand.getText().equalsIgnoreCase("Polo"))
			{
				Assert.assertEquals(driver.getTitle(), "Automation Exercise - Polo Products");
				utility.takeScreenshot(driver);
			}
			else
			{
				System.out.println("User is not navigated to polo brand page");
			}
		}
	}
	//Method to click on brand
	public void clickOnHMBrand() throws IOException
	{
		int TotalBrands = driver.findElements(Brand).size();
		for(int i=1; i<=TotalBrands; i++)
		{
			WebElement HMBrand = driver.findElement(By.xpath("//div[@class='left-sidebar']/div[2]/div/ul/li["+i+"]"));
			if(HMBrand.getText().equalsIgnoreCase("H&M"))
			{
				Assert.assertEquals(driver.getTitle(), "Automation Exercise - H&amp;M Products");
				utility.takeScreenshot(driver);
			}
			else
			{
				System.out.println("User is not navigated to polo brand page");
			}
		}
	}
	//Method to verify products are added in cart
	public void verifyProductsAddedInCart() throws IOException
	{
		int NumberOfTables = driver.findElements(By.xpath("//div[@class='table-responsive cart_info']/table/tbody")).size();
		for(int i=1; i<=NumberOfTables; i++)
		{
			boolean Table = driver.findElement(By.xpath("//table[@class='table table-condensed']/tbody/tr["+i+"]")).isDisplayed();
			if(Table == true)
			{
				System.out.println("Added products are displayed in checkout page");
				utility.takeScreenshot(driver);
			}
			else
			{
				System.out.println("Added products are not displayed in checkout page");
			}
		}
	}
	//Method to verify automation text
	public void verifyAutomationHeaderText() throws IOException
	{
		WebElement header_text = driver.findElement(By.xpath("//div[@id='slider-carousel']/div/div[2]/div/h2"));
		Actions action = new Actions(driver);
		action.clickAndHold(header_text);
		if(header_text.getText().equalsIgnoreCase("Full-Fledged practice website for Automation Engineers"))
		{
			System.out.println("Header text is verified");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Header text is not verified");
		}
	}
	//Method to scroll up
	public void scrollUp() throws IOException
	{
		WebElement scrollToHeader = driver.findElement(By.xpath("//div[@id='slider-carousel']/div/div[2]/div/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollToHeader);
		utility.takeScreenshot(driver);
	}
}
