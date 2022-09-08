package com.CRM.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freeCRM.util.Weblistener;

import atu.testrecorder.ATUTestRecorder;

//import net.bytebuddy.implementation.bind.annotation.DefaultCall.Binder.DefaultMethodLocator.Implicit;
   


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static Weblistener weblistener;
	public static	ATUTestRecorder recorder;
	public  TestBase() throws IOException
	{
 		prop=new Properties();
 		FileInputStream fis =new FileInputStream("C:\\Users\\Mass\\eclipse-workspace\\CRM\\src\\com\\freeCRM\\config\\config.properties");
 		prop.load(fis);
  	}
	public  void initial(String browser)
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
	    System.setProperty("webdriver.chrome.driver", "C:\\browsers\\chromedriver.exe");
		   
			 driver =new ChromeDriver();
		}
		else 
		{
		      System.setProperty("webdriver.edge.driver", "C:\\browsers\\msedgedriver.exe");
			   driver =new EdgeDriver();
		}
		
			 e_driver =new EventFiringWebDriver (driver);
			 weblistener= new Weblistener();
			 e_driver.register(weblistener);
			 driver=e_driver;
			 driver.manage().window().maximize();
			 driver.get("https://classic.crmpro.com/index.html");
	
			
	}
	

}
