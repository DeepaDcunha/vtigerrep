package objpckge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vTigerCRM.genericLib.Base;
import com.vTigerCRM.genericLib.Utility;

public class Home {
	
	//Identify webelements
		@FindBy(xpath="//img[contains(@src,'user.PNG')]")
		private WebElement usericon;	
		
		@FindBy(linkText="Sign Out")
		private WebElement signout;
		
		@FindBy(linkText="Contacts")
		private WebElement contactlink;
		
		@FindBy(linkText="Products")
		private WebElement Productslink;

	public WebElement getProductslink() {
		return Productslink;
	}

	public WebElement getUsericon() {
		return usericon;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getContactlink() {
		return contactlink;
	}


	
	public void vTigerlogout() 
	{
	
		Utility.acts(Base.staticdriver, usericon);
		
		signout.click();
		
		
	}
	
}
