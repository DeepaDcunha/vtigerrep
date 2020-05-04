package objpckge;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login
{
	
	//Identify WebElements
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	//generate getter methods

	public WebElement getUsernameTF() 
	{
		return usernameTF;
	}

	public WebElement getPasswordTF() 
	{
		return passwordTF;
	}


	public WebElement getLoginbutton() 
	{
		return loginbutton;
	}
	
	//Business logic
	public void vTigerLogin(String username,String password)
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginbutton.click();
		
	}
	
}
