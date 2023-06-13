package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.MetodosUtiles.Utiles;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.selenium.driver.DriverFactory;
import com.selenium.page.GoogleHomePage;
import com.selenium.page.GoogleResultadoPage;

public class TestGoogle {


	
	WebDriver driver;
	@BeforeMethod	
	public void abrirBrowser(ITestContext context) {
		Utiles.escribir("Inicializando Browser");
		Utiles.escribir("Ir a la página https://www.google.com/");
		driver = DriverFactory.LevantarBrowser(driver, context);
		Assert.assertTrue(driver.getCurrentUrl().contains("google"),"No es google");
	}
	

	
	@AfterMethod
	public void CerrarBrowser() {
		Utiles.escribir("Cerrar Browser");
		DriverFactory.FinalizarBrowser(driver);
	}
	
	
	@DataProvider(name = "datos")
	public Object[][] createData() {
	 return new Object[][] {
	   { "UTN Córdoba","UTN-FRC - Universidad Tecnológica Nacional"},
	   {  "FCE Córdoba", "Facultad de Ciencias Económicas - Universidad Nacional de ..."},
	   {"universidad católica de córdoba","UCC: Universidad Católica de Córdoba"} 
	};
	}
	
	
	
	
	
	@Test(dataProvider= "datos",description = "Validar que las busquedas en Google funcionan")
	public void ValidarBusquedaGoogle(String varBuscar, String resultado) throws Exception { 
		GoogleHomePage googlehomepage = PageFactory.initElements(driver, GoogleHomePage.class);
		googlehomepage.IngresarDatoCajaBusqueda(varBuscar);
		Reporter.log("Validar que el titulo sea " + resultado);
		GoogleResultadoPage googleRdopage = PageFactory.initElements(driver, GoogleResultadoPage.class);
		googleRdopage.clickFirstResult();
		
		
	/*Utiles.escribir("Validar que se muestre el título Google");	
	WebElement lbltitulo = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/img[1]"));
	Assert.assertTrue(lbltitulo.isDisplayed(),"No se muestra el título Google");	
	
	Utiles.escribir("Buscar el elemento Web Caja de texto");
	WebElement txtbusqueda = driver.findElement(By.id("APjFqb"));
	Utiles.escribir("Verificar que esté desplegada la caja de búsqueda");
	Assert.assertTrue(txtbusqueda.isDisplayed(),"La caja de búsqueda no está desplegada");
	Utiles.escribir("Verificar que la caja de tecto esté vacía");
	Assert.assertTrue(txtbusqueda.getText().toString().isEmpty(),"La caja de texto no está vacía");
	
	
	Utiles.escribir("Ingresar el texto UTN Córdoba");
	txtbusqueda.sendKeys(varBuscar);
	Utiles.escribir("El contenido de la caja de texto es "+txtbusqueda.getText().toString());
	Utiles.escribir("Presionar Enter");
	txtbusqueda.submit();
	
	Utiles.escribir("Ingresar al 1° Resultado de búsqueda");
	WebElement primerResultado = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
	System.out.println("Texto encontrado "+ primerResultado.getText()); 
	Assert.assertTrue(primerResultado.isDisplayed(),"El resultado no es desplegado");
	Assert.assertTrue(primerResultado.getText().contains(resultado),"No se visualizó el resultado "+primerResultado.getText().toString());
	Utiles.escribir("Verificar que el título sea desplegado");
		
	Utiles.escribir("Ingresar a la página de "+primerResultado.getText());
	primerResultado.click();
	//Utiles.escribir("Validar que la URL corresponda a la página de "+resultado);
	//Assert.assertTrue(driver.getCurrentUrl().contains("frc.utn"),"No es la página de la UTN");
	*/	
}
}