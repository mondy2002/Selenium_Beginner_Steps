package com.freeCRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.CRM.base.TestBase;

public class Testutils extends TestBase{

	public Testutils() throws IOException {
		super();
 
	}
	
	public static  void takepicture (String  name ) throws IOException
	{// that is how to take screenshot in selenium 
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
		FileUtils.copyFile(srcfile, new File("C:\\Users\\Mass\\eclipse-workspace\\CRM\\snapshots\\"+name+".png"));
	}
	public static Object [][] getdatafromexcel(String sheetname ) throws IOException
	{
		File file = new File ("c:\\CRM DATA.xlsx");
		FileInputStream fis = new FileInputStream(file);
		// the next lines are the apache io that will help us to read the sheet
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet =workbook.getSheet(sheetname);
    
        int rows =sheet.getLastRowNum();
        int columns =sheet.getRow(0).getLastCellNum();
        Object data[][]=new Object [rows][columns];
        for (int i=0;i<rows;i++)
        {
            for (int k=0;k<columns;k++)
            {
            	data[i][k]=sheet.getRow(i).getCell(k).toString();
            }

        	
        }
        workbook.close();

        return data;
	}

}
