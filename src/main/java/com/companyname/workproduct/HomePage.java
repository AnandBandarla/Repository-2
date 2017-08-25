package com.companyname.workproduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends WebPage {
	
	HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Initialization of WebDriver
	
	public void openHomePage()
	{
		driver.get("http://staging.ridecell.us/bustracking/");
	}
	
	public void openSettings()
	{
		driver.findElement(By.id("menu-icon")).click();
	}
	
	public void navigateTonotifications()
	{
		driver.findElement(By.linkText("Notifications")).click();
	}

}
