package com.vTiger.Testscripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerCRM.genericLib.Base;
import com.vTigerCRM.genericLib.Utility;


	
		public class createOpportunityTest extends Base
		{
			@Test
			public void createOpportunity() throws EncryptedDocumentException, IOException
			{
				
			/*click on opportunity*/
			driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
			
			
			if(driver.getTitle().contains("Opportunities"))
				
			{
				
				System.out.println("Opportunities page is displayed");
				
			}
			
			else
			{
				System.out.println("Opportunities page is not displayed");
				
			}
			
	       /* click on create opportunity*/
			
			driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
			
	        /*Verify createopportunity page*/
			
			String txt = driver.findElement(By.xpath("//span[text()='Creating New Opportunity']")).getText();
			if(txt.equals("Creating New Opportunity"))
			
	        
	        {
	        	System.out.println(" Creating New Opportunity displayed");
	        }
	        else
	        {
	        	System.out.println(" Creating New Opportunity is not displayed");
	        }
	        
	        /*Enter the details*/
	        driver.findElement(By.name("potentialname")).sendKeys(lib.getExcelData("Sheet1", 1, 23));
	        
	        
	        /*Select product */
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
			
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> i = ids.iterator();
			String pid = i.next();
			String cid = i.next();
			driver.switchTo().window(cid);
			driver.findElement(By.linkText(lib.getExcelData("Sheet1", 1, 24))).click();
			driver.switchTo().window(pid);
			
			
			WebElement  wb1=driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
			wb1.click();
			}
	
		}
		


	
	
