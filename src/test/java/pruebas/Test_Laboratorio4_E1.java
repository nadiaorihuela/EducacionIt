package pruebas;

import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.paginaInicio;
import paginas.paginaLogin;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class Test_Laboratorio4_E1 {
	WebDriver driver;
	String driverPath = "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlTest = "http://automationpractice.com/index.php";

	@BeforeSuite
	public void setup() {
		// Propiedades para Ejecutar el driver de Chrome
		System.setProperty("webdriver.chrome.driver", driverPath);
		// instanciar Driver de Chrome + importar libreria
		// org.openqa.selenium.chrome.ChromeDriver
		driver = new ChromeDriver();
		System.out.println("Inicio de suite de pruebas");

		driver.get(urlTest);

	}

	@Test(dataProvider = "Prueba login")
	public void crearCuentaInvalida(String email) throws IOException {
		paginaInicio objInicio = new paginaInicio(driver);
		objInicio.clickLogin();

		paginaLogin objLogin = new paginaLogin(driver);

		objLogin.sendKeysEmail(email);
		objLogin.clickCreate();

		String titulo = objLogin.getTextTitleForm();

		Assert.assertEquals(titulo, "Authentication");
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionIt\\Evidencias\\Test.png"));

	}

	@DataProvider(name = "Prueba login")
	public Object[][] dp() throws Exception {
		String rutaExcel="..\\EducacionIt\\Recursos\\Datos.xlsx";
		String Hoja="Hoja1";
		
		
		Object[][] datos = DatosExcel.leerExcel(rutaExcel, Hoja);
		
		
		return datos;

	}
}
