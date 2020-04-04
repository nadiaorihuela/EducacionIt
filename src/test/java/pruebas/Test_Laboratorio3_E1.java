package pruebas;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Laboratorio3_E1 {
	WebDriver driver;
    String driverPath = "..\\EducacionIt\\Drivers\\chromedriver.exe";
    String urlTest ="https://www.facebook.com/";
    
@BeforeSuite

public void setUp(){
	//Propiedades para Ejecutar el driver de Chrome
	System.setProperty("webdriver.chrome.driver",driverPath);
	
	driver= new ChromeDriver();
	System.out.println("Inicio de suite de pruebas"); 
	
	}
@BeforeTest

	public void IrURL(){
	System.out.println("Ingresando a url:" + urlTest); 
	driver.get(urlTest);
}
@BeforeClass

	public void maximizarNavegador(){

	driver.manage().window().maximize();
	System.out.println("Inicio de caso de prueba:"); 
	}

@Test(enabled = false,description="Prueba de link Descarga")
	public void verificarLink(){
		WebElement lnkDescarga=driver.findElement(By.linkText("Downloads"));
		lnkDescarga.getText();
		Assert.assertEquals("Downloads", lnkDescarga.getText());
		
	}

@Test(description="Prueba registro faceebook fail")
public void registroFacebook(){
	
	WebDriverWait myWait = new WebDriverWait(driver, 18);
	//Nombre de usuario
	WebElement txtNombre=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("firstname"))));
			txtNombre.sendKeys("Rosa");
	//Apellido de usuario
	WebElement txtApe=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='u_0_o']"))));
	txtApe.sendKeys("Argento");
	
	//Email o telefono
	WebElement txtMailTel=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("reg_email__"))));
	txtMailTel.sendKeys("dasdasdasd");
	
	//Contraseña
	WebElement txtContrasena=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("u_0_w"))));
	txtContrasena.sendKeys("12345678");
	
	//Desplegable Mes
		Select dropMes=new Select(myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("month")))));
	dropMes.selectByValue("5");
	
	//Sexo
	WebElement radSex=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(@type,'radio') and @value=1 ]"))));
	radSex.click();
	
	//Boton Registrar
	WebElement btnRegistrar=myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//button[text()='Registrarte'])[1]"))));
	btnRegistrar.click();
	
	Assert.assertEquals(driver.getCurrentUrl(), urlTest);
}

@AfterTest
public void cerrarPagina() throws InterruptedException{

	//driver.quit();
}

@AfterSuite
public void finSuite(){
	System.out.println("Fin de suite de pruebas"); 
}

}
