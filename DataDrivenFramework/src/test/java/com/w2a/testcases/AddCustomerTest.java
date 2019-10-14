package com.w2a.testcases;

import com.w2a.base.TestBase;
//import com.w2a.utilities.ExcelReader;


import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProvider="getData")
	public void addcustomer(String firstName, String lastName, String postCode)
	{
		driver.findElement(By.xpath("//button[1][@class='btn btn-lg tab']")).click();
		driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		
		
	}

	@DataProvider(name="getData")
	public Object[][] getData()
	{
		//ExcelReader read = new ExcelReader(excel);
		int rows= excel.rowno(0);
		int columns= excel.columnno(0);
		Object [][] data = new Object[rows][columns];
		for (int i=1;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
			data[i-1][j]= excel.getdata(0, i, j);
			}
		}
		return data;
		
	}
}
