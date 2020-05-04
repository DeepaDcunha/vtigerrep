package com.Testscripts;


	
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.Test;

	import com.vTigerCRM.genericLib.Base;

import objpckge.Products;

	public class ProductsTest extends Base{
		
		Products product;
		
		@Test
		public void productstest() throws EncryptedDocumentException, IOException
		{
		
			home.getProductslink().click();
			product=PageFactory.initElements(driver, Products.class);
	        product.Productapp(lib.getExcelData("Products", 1, 0), lib.getExcelData("Products", 1, 2), lib.getExcelData("Products", 1, 3), lib.getExcelData("Products", 1, 4), lib.getExcelData("Products", 1, 5), lib.getExcelData("Products", 1, 6));		
		}

	}


