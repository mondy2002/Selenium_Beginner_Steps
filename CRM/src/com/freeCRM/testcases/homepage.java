package com.freeCRM.testcases;

import java.io.File;
import java.io.IOException;
import com.freeCRM.util.Testutils;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.CRM.base.TestBase;
import com.beust.jcommander.Parameter;
import com.freeCRM.util.Testutils;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class homepage extends TestBase{
 	//sanity:1
		//Regression:1
		//E2E:2
	public  homepage()throws IOException
	{
		super();
	}
 	 
	@Parameters({"browser"})

	@BeforeMethod()
	public void login( String browser) throws ATUTestRecorderException
	{
		initial(browser);	
		recorder = new ATUTestRecorder("C:\\Users\\Mass\\eclipse-workspace\\CRM\\videos","login test",false);
 		recorder.start();
		WebElement username =driver.findElement(By.name("username"));
		WebElement password =driver.findElement(By.name("password"));
		WebElement loginbutton =driver.findElement(By.xpath("//input[@value='Login']"));
	    username.sendKeys("mondy1");
	    password.sendKeys("123456");
	    loginbutton.click();
	    String Expectedresult="CRMPRO";
	    String Actualresult=driver.getTitle();
	    Assert.assertEquals(Actualresult, Expectedresult);
	    

	}
	
	@AfterMethod( )
	public void close () throws ATUTestRecorderException
	{
		recorder.stop();
		driver.quit();
	}
	@Test(priority =5 )//we can use enabled=false if we dont want to run this test 
     public void clikoncontacts ( ) throws IOException
     {
		driver.switchTo().frame("mainpanel");
		 WebElement  contacts =driver.findElement(By.xpath("//a[text()='Contacts']"));
		 contacts.click();
		 //i did not need to switch cause they are in the same frame 
		 WebElement status  =driver.findElement(By.xpath("//*[text()='Status']"));
         boolean expectedresult =status.isDisplayed();
         Assert.assertTrue(expectedresult,"the status is not displayed ");
         File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
 		 FileUtils.copyFile(srcfile, new File("C:\\Users\\Mass\\eclipse-workspace\\CRM\\snapshots\\clikoncontacts.png"));
     }
	

	
	@Test(priority =6)
    public void clikondeals ( ) throws IOException
    {
		driver.switchTo().frame("mainpanel");
		 WebElement  contacts =driver.findElement(By.xpath("//*[text()='Deals']"));
		 contacts.click();
		 WebElement status  =driver.findElement(By.xpath("//*[text()='Keyword']"));
        boolean expectedresult =status.isDisplayed();
        Assert.assertTrue(expectedresult,"the keyword label  is not displayed ");
        
 
    }
	@Test(priority =7 )
    public void clikonTasks ( ) throws IOException
    {
		driver.switchTo().frame("mainpanel");
		 WebElement  contacts =driver.findElement(By.xpath("//*[text()='Tasks']"));
		 contacts.click();
		 WebElement status  =driver.findElement(By.xpath("//*[text()='Keyword']"));
        boolean expectedresult =status.isDisplayed();
        Assert.assertTrue(expectedresult,"the keyword label is not displayed ");
 
    }
	
	
	
	
}
