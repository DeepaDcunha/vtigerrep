package MavenObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import vtiger.maventest.Base;
import vtiger.maventest.Utility;

public class Products {
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductimg;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement Productname;
	
	@FindBy(xpath="//select[@name='productcategory']")
	private WebElement Productcategory;
	
    @FindBy(xpath="//input[@id='qtyinstock']")
    private WebElement quantityStock;
    
    @FindBy(xpath="//input[@name='unit_price']")
    private WebElement unitprice;
    
    @FindBy(xpath="//input[@type='file']")
    private WebElement ProductImage;
    
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
    
    
	
    
    //business logic
    public void Productapp(String pdname,String prodcatgry,String vendornme, String uprice ,String stock,String image)
    {
    	createProductimg.click();
    	Productname.sendKeys(pdname);
    	Utility.select(Productcategory, prodcatgry);
    	Utility.plusbutton(Base.staticdriver);
    	Utility.drivergetWindowHandling(Base.staticdriver, vendornme);
    	unitprice.sendKeys(uprice);
    	quantityStock.sendKeys(stock);
    	ProductImage.sendKeys(image);
    	saveButton.click();
    	
    	
    }
	

}
