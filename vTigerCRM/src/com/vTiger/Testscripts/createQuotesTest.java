package com.vTiger.Testscripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerCRM.genericLib.Base;
import com.vTigerCRM.genericLib.Utility;

public class createQuotesTest extends Base {

	
		
	@Test
	public void createQuotes() throws EncryptedDocumentException, IOException
	{
		
	
	/*click on quotes*/
	driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
	driver.findElement(By.name("Quotes")).click();
	if(driver.getTitle().contains("Quotes"))
		
	{
		
		System.out.println("Quotes page is displayed");
		
	}
	
	else
	{
		System.out.println("Quotes page is not displayed");
		
	}
	
	
	/* click on create quotes*/
	
	driver.findElement(By.xpath("//img[@alt='Create Quote...']")).click();
	
	/*Verify create quotes page*/
	String txt = driver.findElement(By.xpath("//span[text()='Creating New Quote']")).getText();
	if(txt.equals("Creating New Quote"))
   
    {
    	System.out.println(" Creating New Quote displayed");
    }
    else
    {
    	System.out.println(" Creating New Quote is not displayed");
    }
	
    
    /*Enter the details*/
    driver.findElement(By.name("subject")).sendKeys(lib.getExcelData("Sheet1", 1, 25));
    
    driver.findElement(By.xpath("//img[@alt='Select']")).click();
    Set<String> ids= driver.getWindowHandles();
    Iterator<String> i =ids.iterator();
    String pid=i.next();
    String cid=i.next();
    
    driver.switchTo().window(cid);
    driver.findElement(By.linkText(lib.getExcelData("Sheet1", 1, 26))).click();
    
    driver.switchTo().window(pid);
    
    /*select quote page*/
    Utility.select(driver.findElement(By.name("quotestage")), lib.getExcelData("Sheet1", 1, 27));
    
    /*Enter item details*/
    driver.findElement(By.id("searchIcon1")).click();
    Set<String> ids1 =driver.getWindowHandles();
    Iterator<String> i1= ids1.iterator();
    String pid1=i1.next();
    String cid1=i1.next();
    driver.switchTo().window(cid1);
    driver.findElement(By.linkText(lib.getExcelData("Sheet1", 1, 28))).click();
    driver.switchTo().window(pid1);
    
    /*Enter qtly*/
    driver.findElement(By.name("qty1")).sendKeys(lib.getExcelData("Sheet", 1, 29));
    
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    
    /*Enter list price*/
    driver.findElement(By.id("listPrice1")).sendKeys(lib.getExcelData("Sheet1", 1, 31));
    
    
    /*Click on save*/
    WebElement  wb1=driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
	wb1.click();
    

	
	}
	
	}


	