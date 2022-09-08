package com.freeCRM.testcases;

import java.io.IOException;
import org.testng.annotations.Parameters;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.base.TestBase;
import com.beust.jcommander.Parameter;
import com.freeCRM.util.Testutils;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ContactPage extends TestBase {

	public ContactPage() throws IOException {
		super();
		
	}
	
	
	@Parameters({"browser"})

	
	
 	@BeforeMethod()
	public void setup( String browser)
	{
		initial(browser);		 
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
		driver.quit();

		recorder.stop();
		
	}
	@Test(dataProvider="testdata")
	public void addcontacts (String first,String last,String comp,String depart)
	{
		driver.switchTo().frame("mainpanel");
		 WebElement  contacts =driver.findElement(By.xpath("//a[text()='Contacts']"));
		 Actions action =new Actions (driver);
		 action .moveToElement(contacts).build().perform();
		 WebElement  NewContact =driver.findElement(By.xpath("//a[text()='New Contact']"));
		 NewContact.click();

		 WebElement  firstname =driver.findElement(By.id("first_name"));
		 WebElement  lastname =driver.findElement(By.id("surname"));
		 WebElement  company =driver.findElement(By.name("client_lookup"));
		 WebElement  department =driver.findElement(By.id("department"));
		 firstname.sendKeys(first);
		 lastname.sendKeys(last);
		 company.sendKeys(comp);
		 department.sendKeys(depart);
		 WebElement  save  =driver.findElement(By.xpath("//input[@value='Save']"));
		 save.click();		 
		 
	}
	
	@DataProvider
	public Object [][] testdata() throws Throwable 
	{
		Object data[][]=Testutils.getdatafromexcel("contact page ");
		return data;
		}
	

}
