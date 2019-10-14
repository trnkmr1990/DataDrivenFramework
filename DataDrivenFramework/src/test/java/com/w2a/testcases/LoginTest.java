package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class LoginTest extends TestBase {


	@Test
	public void loginAsBankManager() throws InterruptedException
	{
		log.debug("Inside Login Test");
		driver.findElement(By.xpath(OR.getProperty("bmlbtn"))).click();
		//Assertion used for verification
		Assert.assertTrue(IsElementpresent(By.xpath(OR.getProperty("addcustomerbtn"))),"Login not successful");
		Thread.sleep(3000);
		log.debug("Login Successfull");
	}

	

}
