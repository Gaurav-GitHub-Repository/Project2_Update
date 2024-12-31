package Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Dashboard4  {

	Reusablecomponents utility = new Reusablecomponents();
	
	static WebDriver driver;
	
	//Constructor to assign driver
	public Dashboard4(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement for products
	@FindBy(linkText="/view_cart")
	@CacheLookup
	private By Cart;

	//WebElement to click on products
	@FindBy(xpath="//ul[@class='nav navbar-nav']/li[2]/a")
	@CacheLookup
	private By Products;
	
	//WebElement for list of brand products
	@FindBy(xpath="//div[@class='single-products']/div[2]/div/a")
	@CacheLookup
	private By Product1_AddToCart;
	
	//WebElement for searched product
	@FindBy(xpath="//input[@name='search' and @id='search_product']")
	@CacheLookup
	private By Searched;
	
	//WebElement to click on search button
	@FindBy(css="button#submit_search")
	@CacheLookup
	private By Search_Btn;

	//WebElement of view product for the searched product
	@FindBy(xpath="//a[@href='/product_details/30']")
	@CacheLookup
	private By Searched_ViewProduct;

	//WebElement for searched product information details
	@FindBy(css="product-details")
	@CacheLookup
	private By Searched_ProductInfo;
	
	//WebElement for add to cart button
	@FindBy(xpath="//button[@type='button'and @class='btn btn-default cart']")
	@CacheLookup
	private By Add_To_Cart;

	//WebElement for view cart link button
	@FindBy(xpath="//a[@href='/view_cart']/u")
	@CacheLookup
	private By View_Cart;
	
	//WebElement for quantity checkout
	@FindBy(xpath="//div[@id='cart_info']/table/tbody/tr/td[4]")
	@CacheLookup
	private By Quantity_ProductDetails;

	//Webelement for quantity in checkout
	@FindBy(xpath="//table[@id='cart_info_table']/tbody/tr/td[4]")
	@CacheLookup
	private By Quantity_Checkout;
	
	//WebElement for recommended items text
	@FindBy(xpath="//div[@class='recommended_items']/h2")
	@CacheLookup
	private By Recommended_Items;
	
	//WebElement to click on view cart
	@FindBy(xpath="//div[@class='modal-content']/div[2]/p[2]/a")
	@CacheLookup
	private By view_cart;

	
	//Method to click on cart button
	public void clickOnCart() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Cart));
		driver.findElement(Cart).click();
	}
	//Method to click on products
	public void clickOnProducts() throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Products));
		//Thread.sleep(5000);
		driver.findElement(Products).click();
		//Assert.assertTrue(true);
	}
	//Method to scroll
	public void scroll()
	{
		utility.scroll();
	}
	//Method for page load timeout
	public void pageload()
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	//Method to click on product1 add to cart
	public void clickOnAddToCartProduct() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement wait = driver.findElement(By.xpath("//div[@class='features_items']/div[2]/div/div/div[2]"));
		action.clickAndHold(wait).build().perform();
		WebElement Product = driver.findElement(By.xpath("//a[text()='Add to cart']"));
		action.click(Product).build().perform();
	}
	//Method to click on shopping button
	public void clickOnShoppingButton() throws InterruptedException
	{
		//By Shopping_Button = By.xpath("//button[text()='Continue Shopping']");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Cart));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
	}
	//Method to click on product2 add to cart
	public void clickOnAddToCartProduct2() throws InterruptedException
	{
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement wait = driver.findElement(By.xpath("//div[@class='features_items']/div[3]/div/div/div/div/h2"));
		action.clickAndHold(wait).build().perform();
		WebElement Product = driver.findElement(By.xpath("//a[@data-product-id='2']"));
		action.click(Product).build().perform();
	}
	//Method to click on view cart
	public void clickOnViewCart() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/view_cart']/u")).click();
	}
	//Method to click on view product
	public void clickOnViewProduct1() throws InterruptedException
	{
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
	}
	//Method to verify product details page
	public void verifyProductDetails()
	{
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Product Details");
	}
	//Method to click on quantity
/*	public void clickOnQty()
	{
		int i=1;
		while(i>=1)
		{
	    	driver.findElement(By.xpath("//input[@id='quantity' or value='1']")).click();
	    	if(i==4)
	    	{
	    		break;
	    	}
		}
	} */
	//Method to search product
	public void searchProduct(String value)
	{
		driver.findElement(Searched).sendKeys(value);
	}
	//Method to click on search button
	public void ClickOnSearchedButton()
	{
		driver.findElement(Search_Btn).click();
	}
	//Method to click on view product of the searched product
	public void clickOnSearchedViewProduct()
	{
		//driver.findElement(Searched_ViewProduct).click();
		WebElement element = driver.findElement(By.xpath("//a[@href='/product_details/30']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeAsyncScript("arguments[0].click();", element);
	}
	//Method to retrieve product information details
	public void productinfo()
	{
		int i=1;
		while(i<=5)
		{
			try
			{
				String ProductInfo = driver.findElement(Searched_ProductInfo).getText();
				System.out.println(ProductInfo);
			}
			catch(StaleElementReferenceException e)
			{
				System.out.println("StaleElementReferenceException Occured");
			}
			i++;
		}
	}
	//Method to verify header in product table
	public void verifyProductHeader()
	{
		int i=2;
		int header_count = driver.findElements(By.xpath("//div[@id='cart_info']/table/thead/tr")).size();
		while(i<=5)
		{
			String header_name = driver.findElement(By.xpath("//div[@id='cart_info']/table/thead/tr/td["+i+"]")).getText();
			System.out.println(header_name);
			i++;
		}
	}
	//Method to verify product details
	public void verifyCheckoutProductDetails()
	{
		//int i=2;
		int Product1 = driver.findElements(By.xpath("//div[@id='cart_info']/table/tbody/tr[1]")).size();
		int Product2 = driver.findElements(By.xpath("//div[@id='cart_info']/table/tbody/tr[2]")).size();
		for(int i=2; i<=Product1; i++)
		{
			String ProductOne = driver.findElement(By.xpath("//div[@id='cart_info']/table/tbody/tr[1]/td["+i+"]")).getText();
			System.out.println(ProductOne);
			if(i==5)
			{
				for(int j=1; j<=Product2; j++)
				{
				String ProductTwo = driver.findElement(By.xpath("//div[@id='cart_info']/table/tbody/tr[2]/td["+j+"]")).getText();
				System.out.println(ProductTwo);
			//	break;
				}
			} 
/*			List<WebElement> ProductOne = driver.findElements(By.xpath("//div[@id='cart_info']/table/tbody/tr[1]"));
			for(WebElement ProductInfoOne : ProductOne)
			{
				System.out.println(ProductInfoOne.getText());
				break;
			} */
		}    
	}
	public void verifyDynamicTable()
	{
		List<WebElement> table = driver.findElements(By.xpath("//table[@id='taskTable']"));
		for(WebElement DynamicTable : table)
		{
			System.out.println(DynamicTable.getText());
		}
	}
	//Method to increase quantity
	public void increaseQuantity(String value)
	{
		int i=1;
		while(i<=4)
		{
			driver.findElement(By.xpath("//input[@name='quantity'and @id='quantity']")).click();
			i++;
		} 
	}
	//Method to click on add to cart button
	public void cartButton() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Add_To_Cart).click();
	}
	//Method to click on view cart link
	public void clickOnViewCartLink() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(View_Cart).click();
	}
	//Method to verify product is added to the checkout page
	public void verifyCheckout()
	{
		Assert.assertEquals(driver.getTitle(), "Automation Exercise - Checkout");
	}
	//Method to verify quantity in checkout page
	public void verifyQuantityCheckout()
	{
		if(driver.findElement(Quantity_ProductDetails).getText().equalsIgnoreCase("4"))
		{
			String Quantity_ProductDetails = driver.findElement(By.xpath("//div[@id='cart_info']/table/tbody/tr/td[4]")).getText();
			System.out.println(Quantity_ProductDetails + " " + "Quantity in checkout is verified");
		}
		else
		{
			System.out.println("Quantity in checkout is invalid");
		}
	}
	//Method to scroll to the footer element
	public void scrollToFooter()
	{
		WebElement element = driver.findElement(By.xpath("//div[@class='recommended_items']/h2"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	//Method to verify recommended items
	public void verifyRecommendedItems()
	{
		String RecommendedItems = driver.findElement(Recommended_Items).getText();
		if(RecommendedItems.equalsIgnoreCase("recommended items"))
		{
			System.out.println("Recommended items are visible");
		}
		else
		{
			System.out.println("Recommended items are not visible");
		}
	}
	//Method to add recommended items
	public void addRecommendedProducts() throws InterruptedException
	{
		int TotalRecommendedProducts = driver.findElements(By.xpath("//div[@class='recommended_items']")).size();
		for(int i=1; i<=TotalRecommendedProducts; i++)
		{
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			WebElement wait = driver.findElement(By.xpath("//div[@class='recommended_items']/div/div/div[2]/div["+i+"]/div/div/div/img[1]"));
			action.clickAndHold(wait).build().perform();
			WebElement Product = driver.findElement(By.xpath("//div[@class='recommended_items']/div/div/div/div["+i+"]/div/div/div/a"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",Product);
			//WebDriverWait button = new WebDriverWait(driver, Duration.ofSeconds(60));
			//button.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Shopping_Button));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
		}
	}
	//Method to click on view cart
	public void clickOnModalViewCart()
	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(view_cart));
		try {
		WebElement Product = driver.findElement(By.xpath("//div[@class='modal-content']/div[2]/p[2]/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Product);
		}
		catch(ElementNotInteractableException e)
		{
			System.out.println("ElementNotInteractableException exception occured");
		}
	}
}
