package com.w2a.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet  sheet;
	
	
	public ExcelReader(String excel)
	{
		try
		{
			fis = new FileInputStream(excel);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(0);
			fis.close();
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public String getdata(int sheetindex, int row, int column)
	{
		sheet = wb.getSheetAt(sheetindex);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int rowno(int sheetindex)
	{
		sheet = wb.getSheetAt(sheetindex);
		int row = sheet.getLastRowNum();
		row = row+1;
		return row;
	}
	public int columnno(int sheetindex)
	{
		sheet = wb.getSheetAt(sheetindex);
		int column = sheet.getRow(0).getLastCellNum();
		return column;
	}

}
