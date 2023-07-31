package com.testngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng {
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setup() {
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void OrangeHRM_LoginPage() {
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[text()=' Login ']")).click();
		System.out.println("Success");
	}
	@Test(dependsOnMethods = {"OrangeHRM_LoginPage"})
	public void OrangeHRM_LogoutPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown-name']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Logout']")).click();
	}
	@Test(description = "validation of url")
	public void url() {
		String actualurl=driver.getCurrentUrl();
		String expectedurl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actualurl, expectedurl);
	}
	@Test(description = "validation of Title")
	public void title() {
		String actualtitle=driver.getTitle();
		String expectedtitle="OrangeHRM";
		Assert.assertEquals(actualtitle, expectedtitle);
	}
	@AfterTest
	public void close() {
		driver.close();
	}

}
