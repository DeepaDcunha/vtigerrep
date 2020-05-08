package vtiger.maventest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import MavenObjectRepository.Contacts;

import vtiger.maventest.Base;

public class CreateContactTest extends Base {
		Contacts contacts;
		
		@Test
		public void createContactTest() throws EncryptedDocumentException, IOException
		{
			home.getContactlink().click();
			contacts=PageFactory.initElements(driver, Contacts.class);
			contacts.contactTest(lib.getExcelData("Contacts", 1, 0), lib.getExcelData("Contacts", 1, 1));
			
		}

}

