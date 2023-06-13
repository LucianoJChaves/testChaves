package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.MetodosUtiles.Utiles;


import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.selenium.driver.DriverFactory;
import com.selenium.page.WikiHomePage;
import com.selenium.page.WikiResultadoPage;

public class TestGmail {

	
	WebDriver driver;
	@BeforeMethod	
	public void abrirBrowser(ITestContext context) {
		driver = DriverFactory.LevantarBrowser(driver, context);
	}
	
	
	@AfterMethod
	public void CerrarBrowser() {
		Utiles.escribir("Cerrar Browser");
		DriverFactory.FinalizarBrowser(driver);
	}
		
	@Test(description = "Abrir link Más Información")
	public void ValidarBusquedaGmail() throws Exception { 

	
	Utiles.escribir("Presionar el botón Acceder");
	WebElement btnAcceder = driver.findElement(By.xpath("//a[contains(text(),'Acceder')]")); 
	btnAcceder.click();
	
	Thread.sleep(2000);
	Utiles.escribir("Presionar el link Más Información");
	WebElement lkMasInformacion = driver.findElement(By.xpath("//a[contains(text(),'Más información')]"));
	Thread.sleep(2000);
	Assert.assertTrue(lkMasInformacion.isDisplayed(),"No se mostró el link Más Información");
	Assert.assertTrue(lkMasInformacion.getText().contains("Más información"),"No se visualizó link Más información");
	lkMasInformacion.click();
	
	Utiles.escribir("Se redirige a una nueva pestaña");
	Utiles.escribir("Cerrar la pestaña nueva");
	String[] windowHandles = driver.getWindowHandles().toArray(new String[0]);
	driver.switchTo().window(windowHandles[1]);
	Thread.sleep(2000);
	driver.close();
	Utiles.escribir("Volver a la ventana inicial para poder cerrar el navegador");
	driver.switchTo().window(windowHandles[0]);
	
}
}