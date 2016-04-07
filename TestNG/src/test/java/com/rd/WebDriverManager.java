package com.rd;

import java.io.BufferedWriter;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class WebDriverManager {
  protected static WebDriver driver;
	
	public static WebDriver getDriverInstance() {
		return driver;
	}
	
	public static WebDriver startDriver() {
		driver = new FirefoxDriver();
		return driver;
	}
	
	public static void stopDriver() {
		driver.close();
	}
	
	 public static void takeSnapShot(String fileWithPath) throws Exception{
		 
		 	BufferedWriter writer = null;
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			
	        TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(fileWithPath);
	        FileUtils.copyFile(SrcFile, DestFile);
	        
			
			//scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(scrFile, new File(failureImageFileName));
			
			String s1 = "<table><tr><td><font style=\"text-decoration: underline;\" size=\"3\" face=\"Comic sans MS\" color=\"green\"><b>Screenshot</b></font></td></tr> ";
			Reporter.log(s1);
			Reporter.log("<tr><td>"
					+ "<a href=\"" + fileWithPath +"\">"
					+ "<img src=\"file:///" + fileWithPath + "\" alt=\"\""
					+ "height='120' width='120'/>"
					+ "</td> </tr> ");
			Reporter.setCurrentTestResult(null);	
	    }
}