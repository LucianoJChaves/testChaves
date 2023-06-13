package com.selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.selenium.MetodosUtiles.Utiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class GoogleResultadoPage {
WebDriver driver;
	
	public GoogleResultadoPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}


	@FindBy (css =".LC20lb.MBeuO.DKV0Md")
	private WebElement primerResultado;

	public void clickFirstResult() throws Exception {
	Utiles.escribir("Ingresar al 1° Resultado de búsqueda");
	primerResultado.click();
	}
	
}
