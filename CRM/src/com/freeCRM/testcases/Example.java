package com.freeCRM.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.freeCRM.util.Weblistener;

public class Example {
@Test
public void printvalues () throws IOException
{
	Properties prop=new Properties();
	FileInputStream fis =new FileInputStream("C:\\Users\\Mass\\eclipse-workspace\\CRM\\src\\com\\freeCRM\\config\\config.properties");
    prop.load(fis);
    String url =prop.getProperty("URL");
    System.out.println(url);
    
}
}
