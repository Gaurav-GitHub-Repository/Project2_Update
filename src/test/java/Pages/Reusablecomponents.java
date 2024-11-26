package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Reusablecomponents {

	public WebDriver driver1;
	
	
	public void takeScreenshot(WebDriver driver1) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver1;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\AutomationExercise\\screenshots\\TestCase.png");
		FileHandler.copy(source, target);
	}
	public void uploadFile() throws AWTException
	{
		  Robot robot = new Robot();
		  StringSelection file = new StringSelection("C:\\Users\\Gaurav\\Desktop\\Automation Testing Resume\\Picture.png");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null); 
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);	          
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver1;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	public void scrollToElement(WebDriver driver1)
	{
		WebElement Element = driver1.findElement(By.xpath("//div[@class='brands_products']/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver1;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	public void clickOnElement()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver1;
		js.executeScript("arguments[0].click();", "Element");
	}
/*	public void scrollToElement(WebElement Element2)
	{
		WebElement Element2 = driver1.findElement(By.xpath("//div[@class='footer-widget']/div/div/div[2]/div/h2"));
		JavascriptExecutor js = (JavascriptExecutor)driver1;
		js.executeScript("arguments[0].scrollIntoView();", "Element");
	} */
}
