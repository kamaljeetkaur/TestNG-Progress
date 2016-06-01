package com.rd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rd.listener.TestListener;

@Listeners(TestListener.class)
public class NewTest extends WebDriverManager {

	@BeforeTest
	public void beforeTest() {
		driver = startDriver();
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

/*	@Test   
	public void testText() throws Exception {    
			WebElement page = driver.findElement(By.xpath("//*[@id='rt-mainbody']/div/article/h2"));              
			Assert.assertTrue(page.getText().contains("1Free Selenium Tutorials")); 
			driver.findElement(By.id("testing")).sendKeys("test");
	}*/
	
}
