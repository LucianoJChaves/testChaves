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
import org.openqa.selenium.support.ui.Select;

import com.selenium.MetodosUtiles.Utiles;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.selenium.driver.DriverFactory;
import com.selenium.page.WikiHomePage;
import com.selenium.page.WikiResultadoPage;


public class TestWiki {





	WebDriver driver;
	@BeforeMethod
	public void abrirBrowser(ITestContext context) {
		Utiles.escribir("Inicializando Browser");
		Utiles.escribir("Ir a la página http://wikipedia.org");
		driver = DriverFactory.LevantarBrowser(driver, context);
		Assert.assertTrue(driver.getCurrentUrl().contains("wikipedia"),"No es wikipedia");
	}
	
	
	@AfterMethod
	public void CerrarBrowser() {
		Utiles.escribir("Cerrar Browser");
		DriverFactory.FinalizarBrowser(driver);
	}

	@DataProvider(name = "datos")
	public Object[][] createData() {
	 return new Object[][] {
	   { "Selenium","Selenium"},
	   {  "TDD", "Desarrollo guiado por pruebas"},
	   {"DATA DRIVEN TESTING","Data-driven testing"} 
	};
	}
	
	

	@Test(dataProvider = "datos", description = "Validar que las busquedas en Wikipedia cambiando el idioma")
	public void ValidarBusquedaWikipedia(String varBuscar, String resultado) throws Exception { 
	
	Utiles.escribir("Buscar el elemento Web Caja de texto");
	WebElement searchInput = driver.findElement(By.id("searchInput")); 		
	Utiles.escribir("Verificar que esté desplegada la caja de búsqueda");
	Assert.assertTrue(searchInput.isDisplayed(),"La caja de búsqueda no se encuentra visible"); 
	
	
	Utiles.escribir("El contenido de la caja de texto es "+searchInput.getText().toString());
	Assert.assertTrue(searchInput.getText().toString().isEmpty(),"La caja de texto no está vacía");
	Utiles.escribir("Ingresar el texto Selenium");
	searchInput.sendKeys(varBuscar);
	Utiles.escribir("Presionar Enter");
	searchInput.submit();
	
	
	Thread.sleep(2000);
	Utiles.escribir("Buscar el título");
	WebElement validarTitulo = driver.findElement(By.id("firstHeading"));
	Utiles.escribir("El contenido del título es "+validarTitulo.getText().toString());
	Assert.assertTrue(validarTitulo.getText().contains(resultado));
	Utiles.escribir("Texto encontrado "+ validarTitulo.getText()); 
	Utiles.escribir("Verificar que el título sea desplegado");
	Assert.assertTrue(validarTitulo.isDisplayed(),"El título no está visuble");
	
}
	
	
	
	@Test(description = "Verificar que los elementos se muestren")
	public void ValidarBusquedaWikipedia2() throws Exception { 
	
	Utiles.escribir("Buscar el elemento Web Caja de texto");
	WebElement searchInput = driver.findElement(By.id("searchInput")); 		
	Utiles.escribir("Verificar que esté desplegada la caja de búsqueda");
	Assert.assertTrue(searchInput.isDisplayed(), "La caja de texto no está visible"); 
	
			
	Utiles.escribir("Verificar Elemento Español");		
	Thread.sleep(2000);
	WebElement lkEspaniol = driver.findElement(By.xpath("//a[@id='js-link-box-es']/strong"));
	Assert.assertTrue(lkEspaniol.getText().contains("Español"),"El link no corresponde al idioma Español");		
	Assert.assertTrue(lkEspaniol.isDisplayed(),"No se mostró el link en Español");
	
	Utiles.escribir("Verificar Elemento Inglés");
	Thread.sleep(2000);
	WebElement lkEnglish = driver.findElement(By.xpath("//a[@id='js-link-box-en']/strong"));
	Assert.assertTrue(lkEnglish.getText().contains("English"),"El link no corresponde al idioma Inglés");
	Assert.assertTrue(lkEnglish.isDisplayed(),"No se mostró el link en Inglés");
	
	Utiles.escribir("Verificar Elemento Italiano");
	Thread.sleep(2000);
	WebElement lkItaliano = driver.findElement(By.xpath("//a[@id='js-link-box-it']/strong"));
	Assert.assertTrue(lkItaliano.getText().contains("Italiano"),"El link no corresponde al idioma Italiano");
	Assert.assertTrue(lkItaliano.isDisplayed(),"No se mostró el link en Italiano");
	
	Utiles.escribir("Verificar Elemento Francés");
	Thread.sleep(2000);
	WebElement lkFrances = driver.findElement(By.xpath("//a[@id='js-link-box-fr']/strong"));
	Assert.assertTrue(lkFrances.getText().contains("Français"),"El link no corresponde al idioma Francés");
	Assert.assertTrue(lkFrances.isDisplayed(),"No se mostró el link en Francés");
	
	Utiles.escribir("Verificar Elemento Portugués");
	Thread.sleep(2000);
	WebElement lkPortugues = driver.findElement(By.xpath("//a[@id='js-link-box-pt']/strong"));
	Assert.assertTrue(lkPortugues.getText().contains("Português"),"El link no corresponde al idioma Portugués");
	Assert.assertTrue(lkPortugues.isDisplayed(),"No se mostró el link en Portugués");
	
	Utiles.escribir("Verificar Botón Leer Wikipedia en tu idioma");
	WebElement btnLeerWikiEnTuIdioma = driver.findElement(By.xpath("//span[contains(text(),'Leer Wikipedia en tu idioma')]"));
	Assert.assertTrue(btnLeerWikiEnTuIdioma.getText().contains("Leer Wikipedia en tu idioma"),"El botón no dice Leer Wikipedia en tu idioma");
	Assert.assertTrue(btnLeerWikiEnTuIdioma.isDisplayed(),"No se mostró el botón Leer Wikipedia en tu idioma");
	
	Utiles.escribir("Desplegar Lista de Leer Wikipedia en tu idioma");
	Select selectbuscar = new Select(driver.findElement(By.id("searchLanguage")));
	for (WebElement e : selectbuscar.getOptions()) {
        System.out.println(e.getText());
        if (e.getText().contains("English")) {
            e.click();
            break;
        }
    }
	
	Thread.sleep(2000);
	
	
	Utiles.escribir("Verificar Combo cambio idioma en Botón Leer Wikipedia en tu idioma ");
	WebElement cboCambioIdioma = driver.findElement(By.xpath("//body/div[4]/button[1]/i[2]"));
	Assert.assertTrue(cboCambioIdioma.isDisplayed(),"No se mostró el Combo para cambio de idioma en botón Leer Wikipedia en tu idioma");
	cboCambioIdioma.click();
	Assert.assertTrue(cboCambioIdioma.isEnabled(), "El combo no está habilitado");
			
	Utiles.escribir("Verificar link Commons");
	WebElement lkCommons = driver.findElement(By.xpath("//span[contains(text(),'Commons')]"));
	Assert.assertTrue(lkCommons.isDisplayed(),"No se mostró el link Commons");		
	
	Utiles.escribir("Verificar link WikiViajes");
	WebElement lkWikiviajes = driver.findElement(By.xpath("//span[contains(text(),'Wikiviajes')]"));
	Assert.assertTrue(lkWikiviajes.isDisplayed(),"No se mostró el link WikiViajes");
	
	Utiles.escribir("Verificar link Wikcionario");
	WebElement lkWikcionario = driver.findElement(By.xpath("//span[contains(text(),'Wikcionario')]"));
	Assert.assertTrue(lkWikcionario.isDisplayed(),"No se mostró el link Wikcionario");
	
	Utiles.escribir("Verificar link Wikidata");
	WebElement lkWikidata = driver.findElement(By.xpath("//span[contains(text(),'Wikidata')]"));
	Assert.assertTrue(lkWikidata.isDisplayed(),"No se mostró el link Wikidata");
	
	Utiles.escribir("Verificar link MetaWiki");
	WebElement lkMetaWiki = driver.findElement(By.xpath("//span[contains(text(),'Meta-Wiki')]"));
	Assert.assertTrue(lkMetaWiki.isDisplayed(),"No se mostró el link MetaWiki");
	
	Utiles.escribir("Verificar link Google Play Store");
	WebElement lkGooglePlayStore = driver.findElement(By.xpath("//span[contains(text(),'Google Play Store')]"));
	Assert.assertTrue(lkGooglePlayStore.isDisplayed(),"No se mostró el link Google Play Store");
	
	Utiles.escribir("Verificar link Apple Store");
	WebElement lkAppStore = driver.findElement(By.xpath("//span[contains(text(),'Tienda de aplicaciones de Apple')]"));
	Assert.assertTrue(lkAppStore.isDisplayed(),"No se mostró el link Apple Store");
	
	Utiles.escribir("Verificar link Licencia");
	WebElement lkLicencia = driver.findElement(By.xpath("//a[contains(text(),'licencia Creative Commons Atribución-CompartirIgua')]"));
	Assert.assertTrue(lkLicencia.isDisplayed(),"No se mostró el link Licencia");
	
	Utiles.escribir("Verificar link Términos de Uso");
	WebElement lkTermUso = driver.findElement(By.xpath("//a[contains(text(),'Términos de uso')]"));
	Assert.assertTrue(lkTermUso.isDisplayed(),"No se mostró el link Términos de uso");
	
	Utiles.escribir("Verificar link Privacidad");
	WebElement lkPrivacidad = driver.findElement(By.xpath("//a[contains(text(),'Normativa de privacidad')]"));
	Assert.assertTrue(lkPrivacidad.isDisplayed(),"No se mostró el link Privacidad");
	
	Utiles.escribir("Verificar link Puedes apoyar nuestro trabajo con una donación.");
	WebElement lkApoyoDonacion = driver.findElement(By.xpath("//span[contains(text(),'Puedes apoyar nuestro trabajo con una donación.')]"));
	Assert.assertTrue(lkApoyoDonacion.isDisplayed(),"No se mostró el link Puedes apoyar nuestro trabajo con una donación");
	Assert.assertTrue(lkApoyoDonacion.getText().contains("Puedes apoyar nuestro trabajo con una donación."),"En el link no se visualiza el texto Puedes apoyar nuestro trabajo con una donación.");		
	
	}

}






