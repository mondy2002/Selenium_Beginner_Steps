package com.freeCRM.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CRM.base.TestBase;
import com.freeCRM.util.Testutils;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class LoginPageTest extends TestBase {
	//sanity:1
	//Regression:1
	//E2E:4
	//then the total in test suite is 
	//sanity:2
		//Regression:2
	public LoginPageTest() throws IOException
	{
		super();
	}
	 
	@Parameters({"browser"})
	@BeforeMethod()
	// you have to solve the proplem ofd passing Method = method as parameter to solve the screen shots and videos naming 
	public void setup( String browser ) throws ATUTestRecorderException
	{
		initial(browser);	
		//that is how we make screen record for all tests
		recorder = new ATUTestRecorder("C:\\Users\\Mass\\eclipse-workspace\\CRM\\videos","login test",false);
 		recorder.start();
	}
	@AfterMethod( )
	public void teardown() throws ATUTestRecorderException
	{
		recorder.stop();
		driver.quit();

	}
@Test(priority=1 )
public void titletest( ) throws IOException {

	System.out.println(driver.getTitle());
	AssertJUnit.assertEquals("mondy", "mondy", "it was failed cause the excepected result was mondy ");
 
}
@Test(priority=2 )
public void validateurl() throws IOException {

	String Actualresult ="https://classic.crmpro.com/index.html";
	String Expectedresult =driver.getCurrentUrl();
	System.out.println(Expectedresult);
	SoftAssert softassert =new SoftAssert();
	AssertJUnit.assertEquals("mondy","mondy","it will be an error");
	
   //Assert.assertEquals(Actualresult, Expectedresult);// hard assertion
	// if we use soft assert it will complete the code and prints easly even if the assert is false 
	//but hard assertion will not do that amd will not complete the code
	System.out.println("i love testing");
	//then you should use assert all cause if the assertion fails it will not make the test case fails with 
    // out this assertall
	softassert.assertAll();
    
    
}
@Test(priority=3 )
public void logotest( ) throws IOException {
 
	WebElement logo = driver.findElement(By.xpath("//img[@src='https://classic.freecrm.com/img/logo.png']"));
	boolean Actualresult =true;
	boolean Expectedresult =logo.isDisplayed();
	System.out.println(Expectedresult);
	   AssertJUnit.assertEquals(Actualresult, Expectedresult);
 
 
}
@Test(priority=4)
public void logintest( ) throws IOException, ATUTestRecorderException {
		ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\Mass\\eclipse-workspace\\CRM\\videos","logintest",false);
		recorder.start();
 
	WebElement 	Username =driver.findElement(By.name("username"));
	WebElement Password =driver.findElement(By.name("password"));
	WebElement loginbutton =driver.findElement(By.xpath("//input[@value='Login']"));
    Username.sendKeys("mondy1");
    Password.sendKeys("123456");
    loginbutton.click();
    String Expectedresult="CRMPRO";
    String Actualresult=driver.getTitle();
    AssertJUnit.assertEquals(Actualresult, Expectedresult);
	recorder.stop();

}
//@before class will execute onetime before the all class
@BeforeClass
public void before()
{
System.out.println("i will execute first");

}
//@after class will execute onetime after the all class

@AfterClass
public void after()
{
System.out.println("i will execute last");

}
//@before and after test will be executes before and after any test in the test suite that includes that test that has
//the before and after test annotations 
@BeforeTest
public void beforetest()
{
	
System.out.println("i will execute before any test in test suite that exxists in testng.xml");
}

@AfterTest
public void aftertest()
{
	
System.out.println("i will execute after any test in test suite that exxists in testng.xml");
}

@BeforeSuite
public void beforeSuite()
{
	
System.out.println("i will execute before any test suite that exxists in testng.xml");
}

@AfterSuite
public void afterSuite()
{
	
System.out.println("i will execute after any suite that exxists in testng.xml");
}

//@DataProvider
//public Object[][] mydata()
//{
//	Object [][]data=new Object[4][2];
//	data[0][0]="mondy1";
//	data[0][1]="123456";
//	data[1][0]="mondy";
//	data[1][1]="123456";
//	data[2][0]="mondy1";
//	data[2][1]="12345";
//	data[3][0]="mondy";
//	data[3][1]="12345";
//	return data;
//}







}
