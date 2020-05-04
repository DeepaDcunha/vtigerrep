package com.vTiger.Testscripts;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vTigerCRM.genericLib.Base;
import com.vTigerCRM.genericLib.Utility;

public class createProductsTest extends Base{

		@Test
		public void createProduct() throws EncryptedDocumentException, IOException
		{
			/* Click on products */
			driver.findElement(By.linkText("Products")).click();
			
			/* Verify Products page */
			if(driver.getTitle().contains("Products"))
			{
				System.out.println("Products Page is displayed --> PASS");
			}
			else
			{
				System.out.println("Products Page not is displayed --> FAIL");
			}
			
			
			/* click on create products image */
			driver.findElement(By.xpath("//img[contains(@alt,'Create Product')]")).click();
			
			/*verify create product page */
			String txt = driver.findElement(By.xpath("//span[text()='Creating New Product']")).getText();
			if(txt.equals("Creating New Product"))
			{
				System.out.println("Create Product page is displayed --> PASS");
			}
			else
			{
				System.out.println("Create Product page is not displayed --> FAIL");
			}
			
			/* Fill product detials */	
			driver.findElement(By.name("productname")).sendKeys(lib.getExcelData("Sheet1", 1, 0));
			
			/* Select Manufacgturer*/
			
			Utility.select(driver.findElement(By.name("manufacturer")), lib.getExcelData("Sheet1", 1, 1));
			
			/* Select Product @category */
			
			Utility.select(driver.findElement(By.name("productcategory")), lib.getExcelData("Sheet1", 1, 2));
			
			/*Select Vendor */
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
			
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> i = ids.iterator();
			String pid = i.next();
			String cid = i.next();
			driver.switchTo().window(cid);
			driver.findElement(By.linkText(lib.getExcelData("Sheet1", 1, 3))).click();
			driver.switchTo().window(pid);
			
			/* Enter Qty in stock 
			 */
			
			driver.findElement(By.name("qtyinstock")).sendKeys(lib.getExcelData("Sheet1", 1, 4));
			
			/* Upload Image *
			 */
			
			driver.findElement(By.id("my_file_element")).sendKeys(lib.getExcelData("Sheet1", 1, 6));
			 
			 /* click on Save button */
			
		    WebElement  wb1=driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
				wb1.click();	
		}
	}


