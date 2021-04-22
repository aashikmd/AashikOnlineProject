package com.elearn;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {
	public static WebDriver driver;
	public static void getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
	public static Actions action;
	public static WebElement moveToElement(WebElement ref) {
		action = new Actions(driver);
		action.moveToElement(ref).perform();;
		return ref;
	}
	public static void tick(WebElement ele) {
		action.tick();
	}
	public static void launchUrl(String url) {
			driver.get(url); 
		}
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	public static String getTitle() {
		return driver.getTitle();
		}
	public static String windowHandle() {
		return driver.getWindowHandle();
			}
	public static void insertKeys(WebElement ele, String value) {
		ele.sendKeys(value);
		}
	public static void click(WebElement ele) {
		ele.click();
	}
	public static void clear(WebElement ele) {
		ele.clear(); 
	}
	public static String getTextValue(WebElement ele) {
		return ele.getText();
	}
	public static String getAttributeValue(WebElement ele) {
		return ele.getAttribute("value");
	}
	public static String getTagName(WebElement ele) {
		return ele.getTagName();
	}
	public static void closeBroswer() {
		driver.close();
	}
	public static void quitBrowser() {
		driver.quit();
	}
	public static void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}
	public static void switchToFrames(String value) {
		driver.switchTo().frame(value);
	}
//	public static void takeScreenShot() throws IOException {
//		TakesScreenshot screenShot = (TakesScreenshot) driver;
//		File source = screenShot.getScreenshotAs(OutputType.FILE);
//		File desti = new File("D:\\ScreenShot By Selenium\\shot.jpg");
//		FileUtils.copyFile(source, desti);
//	}
	public static void scrollDown(WebElement ref) {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView(true)", ref);
	}
	public static void scrollUp(WebElement ref) {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView(false)", ref);
	}	
	public static void alertOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public static void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
//	public static WebElement dragDrop() {
//		action.dragAndDrop(source, desti).perform();
//		return (WebElement) action.dragAndDrop(source, target);
//	}
	public static void rightClick(WebElement target) {
		action.contextClick(target);
		}
	
//	public static WebElement doubleClick() {
//		return action.doubleClick().perform();
//	}
	public static String getData(int row, int cell) throws Exception {
		
		File f = new File("C:\\Users\\USER\\eclipse-workspace\\Frames\\InputSheet\\TestData.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Sheet1");
		
		Row r = s.getRow(row); Cell c = r.getCell(cell);
		int cellType = c.getCellType();
		System.out.println(cellType);
		
		String value = null;
		
		if (cellType==1) { value = c.getStringCellValue();
			System.out.println(value);}
		else if (cellType==0) { if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			System.out.println(dateCellValue);
			SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
			value = sim.format(dateCellValue);
			System.out.println(value);
			} else { double numericCellValue = c.getNumericCellValue();
				long l =  (long) numericCellValue;
				value = String.valueOf(l);
				System.out.println(value);
				}}
		return value;}}	

