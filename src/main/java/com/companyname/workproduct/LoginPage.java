package com.companyname.workproduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebPage{
	
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Login(String username, String password)
	{
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}
	
	public void CreateAcount(String email, String pasword, String confirmpassword)
	{
		driver.findElement(By.id("create-account-email")).sendKeys(email);
		driver.findElement(By.id("create-account-password")).sendKeys(pasword);
		driver.findElement(By.id("create-account-password-confirm")).sendKeys(pasword);
		driver.findElement(By.id("create-account-button")).click();
	}
	
	/*public void getMessageText()
	{
		String textMsg=driver.findElement(By.xpath("//*[contains(text(),'No active notifications')]")).getText();
		System.out.println(textMsg);
	}
	
	public void closeMessage()
	{
		driver.findElement(By.id("btn")).click();
	}*/

}
