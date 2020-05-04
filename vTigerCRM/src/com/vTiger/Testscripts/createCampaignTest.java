package com.vTiger.Testscripts;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vTigerCRM.genericLib.Base;
import com.vTigerCRM.genericLib.Utility;


	
	
	public class createCampaignTest extends Base
	{
		@Test
		public void createCampaign() throws EncryptedDocumentException, IOException
		{
			
		/*click on campaign*/
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.name("Campaigns")).click();
		if(driver.getTitle().contains("Campaigns"))
			
		{
			
			System.out.println("campaigns page is displayed");
			
		}
		
		else
		{
			System.out.println("campaigns page is not displayed");
			
		}
		
       /* click on create campaign*/
		
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
        /*Verify create campaign page*/
		
		String text=driver.findElement(By.xpath("//span[text()='Creating New Campaign']")).getText();
		  if(text.equals("Creating New Campaign"))
       
        {
        	System.out.println(" create campaign page displayed");
        }
        else
        {
        	System.out.println(" create campaign is not displayed");
        }
        
        /*Enter the details*/
        driver.findElement(By.name("campaignname")).sendKeys(lib.getExcelData("Sheet1", 1, 14));
        
        Utility.select(driver.findElement(By.name("campaignstatus")), lib.getExcelData("Sheet1", 1, 15));
        
        Utility.select(driver.findElement(By.name("campaigntype")), lib.getExcelData("Sheet1", 1, 16));
        
        /*Select product */
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> i = ids.iterator();
		String pid = i.next();
		String cid = i.next();
		driver.switchTo().window(cid);
		driver.findElement(By.linkText(lib.getExcelData("Sheet1", 1, 17))).click();
		driver.switchTo().window(pid);
		
		driver.findElement(By.name("budgetcost")).sendKeys(lib.getExcelData("Sheet1", 1, 18));
		
		driver.findElement(By.name("actualcost")).sendKeys(lib.getExcelData("Sheet1", 1, 19));
		
		WebElement  wb1=driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wb1.click();
		}
}
	




