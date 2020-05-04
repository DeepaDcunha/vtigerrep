package com.vTiger.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.vTigerCRM.genericLib.Base;



	public class createVendor extends Base
	{
		@Test
		public void createVendorTest() throws EncryptedDocumentException, IOException
		{
			
		/*click on vendor*/
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.name("Vendors")).click();
		
		if(driver.getTitle().contains("Vendor"))
		
		{
			
			System.out.println("Vendor page is displayed");
			
		}
		
		else
		{
			System.out.println("Vendor page is not displayed");
			
		}
		
		
		/* click on create vendor*/
		
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		
		/*Verify create vendor page*/
		
		String txt = driver.findElement(By.xpath("//span[text()='Creating New Vendor']")).getText();
		if(txt.equals("Creating New Vendor"))
		
       
        {
        	System.out.println(" create vendor page displayed");
        }
        else
        {
        	System.out.println(" create vendor page is not displayed");
        }
		
        
        /*Enter the details*/
        driver.findElement(By.name("vendorname")).sendKeys(lib.getExcelData("Sheet1", 1, 13));
        
        /*Click on save*/
        WebElement  wb1=driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wb1.click();
        
        
		}
	}

