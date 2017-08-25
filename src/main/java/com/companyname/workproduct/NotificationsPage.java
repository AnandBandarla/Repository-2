package com.companyname.workproduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class NotificationsPage extends WebPage {
	
	NotificationsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getNotificationMessage()
	{
		String notifyMsg = driver.findElement(By.xpath("//div[@id='notifications-list-container']/div")).getText();
		System.out.println(notifyMsg);
		return (notifyMsg);
	}
	
	public void createNewNotification(String notify, String stoptime, String[] days, String[] byCommunication)
	{
		driver.findElement(By.className("new-notification")).click();
		
		driver.findElement(By.xpath("//div[@data-route-id='northside']")).click();
		
		driver.findElement(By.xpath("//div[@data-stop-id='warrenhall']")).click();
				
		Select notify1 = new Select(driver.findElement(By.id("notify-before")));
		notify1.selectByVisibleText(notify);
		
		Select stoptime1 = new Select(driver.findElement(By.id("stop-time")));
		stoptime1.selectByValue(stoptime);
		
		for (int i=0;i<days.length;i++)
		{
			driver.findElement(By.id(days[i].toLowerCase())).click();
		}
		
		for (int j=0;j<byCommunication.length;j++)
		{
			driver.findElement(By.id(byCommunication[j].toLowerCase())).click();

		}
		
		driver.findElement(By.linkText("Create Notification")).click();		
		
	}
	
	public void closeConfirmationMessage() 
	{
		
		driver.findElement(By.xpath("//*[contains(text(),'OK')]")).click();
		
		/*
		 * try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("div.sweet-alert > div.confirm")).click();
		*/
	}
	
	public int getNotificationsCount()
	{
		return(driver.findElements(By.xpath("//div[@id='notifications-list-container']/div[@class='notification-row-wrapper']")).size());
	}
	
}
