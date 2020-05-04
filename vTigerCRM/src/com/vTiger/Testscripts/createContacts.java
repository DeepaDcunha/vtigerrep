
	package com.vTiger.Testscripts;

	import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Set;

	import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.By;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vTigerCRM.genericLib.Base;
import com.vTigerCRM.genericLib.Utility;
	
@Listeners(com.vTigerCRM.genericLib.ListenersTS.class)
	public class createContacts extends Base
	{
		
		@Test
		
		public void createContactsTest() throws EncryptedDocumentException, IOException
		{
			
			/*Click on contacts*/
		  driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		  
		  
		 if (driver.getTitle().contains("Contacts"))
	     {
			 
			 		Reporter.log(" Contact page is displayed ---> PASS", true );
		}
		 else
		 {
			 Reporter.log("Contact page is not displayed--> FAIL", false);
		 }
		  
		 
		  
		 /*Click on add contact*/
		  driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		 
		  
		 /*Verify the create contact page*/
		  String text=driver.findElement(By.xpath("//span[text()='Creating New Contact']")).getText();
		  if(text.equals("Creating New Contact"))
		  {
			  
			  Reporter.log("Create contact page is displayed", true);
		  }
		  else
		  {
			  Reporter.log("Create contact page is not displayed", false);
		  }
		
		  Assert.assertTrue(false);
		  /*Fill in contact details*/
		  
		   Utility.select(driver.findElement(By.name("salutationtype")), lib.getExcelData("Sheet1", 1, 7));
		   
		   
		   /*Select firstname*/
		   driver.findElement(By.name("firstname")).sendKeys(lib.getExcelData("Sheet1", 1, 8));
		   
		   /*Select Lastname */
		   driver.findElement(By.name("lastname")).sendKeys(lib.getExcelData("Sheet1", 1, 9));
		   
		   /*Select mobile*/
		   driver.findElement(By.id("mobile")).sendKeys(lib.getExcelData("Sheet1", 1, 10));
		   
		   
		   /*Select organisation*/
		   driver.findElement(By.xpath("//img[@alt='Select']")).click();
		   Set<String> ids=driver.getWindowHandles();
		   Iterator<String> i=ids.iterator();
		   String pid=i.next();
		   String cid=i.next();
		   
		   driver.switchTo().window(cid);
		  
		   driver.findElement(By.linkText(lib.getExcelData("Sheet1", 1, 11))).click();
		   driver.switchTo().window(pid);
		   
		   /*add mailing street*/
	       driver.findElement(By.name("mailingstreet")).sendKeys(lib.getExcelData("Sheet1", 1, 12));
		   
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   		
			
		}

	}



