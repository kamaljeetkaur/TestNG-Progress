package com.rd.listener;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.rd.WebDriverManager;

public class TestListener implements ITestListener {
	WebDriver driver=null;
	String filePath = "D:\\SCREENSHOTS";
	String file = System.getProperty("user.dir")+"\\"+"screenshot"+ (new Random().nextInt())+".png"; 

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");
		
		try {
			WebDriverManager.takeSnapShot(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	


public void onFinish(ITestContext context) {System.out.println("END Of Execution(TEST)->"+context.getName());}

public void onTestStart(ITestResult result) {  System.out.println("Test Started->"+result.getName());  }

public void onTestSuccess(ITestResult result) {  System.out.println("Test Pass->"+result.getName()); }

public void onTestSkipped(ITestResult result) {System.out.println("Test Skipped->"+result.getName());   }

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

public void onStart(ITestContext context) {System.out.println("Start Of Execution(TEST)->"+context.getName());
}
}  
