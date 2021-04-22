package com.elearn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sample extends BaseClass  {

	public static void main(String[] args) throws Exception {
		
		getChromeDriver();
		launchUrl("https://www.facebook.com");
		
		insertKeys(new LoginPage().getTxt(),getData(1, 1));
		
		insertKeys(new LoginPage().getPass(),getData(1, 2));
		
		click(new LoginPage().getBtn());
		
	}
}
