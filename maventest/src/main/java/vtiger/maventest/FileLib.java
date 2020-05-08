package vtiger.maventest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {


		
		public String getPropertyKeyValue(String key)
		{
			Properties prop=null;
			try {
				
			
			FileInputStream ip=new FileInputStream("./com\\MavenTestdata\\com.properties");
			prop= new Properties();
			prop.load(ip);
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				
			}
			return prop.getProperty(key);
			
		}
		
		
		public String getExcelData(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
		{
			
			/**
			 * This method is used to read the data from excel file
			 * @param sheetName
			 * @param rowIndex
			 * @param cellIndex
			 * @return String
			**/
			
			Sheet sh=null;
			
			try {
				
			

			FileInputStream ip=new FileInputStream("./com\\MavenTestdata\\vTiger.xlsx");
			Workbook wb=  WorkbookFactory.create(ip);
			sh=wb.getSheet(sheetName);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			return sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
			
		}


	}


