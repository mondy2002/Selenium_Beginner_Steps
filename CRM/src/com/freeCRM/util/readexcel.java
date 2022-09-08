package com.freeCRM.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexcel {

	public static void main(String[] args) throws Exception {
		
		File file = new File ("c:\\CRM DATA.xlsx");
		FileInputStream fis = new FileInputStream(file);
		// the next lines are the apache io that will help us to read the sheet
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet =workbook.getSheet("contact page ");
		String firstname = sheet.getRow(1).getCell(0).toString();
        System.out.println(firstname);
        workbook.close();
        int rows =sheet.getLastRowNum();
        int cells =sheet.getRow(0).getLastCellNum();
        Object data[][]=new Object [rows][cells];
        for (int i=0;i<rows;i++)
        {
            for (int k=0;i<cells;i++)
            {
            	data[i][k]=sheet.getRow(i).getCell(k);
            }

        	
        }

        
	}

}
