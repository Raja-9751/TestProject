package com.testdata.allure;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumNewTest {
 
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 1)
	  public void logoPresenceTest() {
		boolean disStatus= driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
		Assert.assertEquals(disStatus,true);
	  }
	
//	@Test(priority = 2)
//	  public void loginTest() {
//		driver.findElement(By.linkText("Log in")).click();
//		driver.findElement(By.id("Email")).sendKeys("rajarajesh9751@gmail.com");
//		driver.findElement(By.id("Password")).sendKeys("Test@12");
//		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
//		
//		Assert.assertEquals(driver.getTitle(),"nopCommerce demo store123");
//	  }
//	
//	@Test(priority = 3)
//	  public void regTst() {
//		throw new SkipException("Skipping this Test");
//	  }
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
