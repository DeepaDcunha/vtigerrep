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


	
public class createSalesTest extends Base{
	
	@Test
 public void createSales() throws EncryptedDocumentException, IOException
 {
	
	/*click on sales*/
	driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
	driver.findElement(By.name("Sales Order")).click();
	
	
	 if (driver.getTitle().contains("Sales Order"))
     {
		 
		 		System.out.println(" Sales Order page is displayed ---> PASS ");
	}
	 else
	 {
		 System.out.println("Sales Order page is not displayed--> FAIL");
	 }
	  
	 
	 
	 
	  
	 /*Click on add sales*/
	  driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
	  
	  
	 /*Verify the create contact page*/
	  String text=driver.findElement(By.xpath("//span[text()='Creating New Sales Order']")).getText();
	  if(text.equals("Creating New Sales Order"))
	  {
		  
		  System.out.println("Creating New Sales Order page is displayed");
	  }
	  else
	  {
		  System.out.println("Creating New Sales Orderpage is not displayed");
	  }
	
	
	  /*Fill in contact details*/
	  

	   
	   
	   /*Select firstname*/
	   driver.findElement(By.name("subject")).sendKeys(lib.getExcelData("Sheet1", 1, 32));
	   
	   /*Select Lastname */
	   
	   driver.findElement(By.xpath("//img[@alt='Select']")).click();
	   Set<String> ids=driver.getWindowHandles();
	   Iterator<String> i=ids.iterator();
	   String pid=i.next();
	   String cid=i.next();
	   
	   driver.switchTo().window(cid);
	  
	   driver.findElement(By.linkText(lib.getExcelData("Sheet1", 1, 26))).click();
	   driver.switchTo().window(pid);
	
	   
	   /*Select organisation*/
	   driver.findElement(By.xpath("(//img[@alt='Select'])[2]")).click();
	   Set<String> ids1=driver.getWindowHandles();
	   Iterator<String> i1=ids1.iterator();
	   String pid1=i1.next();
	   String cid1=i1.next();
	   
	   driver.switchTo().window(cid1);
	   
	   driver.findElement(By.linkText(lib.getExcelData("Sheet1", 1, 33))).click();
	   
	   driver.switchTo().window(pid1);
	   
	   /*Enter item details*/
	    driver.findElement(By.id("searchIcon1")).click();
	    Set<String> ids2 =driver.getWindowHandles();
	    Iterator<String> i2= ids2.iterator();
	    String pid2=i2.next();
	    String cid2=i2.next();
	    driver.switchTo().window(cid2);
	    driver.findElement(By.linkText(lib.getExcelData("Sheet1", 1, 28))).click();
	    driver.switchTo().window(pid2);
	   

	   
	   driver.findElement(By.name("qty1")).sendKeys(lib.getExcelData("Sheet", 1, 29));
	  
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   
	    /*Enter list price*/
	    driver.findElement(By.id("listPrice1")).sendKeys(lib.getExcelData("Sheet1", 1, 31));
	    
	    
	    /*Click on save*/
	    WebElement  wb1=driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		wb1.click();

	   
	   
	   
	   
	   		
		
	}

}




