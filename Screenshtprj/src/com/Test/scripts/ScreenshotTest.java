package com.Test.scripts;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenshotTest {
	
	public  static void main(String[] args) throws IOException
			
	{
			Date d = new Date();
	        
	        
//	        String time=d.toString();
//	        System.out.println(time);
//	        
//	        String[] dates=time.split(" ");
//	        String month=dates[1];
//	        String day=dates[2];
//	        String times=dates[3];
//	        String year	=dates[5];
//	        
//	        System.out.println(dates);
	        String time= d.toString().replace(":","-").replace(" ", "-");
	        System.out.println(time);
	        
	        
	        //launch browser and enter url
	        WebDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://google.com");
            EventFiringWebDriver ewfd= new EventFiringWebDriver(driver);
            
            File src = ewfd.getScreenshotAs(OutputType.FILE);
            File dst = new File("./Screenshot/"+time+".png");
            FileUtils.copyFile(src, dst);
	        

}
}

