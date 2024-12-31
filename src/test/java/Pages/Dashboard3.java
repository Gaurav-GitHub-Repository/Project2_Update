package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard3  {

	Reusablecomponents utility = new Reusablecomponents();
	
	static WebDriver driver;
	
	//Constructor to assign driver
	public Dashboard3(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement for products
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]/a")
	@CacheLookup
	private By Products;
	
	//WebElement for list of brand products
	@FindBy(xpath="//div[@class='brands_products']/div")
	@CacheLookup
	private By Brand_Products;

	//WebElement for view product of first product
	@FindBy(xpath="//a[@href='/product_details/1']")
	@CacheLookup
	private By View_Product;

	//WebElement for product information
	@FindBy(xpath="//div[@class='product-details']/div[2]/div")
	@CacheLookup
	private By Product_Information;
	
	//WebElement for search button
	@FindBy(xpath="//input[@name='search' and @id='search_product']")
	@CacheLookup
	private By Search;

	//WebElement for search button
	@FindBy(xpath="//button[@id='submit_search' and @type='button']")
	@CacheLookup
	private By Search_Button;
	
	//WebElement for searched product
	@FindBy(xpath="//div[@class='product-image-wrapper']")
	@CacheLookup
	private By Searched_Product;

	//WebElement for footer subscription text
	@FindBy(xpath="//div[@class='footer-widget']/div/div/div[2]/div/h2")
	@CacheLookup
	private By Subscription_Text;
	
	//WebElement for subscription email
	@FindBy(xpath="//div[@class='footer-widget']/div/div/div[2]/div/form/input[2]")
	@CacheLookup
	private By Subscription_Email;

	//WebElement for subscription button
	@FindBy(xpath="//div[@class='footer-widget']/div/div/div[2]/div/form/button")
	@CacheLookup
	private By Subscription_Button;

	//WebElement for subscription message
	@FindBy(xpath="//div[text()='You have been successfully subscribed!']")
	@CacheLookup
	private By Subscription_Message;
	
	//WebElement to verify searched product
	@FindBy(xpath="//div[@class='features_items']/h2")
	@CacheLookup
	private By SearchedProduct;

	//WebElement to click on all view products
	@FindBy(xpath="//div[@class='features_items']/div[4]/div/div[2]/ul/li/a")
	@CacheLookup
	private By All_ViewProducts;
	
	//WebElement for write your review
	@FindBy(xpath="//a[text()='Write Your Review']")
	@CacheLookup
	private By WriteReview;
	
	//WebElement for review name
	@FindBy(xpath="//form[@id='review-form']/span/input[1]")
	@CacheLookup
	private By Review_Name;
	
	//WebElement for review name
	@FindBy(xpath="//form[@id='review-form']/span/input[2]")
	@CacheLookup
	private By Review_Email;

	//WebElement for review text
	@FindBy(xpath="//form[@id='review-form']/textarea")
	@CacheLookup
	private By Review_Text;
	
	//WebElement for review button
	@FindBy(xpath="//form[@id='review-form']/button")
	@CacheLookup
	private By Review_Button;
	
	//WebElement for review success message
	@FindBy(xpath="//span[text()='c']")
	@CacheLookup
	private By Review_SuccessMessage;
	
	
	//Method to click on products
	public void clickOnProducts()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Products));
		driver.findElement(Products).click();
	}
	//Method to verify title of product page
	public void verifyProductPage()
	{
		if(driver.getTitle().equalsIgnoreCase("Automation Exercise - All Products"))
		{
			System.out.println("Product page is verified and user is on product page");
		}
		else
		{
			System.out.println("Product page is not verified and user is not on product page");
		}
	}
	//Method to retrieve brand products
	public void brandproducts()
	{
		List<WebElement> Products = driver.findElements(Brand_Products);
		for(WebElement NumberofProducts : Products)
		{
			System.out.println(NumberofProducts.getText());
			break;
		}
	}
	//Method to scroll
	public void element()
	{
	/*	WebElement Element = driver.findElement(By.xpath("//div[@class='brands_products']/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", "Element"); */
		//utility.scroll();
		
		Actions action = new Actions(driver);
		WebElement Product = driver.findElement(By.xpath("//div[@class='single-products']/div[2]"));
		action.clickAndHold(Product);
		WebElement Product1 = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
		action.click(Product1).build().perform();
	}
	//Method to click on view product
	public void clickOnViewProduct()
	{	
		try {
		        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(View_Product));
			WebElement view_product = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", view_product);
			//driver.findElement(View_Product).click();
		}
		catch(ElementClickInterceptedException e)
		{
			System.out.println("ElementClickInterceptedException Occured");
		}
	}
	//Method to verify page title of product details page
	public void verifyProductDetails()
	{
		if(driver.getTitle().equalsIgnoreCase("Automation Exercise - Product Details"))
		{
			System.out.println("Product details page is verified and user is on product details page");
		}
		else
		{
			System.out.println("Product details page is not verified and user is not on product details page");
		}
	}
	//Method to retrieve first product information
	public void productinfo()
	{
		List<WebElement> Product_Info = driver.findElements(Product_Information);
		for(WebElement Product : Product_Info)
		{
			System.out.println(Product.getText());
			break;
		}
	}
	//Method to enter product in search
	public void enterSearchProduct(String value) throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Search).sendKeys(value);
	}
	//Method to click on search button
	public void clickOnSearchButton()
	{
		driver.findElement(Search_Button).click();
	}
	public void product()
	{
	         Actions action = new Actions(driver);
		 WebElement target = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/p"));
		 action.clickAndHold(target);
		 String Product1 = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/p")).getText();
		 System.out.println(Product1); 
		 
	//	 String Product2 = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/p")).getText();
	//	 System.out.println(Product2);
	}
	//Method to verify searched product
	public void verifySearchedProduct()
	{
		String ProductInfo = driver.findElement(Searched_Product).getText();
		System.out.println(ProductInfo);
	}
	//Method to scroll footer
	public void scrollToFooter()
	{
		try {
			WebElement Element1 = driver.findElement(By.xpath("//div[@class='footer-widget']/div/div/div[2]/div/h2"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", Element1);
			utility.takeScreenshot(driver);
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	//Method to verify subscription text
	public void verifySubscription()
	{
		String Subscription = driver.findElement(Subscription_Text).getText();
		System.out.println("Subscription is visible");
	}
	//Method to enter subscription email
	public void enterSubscriptionEmail(String value)
	{
		driver.findElement(Subscription_Email).sendKeys(value);
	}
	//Method to click on subscription button
	public void clickOnSubscriptionButton() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(Subscription_Button).click();
	}
	//Method to verify subscription success message
	public void verifySubscriptionMessage() throws IOException
	{
		String Subscription_Success = driver.findElement(Subscription_Message).getText();
		System.out.println(Subscription_Success);
		if(Subscription_Success.equalsIgnoreCase("You have been successfully subscribed!"))
		{
			System.out.println("Subscription success message is verified");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Subscription success message is not verified");
		}
	}
	//Method to verify searched product
	public void verifySearched_Product() throws IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(SearchedProduct));
		String searched_product = driver.findElement(SearchedProduct).getText();
		if(searched_product.equalsIgnoreCase("Searched Products"))
		{
			System.out.println("Searched product is verified");
			utility.takeScreenshot(driver);
		}
		else
		{
			System.out.println("Searched product is not verified");
		}
	}
	//Method to click on view product
	public void clickOnAllViewProduct()
	{
		int TotalProducts = driver.findElements(By.xpath("//div[@class='features_items']")).size();
		for(int i=2; i<=TotalProducts; i++)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(All_ViewProducts));
			driver.findElement(By.xpath("//div[@class='features_items']/div["+i+"]/div/div[2]/ul/li/a")).click();
		}
	}
	//Method to verify write your review is visible
	public void verifyReviewVisible() throws InterruptedException
	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(WriteReview));
		try {
			Thread.sleep(5000);
			WebElement Review = driver.findElement(By.xpath("//a[text()='Write Your Review']"));
			if(Review.getText().equalsIgnoreCase("Write Your Review"))
			{
				System.out.println("Review is visible");
				utility.takeScreenshot(driver);
			}
			else
			{
				System.out.println("Review is visible");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	//Method to enter review name
	public void enterReviewName(String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Review_Name));
		driver.findElement(Review_Name).sendKeys(value);
	}
	//Method to enter review name
	public void enterReviewEmail(String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Review_Email));
		driver.findElement(Review_Email).sendKeys(value);
	}
	//Method to enter review
	public void enterReview(String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Review_Text));
		driver.findElement(Review_Text).sendKeys(value);
	}
	//Method to enter review
	public void clickOnReviewSubmit()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Review_Button));
		driver.findElement(Review_Button).click();
	}
	//Method to enter review
	public void verifyReviewMessage()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Review_SuccessMessage));
			String review = driver.findElement(Review_SuccessMessage).getText();
			if(review.equalsIgnoreCase("Review_SuccessMessage"))
			{
				System.out.println("Review success message is verified");
				utility.takeScreenshot(driver);
			}
			else
			{
				System.out.println("Review success message is not verified");
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
}

