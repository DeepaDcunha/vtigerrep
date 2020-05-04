package objpckge;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contacts {
	
	public WebElement getCreatecontactImg() {
		return createcontactImg;
	}

	public WebElement getFirstnameTF() {
		return FirstnameTF;
	}

	public WebElement getLastnameTF() {
		return LastnameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createcontactImg;
	
	@FindBy(name="firstname")
	private WebElement FirstnameTF;
	
	
	@FindBy(name="lastname")
	private WebElement LastnameTF;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//Business Login to create contact
	public void contactTest(String firstname, String lastname)
	{
		createcontactImg.click();
		FirstnameTF.sendKeys(firstname);
		LastnameTF.sendKeys(lastname);
		saveButton.click();
		
		
	}


}
