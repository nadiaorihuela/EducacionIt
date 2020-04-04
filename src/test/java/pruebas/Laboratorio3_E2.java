package pruebas;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import paginas.paginaInicio;
import paginas.paginaLogin;


public class Laboratorio3_E2 {
    WebDriver driver;
	String driverPath = "..\\EducacionIt\\Drivers\\chromedriver.exe";
    String urlTest ="http://automationpractice.com/index.php";
   


 @BeforeSuite
    public void setup(){
  	//Propiedades para Ejecutar el driver de Chrome
  			System.setProperty("webdriver.chrome.driver",driverPath);
  			//instanciar Driver de Chrome + importar libreria org.openqa.selenium.chrome.ChromeDriver
  			driver= new ChromeDriver();
  			System.out.println("Inicio de suite de pruebas"); 
  			

         driver.get(urlTest);

     }  
@Test (priority=0)
 public void irRegistroLogin(){
	 paginaInicio objInicio=new paginaInicio(driver);
 	 objInicio.clickLogin();
	 
	 paginaLogin objLogin=new paginaLogin(driver);
	 String titulo=objLogin.getTextTitleForm();
		  
	 Assert.assertEquals(titulo,"Authentication");

	    
 } 
 
 @Test(priority=1, description="Prueba de creación de cuenta inválida")

  public void crearCuentaInvalida() throws IOException{
	 paginaLogin objLogin=new paginaLogin(driver);
	 
	 objLogin.sendKeysEmail("dasdasd");
	 objLogin.clickCreate(); 
	 
	 String titulo=objLogin.getTextTitleForm();
	 
	 Assert.assertEquals(titulo,"Authentication");
	 File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Test.png"));

  }
 


  @AfterTest
  public void afterClass() {
	 driver.quit();
  }


}
