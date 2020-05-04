package com.vTigerCRM.genericLib;

import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ListenersTS extends Base implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {

		String methodname= result.getMethod().getMethodName();
		
		Date d = new Date();
//		String time=d.toString();
//		String[] dates=time.split("");
//		System.out.println(dates);
//		String day=dates[2];
//		String month=dates[1];
//		String year=dates[5];
//		String timews=dates[3];
		
//		String datews=day.concat(day).concat(month).concat(year).concat(timews).replace(":", "-");
		String datews=d.toString().replace(":", "-");
		EventFiringWebDriver efd=new EventFiringWebDriver(Base.staticdriver);
		
		File src = efd.getScreenshotAs(OutputType.FILE);
		File dst= new File("./Screenshot/"+methodname+datews+".png");
		
		
		try {
			FileUtils.copyFile(src,dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
