package com.rd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest {

	private WebDriver driver;       
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver(); 
		driver.get("http://www.guru99.com/selenium-tutorial.html"); 
	}

	@AfterTest
	public void afterTest() {
		driver.quit(); 
	}
	
	@Test              
	public void testTitle() {    
 
		String title = driver.getTitle();                
		Assert.assertTrue(title.contains("Free Selenium Tutorials"));       
	}  
	
	@Test   
	public void testText() {    
		WebElement page = driver.findElement(By.xpath("//*[@id='rt-mainbody']/div/article/h2"));              
		Assert.assertTrue(page.getText().contains("Free Selenium Tutorials"));       
	}  
}

