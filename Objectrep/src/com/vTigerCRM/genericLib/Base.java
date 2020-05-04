package com.vTigerCRM.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import objpckge.Home;
import objpckge.Login;

public class Base {

        public FileLib lib = new FileLib();
		public WebDriver driver=null;
		public WebDriverWait wait=null;
		public static WebDriver staticdriver;
		public Login login;
		public Home home;
		
		@BeforeClass
		public void ConfigBC()

		{
			/*Launch the browser*/
			if (lib.getPropertyKeyValue("browser").equals("chrome"))
			{
				
				driver= new ChromeDriver();
				staticdriver = driver;
				System.out.println(" Browser is launched successfully--> PASS");
				
			}
			else
			{
				 driver= new FirefoxDriver();
				staticdriver = driver;
				System.out.println(" Browser is launched successfully--> PASS");
				
			}
			
			/*maximize the browser*/
			driver.manage().window().maximize();
			/*Launch the URL*/
			driver.get(lib.getPropertyKeyValue("url"));
			/*Wait statements*/
			driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT,TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,Utility.EXPLICIT_WAIT);
			
			if (driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM")) 
			{
				System.out.println("Login page is displayed--> PASS");
				
			}
			else
			{
				System.out.println("Login page is not displayed--> FAIL");
			}
			
		}
		
			@BeforeMethod
			
			public void ConfigBM()
			{
				/*Verify the login page*/
				login= PageFactory.initElements(driver,Login.class);
				login.vTigerLogin(lib.getPropertyKeyValue("username"),lib.getPropertyKeyValue("password"));
				
				if (driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM")) 
				{
					System.out.println("Home page is displayed--> PASS");
					
				}
				else
				{
					System.out.println("Home is not not displayed--> FAIL");
				}
				home= PageFactory.initElements(driver, Home.class);
			}
			
			@AfterMethod
			public void configAM()
			{
				/*Sign out*/
				

			     home.vTigerlogout();	
				if (driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM")) 
				{
					System.out.println("Logout is successful--> PASS");
					
				}
				else
				{
					System.out.println("Login page is not successful--> FAIL");
				}
			}
			
			@AfterClass
			public void configAC()
			{
				/*Close the browser
				 */
				driver.quit();
				System.out.println(driver);
				if(driver==null)
				{
					System.out.println("browser is closed successfully--> PASS");
					
				}
				else
				{
					
					System.out.println("Browser is not clsoed successfylly--FAIL");
				}
				
				
			}
			
			
			
		}


