package com.selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.selenium.MetodosUtiles.Utiles;

public class GmailHomePage {
	WebDriver driver;
	/**Contructor que en este caso utiliza el driver enviado
	por parametro**/
	public GmailHomePage (WebDriver ldriver) {
	driver = ldriver;
}
	// ***** IDENTIFICAMOS LOS ELEMENTOS POR SU LOCATOR EJEMPLO ID O XPATH
	@FindBy(xpath = "//a[contains(text(),'Acceder')]")
	private WebElement btnAcceder;
	public void ClickEnAcceder() throws Exception {
	btnAcceder.click();
	}	
	}

