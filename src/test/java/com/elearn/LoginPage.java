package com.elearn;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
//	WebElement txt = driver.findElement(By.id("email"));
	
	@FindBy(id="email")
	private WebElement txt;
		
	public WebElement getTxt() {
		return txt;
	}
	@FindBy(id="pass")
	private WebElement pass;

	public WebElement getPass() {
		return pass;
	}
	@FindBy(name="login")
	private WebElement btn;

	public WebElement getBtn() {
		return btn;
	}

	
}
	

	


	
		

