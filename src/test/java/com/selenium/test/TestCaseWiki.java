package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;
import com.selenium.page.WikiHomePage;
import com.selenium.driver.DriverFactory;
import com.selenium.page.WikiHomePage;
import com.selenium.page.WikiResultadoPage;

public class TestCaseWiki {

	WebDriver driver;
	
	@DataProvider(name = "datos")
	public Object[][] createData() {
	 return new Object[][] {
	   { "Selenium","Selenium"},
	   {  "TDD", "Desarrollo guiado por pruebas"},
	   {  "JAVA", "Java (lenguaje de programación)"},
	   {"DATA DRIVEN TESTING","Data-driven testing"}
	 };
	}

//@DataProvider(name = "DatosNuevos")
//
//public Object[][] DatosNuevos() throws Exception {
//	 int iTestCaseRow;
//
//	String excelPath = "src\\Resources\\Recursos\\Data\\TestData.xlsx";
//	String hoja = "Sheet1";
//	ExcelUtils.setExcelFile(excelPath, hoja);
//	iTestCaseRow = ExcelUtils.getRowUsed();
//	Object[][] testObjArray = ExcelUtils.getTableArray(excelPath, hoja, iTestCaseRow, 2);
//	return (testObjArray);
//}

//TODO "Crar un metodo para obtener datos externos"	
	
@BeforeMethod
public void abrirBrowser(ITestContext context) {

	driver = DriverFactory.LevantarBrowser(driver, context);
}

@Test(dataProvider = "datos", description = "Validar y verificar que Wikipedia Home Page contiene el campo de busqueda")
public void validarCajaTextoNuevo(String varBuscar, String resultado) throws Exception {
	WikiHomePage wikihomepage = PageFactory.initElements(driver, WikiHomePage.class);
	wikihomepage.IngresarDatoCajaBusqueda(varBuscar);
	Reporter.log("Validar que el titulo sea " + resultado);
	WikiResultadoPage wikiRdopage = PageFactory.initElements(driver, WikiResultadoPage.class);

	//Assert.assertTrue((driver.getCurrentUrl().contains(resultado)), "No contiene" + resultado);
	Reporter.log("Validar que el titulo sea " + varBuscar);
	Assert.assertTrue((wikiRdopage.ObtenerTitulo().contains(resultado)),
			"el valor " + resultado + " no se encontro en el titulo"+ wikiRdopage.ObtenerTitulo().toString());

}


@AfterMethod
public void CerrarBrowser() {
	Reporter.log("Cerrar Browser");
	DriverFactory.FinalizarBrowser(driver);

}
	
}
