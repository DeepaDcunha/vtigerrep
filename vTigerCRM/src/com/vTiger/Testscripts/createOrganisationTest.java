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

public class createOrganisationTest  extends Base {

	
	
		@Test
		public void createOrganisation() throws EncryptedDocumentException, IOException
		{
			
		/*click on Organizations*/
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		if(driver.getTitle().contains("Organizations"))
			
		{
			
			System.out.println("Organizations page is displayed");
			
		}
		
		else
		{
			System.out.println("Organizations is not displayed");
			
		}
		
       /* click on create Organizations*/
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
        /*Verify create Organizations*/
		
		String txt = driver.findElement(By.xpath("//span[text()='Creating New Organization']")).getText();
		if(txt.equals("Creating New Organization"))
		
		
        {
        	System.out.println(" create Organizations page displayed");
        }
        else
        {
        	System.out.println(" create Organizations is not displayed");
        }
        
        /*Enter the details*/
        driver.findElement(By.name("accountname")).sendKeys(lib.getExcelData("Sheet1", 1, 20));
        
        
		driver.findElement(By.name("bill_street")).sendKeys(lib.getExcelData("Sheet1", 1, 21));
		
		driver.findElement(By.name("ship_street")).sendKeys(lib.getExcelData("Sheet1", 1, 22));
		
		WebElement  wb1=driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wb1.click();

		}
	}
	

