package com.elearn;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExIntegration extends Elearn {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", 
		"C:\\Users\\USER\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/Register.php");
		
		driver.findElement(By.name("username")).sendKeys(getData(1, 0));
		driver.findElement(By.id("password")).sendKeys(getData(1, 2));
		driver.findElement(By.id("re_password")).sendKeys(getData(1, 2));
		driver.findElement(By.id("full_name")).sendKeys(getData(1, 1));
		driver.findElement(By.id("email_add")).sendKeys(getData(1, 3));

		
		
		
}}



//driver.findElement(By.name("login")).click();