package Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class utility implements ITestListener{

	WebDriver driver;
	
	public void onTestStart(ITestResult result)
	{
		if(result.getStatus()==result.STARTED)
		{
			System.out.println("onTestStart is passed");
		}
		else
		{
			System.out.println("onTestStart is failed");
		}
	}
	public void onTestSuccess(ITestResult result)
	{
		if(result.getStatus()==result.SUCCESS)
		{
			System.out.println("onTestSuccess is passed");
		}
		else
		{
			System.out.println("onTestSuccess is failed");
		}
	}
	public void onTestFailure(ITestResult result)
	{
		if(result.getStatus()==result.FAILURE)
		{
			System.out.println("onTestFailure is passed");
		}
		else
		{
			try {
				System.out.println("onTestFailure is failed");
				TakesScreenshot screenshot = (TakesScreenshot)driver;
				File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);
				File targetfile = new File("C:\\Eclipse-Selenium 13-07-2024\\eclipse-java\\Selenium\\screenshots\\TestCase.png");
				FileUtils.copyFile(sourcefile, targetfile);
			} catch (IOException e)
			{
				e.printStackTrace();
			}			
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		if(result.getStatus()==result.SKIP)
		{
			System.out.println("onTestSkipped is passed");
		}
		else
		{
			System.out.println("onTestSkipped is failed");
		}
	}
}
