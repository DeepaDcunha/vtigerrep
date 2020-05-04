package com.vTigerCRM.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	
	public FileLib lib = new FileLib();
	public WebDriver driver=null;
	public WebDriverWait wait=null;
	public static WebDriver staticdriver=null;
	
	@Parameters("browser")
	@BeforeClass
	public void ConfigBC(String browserName)

	{
		/*Launch the browser*/
		if (browserName.equals("chrome"))
		{
			
			driver= new ChromeDriver();
			staticdriver= driver;
			System.out.println(" Browser is launched successfully--> PASS");
			
		}
		else
		{
			driver= new FirefoxDriver();
			staticdriver= driver;
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
			driver.findElement(By.name("user_name")).sendKeys(lib.getPropertyKeyValue("username"));
			driver.findElement(By.name("user_password")).sendKeys(lib.getPropertyKeyValue("password"));
			driver.findElement(By.id("submitButton")).click();
			
			if (driver.getTitle().contains("vtiger CRM 5 - Commercial Open Source CRM")) 
			{
				System.out.println("Home page is displayed--> PASS");
				
			}
			else
			{
				System.out.println("Login is not not displayed--> FAIL");
			}
		}
		
		@AfterMethod
		public void configAM()
		{
			/*Sign out*/
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"))).perform();
			driver.findElement(By.linkText("Sign Out")).click();

			
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


