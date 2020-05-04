package com.vTigerCRM.genericLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.vTigerCRM.genericLib.Base;
/*
 * This class contains utility methods like select, actions.,switch to window etc
 */

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
		
	}


