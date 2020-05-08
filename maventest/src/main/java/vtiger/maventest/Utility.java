package vtiger.maventest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {

	

		public static final long IMPLICIT_WAIT = 20; 
		public static final long EXPLICIT_WAIT = 20; 
		/*
		 * This method is used to select an option by value from Select dropdown
		 * @param element
		 *@param value
		 */
		public static void select(WebElement element, String value)
		{
			Select sel=new Select(element);
			sel.selectByValue(value);
		}
		
		public static void acts(WebDriver driver, WebElement we)
		{
			Actions a=new Actions(driver);
			a.moveToElement(we).perform();
			
		}
		
		public static void plusbutton(WebDriver driver)
		{
			driver.findElement(By.xpath("//img[@alt='Select']")).click();
		}
		
		public static void drivergetWindowHandling(WebDriver driver,String s)
		
		{
			Set<String> ids=driver.getWindowHandles();
			Iterator<String> i=ids.iterator();
			String pid=i.next();
			String cid=i.next();
			
			driver.switchTo().window(cid);
			
			driver.findElement(By.linkText(s)).click();
			
			driver.switchTo().window(pid);
					
			
			
		}
		
	}




