package com.companyname.workproduct;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.companyname.workproduct.HomePage;
import com.companyname.workproduct.LoginPage;
import com.companyname.workproduct.NotificationsPage;

import static org.testng.Assert.*;

public class NotificationsTest {
	HomePage homepage;
	LoginPage loginpage;
	NotificationsPage notificationspage;
	
	@BeforeMethod()
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sabbavaram\\Downloads\\chromedriver_win32_new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		  homepage= new HomePage(driver);
		  loginpage= new LoginPage(driver);
		  notificationspage= new NotificationsPage(driver);
	}
	
@Test
  public void testNotification() {
	
	String timeStamp = new SimpleDateFormat("MMddHHmm").format(new java.util.Date());

	homepage.openHomePage();
	homepage.openSettings();
	homepage.navigateTonotifications();
	
	//loginpage.Login("praveenr.qa+05@gmail.com", "praveen");
	System.out.println("TIMESTAMP "+timeStamp);
	loginpage.CreateAcount("aband0406+"+timeStamp+"@gmail.com", "abcd123", "abcd123");
	/*loginpage.getMessageText();
	loginpage.closeMessage();*/
	
	
	String days[]={"monday","tuesday","friday"};
	String byCommunication[]={"email"};
	
	String defaultnotificationmsg=notificationspage.getNotificationMessage();
	assertEquals (defaultnotificationmsg, "No active notifications.");
	
	notificationspage.createNewNotification("10 minutes before","4098", days, byCommunication);
	
	notificationspage.closeConfirmationMessage();
	
	int notificationcount=notificationspage.getNotificationsCount();
	assertEquals (notificationcount,1);
  }
}
