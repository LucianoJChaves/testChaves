package com.selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.selenium.MetodosUtiles.Utiles;

public class GoogleHomePage {
	WebDriver driver;
	/**Contructor que en este caso utiliza el driver enviado
	por parametro**/
	public GoogleHomePage(WebDriver ldriver) {
	driver = ldriver;
}
	// ***** IDENTIFICAMOS LOS ELEMENTOS POR SU LOCATOR EJEMPLO ID O XPATH

	@FindBy(id = "APjFqb")
	private WebElement cajaBusqueda;
	
	public void IngresarDatoCajaBusqueda ( String dato)
	{
		cajaBusqueda.sendKeys(dato);
		cajaBusqueda.sendKeys(Keys.ENTER);
	}


		
	@FindBy (css =".LC20lb.MBeuO.DKV0Md")
	private WebElement primerResultado;

	public void clickFirstResult() throws Exception {
	Utiles.escribir("Ingresar al 1° Resultado de búsqueda");
	primerResultado.click();
	}
	       
	    }
	

	
	
	
	


