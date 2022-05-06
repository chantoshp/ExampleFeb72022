package com.sgtesting.Assignments.Testng.p;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;


public class LoginLogoutClose 
{
	public static WebDriver oBrowser=null;
	@Test(priority = 0)
	private static void LanchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","E:\\Example\\ExampleAutomation1\\Web_Automation\\Library\\Drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 1)
	private static void Navigate()
	{
		try
		{
			oBrowser.get("http://localhost:81/login.do");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 2,dataProvider = "Credientials")
	private static void loginLogout(String user,String pwd)
	{
		try 
		{
			oBrowser.findElement(By.id("username")).sendKeys(user);
			oBrowser.findElement(By.name("pwd")).sendKeys(pwd);
			Thread.sleep(4000);
			oBrowser.findElement(By.xpath("//*[@id=\"loginButton\"]/div")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\"gettingStartedShortcutsPanelId\"]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("logoutLink")).click();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@DataProvider (name="Credientials")
	public Object[][] getLoginDetails()
	{
		return new Object[][] {{"admin","manager"},{"admin","manager"},{"admin","manager"}};
	}
	
	
	
	
	@Test(priority = 3)
	private static void CloseApplication()
	{
		try
		{
			oBrowser.quit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
